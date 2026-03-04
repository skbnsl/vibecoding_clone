package com.application.vibecoding.vibecoding.service.Impl;

import com.application.vibecoding.vibecoding.dto.member.InviteMemberRequest;
import com.application.vibecoding.vibecoding.dto.member.MemberResponse;
import com.application.vibecoding.vibecoding.dto.member.UpdateMemberRoleRequest;
import com.application.vibecoding.vibecoding.entity.Project;
import com.application.vibecoding.vibecoding.entity.ProjectMember;
import com.application.vibecoding.vibecoding.entity.ProjectMemberId;
import com.application.vibecoding.vibecoding.entity.User;
import com.application.vibecoding.vibecoding.mapper.ProjectMemberMapper;
import com.application.vibecoding.vibecoding.repository.ProjectMemberRepository;
import com.application.vibecoding.vibecoding.repository.ProjectRepository;
import com.application.vibecoding.vibecoding.repository.UserRepository;
import com.application.vibecoding.vibecoding.service.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectMemberRepository projectMemberRepository;
    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMemberMapper projectMemberMapper;

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);


        //memberResponseList.add(projectMemberMapper.toProjectMemberResponseFromOwner(project.getOwner()));

        List<MemberResponse> memberResponseList  = projectMemberRepository.findByIdProjectId(projectId)
                .stream()
                .map(projectMemberMapper::toProjectMemberResponseFromMember)
                .toList();

        return memberResponseList;
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {

        Project project = getAccessibleProjectById(projectId, userId);
       /* if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Only admin can invite members!");
        }*/

        User invitee = userRepository.findByUsername(request.username()).orElseThrow();
        if(invitee.getId().equals(userId)){
            throw new RuntimeException("can not invite yourself!");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, invitee.getId());
        if(projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("cannot invite once again!");
        }

        ProjectMember member = ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .build();

        projectMemberRepository.save(member);

        return projectMemberMapper.toProjectMemberResponseFromMember(member);

    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);

        /*if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not Allowed!");
        }*/

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow();

        projectMember.setProjectRole(request.role());

        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);
        /*if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not Allowed!");
        }*/

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        if(!projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("Member not found in project!");
        }

        projectMemberRepository.deleteById(projectMemberId);
    }

    //INTERNAL METHODS
    public Project getAccessibleProjectById(Long projectId, Long userId) {
        return projectRepository.findAccessibleProjectById(projectId, userId).orElseThrow();
    }
}
