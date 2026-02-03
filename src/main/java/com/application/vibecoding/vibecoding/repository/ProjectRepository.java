package com.application.vibecoding.vibecoding.repository;

import com.application.vibecoding.vibecoding.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
