package com.application.vibecoding.vibecoding.repository;

import com.application.vibecoding.vibecoding.entity.ProjectMember;
import com.application.vibecoding.vibecoding.entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {

    List<ProjectMember> findByIdProjectId(Long projectId);

}
