package com.application.vibecoding.vibecoding.controller;

import com.application.vibecoding.vibecoding.dto.member.InviteMemberRequest;
import com.application.vibecoding.vibecoding.dto.member.MemberResponse;
import com.application.vibecoding.vibecoding.dto.member.UpdateMemberRoleRequest;
import com.application.vibecoding.vibecoding.entity.ProjectMember;
import com.application.vibecoding.vibecoding.service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects/{projectId}/members")
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService; //constructor DI

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getProjectMember(@PathVariable Long projectId){
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.getProjectMembers(projectId, userId));
    }

    @PostMapping
    public ResponseEntity<MemberResponse> inviteMember(@PathVariable Long projectId,
                                                       @RequestBody InviteMemberRequest request){
        Long userId = 1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(
                projectMemberService.inviteMember(projectId, request, userId)
        );
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateMemberRole(@PathVariable Long projectId,
                                                           @PathVariable Long memberId,
                                                           @RequestBody UpdateMemberRoleRequest request){
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.updateMemberRole(projectId,memberId,request,userId));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<MemberResponse> deleteProjectMember(@PathVariable Long projectId,
                                                           @PathVariable Long memberId){
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.deleteProjectMember(projectId,memberId,userId));
    }
}
