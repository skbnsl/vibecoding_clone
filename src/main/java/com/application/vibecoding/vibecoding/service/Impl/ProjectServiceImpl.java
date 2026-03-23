package com.application.vibecoding.vibecoding.service.Impl;

import com.application.vibecoding.vibecoding.dto.project.ProjectRequest;
import com.application.vibecoding.vibecoding.dto.project.ProjectResponse;
import com.application.vibecoding.vibecoding.dto.project.ProjectSummaryResponse;
import com.application.vibecoding.vibecoding.entity.Project;
import com.application.vibecoding.vibecoding.entity.ProjectMember;
import com.application.vibecoding.vibecoding.entity.ProjectMemberId;
import com.application.vibecoding.vibecoding.entity.User;
import com.application.vibecoding.vibecoding.enums.ProjectRole;
import com.application.vibecoding.vibecoding.error.ResourceNotFoundException;
import com.application.vibecoding.vibecoding.mapper.ProjectMapper;
import com.application.vibecoding.vibecoding.repository.ProjectMemberRepository;
import com.application.vibecoding.vibecoding.repository.ProjectRepository;
import com.application.vibecoding.vibecoding.repository.UserRepository;
import com.application.vibecoding.vibecoding.security.AuthUtil;
import com.application.vibecoding.vibecoding.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;
    ProjectMemberRepository projectMemberRepository;
    AuthUtil authUtil;

    @Override
    public List<ProjectSummaryResponse> getUserProjects() {
        Long userId = authUtil.getCurrentUserId();
        /*return projectRepository.findAllAccessibleByUser(userId)
                .stream()
                .map(projectMapper::toProjectSummaryResponse)
                .collect(Collectors.toList());*/

        var projects = projectRepository.findAllAccessibleByUser(userId);
        return projectMapper.toListOfProjectSummaryResponse(projects);

    }

    @Override
    public ProjectResponse createProject(ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();
        /*User owner = userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User", userId.toString()));*/
        User owner = userRepository.getReferenceById(userId);

        Project project = Project.builder()
                .name(request.name())
                //.owner(owner)
                .isPublic(false)
                .build();

        project = projectRepository.save(project);

        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(), owner.getId());
        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();

        projectMemberRepository.save(projectMember);

        //return new ProjectResponse(project.getId(), project.getName(), project.getCreatedAt(), project.getUpdatedAt(), project.getOwner());
        return projectMapper.toProjectResponse(project);
    }

    @Override
    @PreAuthorize("@security.canViewProject(#projectId)") //security is related to SecurityExpression class, beanname of that class
    public ProjectResponse getUserProjectById(Long projectId) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    @PreAuthorize("@security.canEditProject(#projectId)") //security is related to SecurityExpression class, beanname of that class
    public ProjectResponse updateProject(Long projectId, ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);
        /*if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("You are not allowed to update!");
        }*/
        project.setName(request.name());
        project = projectRepository.save(project);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    //@PreAuthorize("@security.hasPermission(#projectId, T(com.application.vibecoding.vibecoding.enums.ProjectPermission()), 'project:delete')")
    @PreAuthorize("@security.canDeleteProject(#projectId)")
    public void softDelete(Long id) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(id, userId);
        /*if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("You are not allowed to delete!");
        }*/
        project.setDeletedAt(Instant.now()); // means project is deleted, if deletedAt is null means project is not deleted
        projectRepository.save(project);
    }

    //INTERNAL METHODS
    public Project getAccessibleProjectById(Long projectId, Long userId){
        return projectRepository.findAccessibleProjectById(projectId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Project"," "));
    }

}
