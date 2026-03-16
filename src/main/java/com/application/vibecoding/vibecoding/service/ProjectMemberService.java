package com.application.vibecoding.vibecoding.service;

import com.application.vibecoding.vibecoding.dto.member.InviteMemberRequest;
import com.application.vibecoding.vibecoding.dto.member.MemberResponse;
import com.application.vibecoding.vibecoding.dto.member.UpdateMemberRoleRequest;
import com.application.vibecoding.vibecoding.entity.ProjectMember;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(Long projectId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request);

    void removeProjectMember(Long projectId, Long memberId);
}
