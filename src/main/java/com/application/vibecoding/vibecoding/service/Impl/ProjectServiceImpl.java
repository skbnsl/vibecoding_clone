package com.application.vibecoding.vibecoding.service.Impl;

import com.application.vibecoding.vibecoding.dto.project.ProjectRequest;
import com.application.vibecoding.vibecoding.dto.project.ProjectResponse;
import com.application.vibecoding.vibecoding.dto.project.ProjectSummaryResponse;
import com.application.vibecoding.vibecoding.entity.Project;
import com.application.vibecoding.vibecoding.entity.User;
import com.application.vibecoding.vibecoding.repository.ProjectRepository;
import com.application.vibecoding.vibecoding.repository.UserRepository;
import com.application.vibecoding.vibecoding.service.ProjectService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;

    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        return List.of();
    }

    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {
        return null;
    }

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        User owner = userRepository.findById(userId).orElseThrow();

        Project project = Project.builder()
                .name(request.name())
                .owner(owner)
                .build();

        project = projectRepository.save(project);

        return new ProjectResponse(project.getId(), project.getName(), project.getCreatedAt(), project.getUpdatedAt(), project.getOwner());
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
        return null;
    }

    @Override
    public void softDelete(Long id, Long userId) {

    }
}
