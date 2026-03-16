package com.application.vibecoding.vibecoding.service;

import com.application.vibecoding.vibecoding.dto.project.ProjectRequest;
import com.application.vibecoding.vibecoding.dto.project.ProjectResponse;
import com.application.vibecoding.vibecoding.dto.project.ProjectSummaryResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface ProjectService {

    List<ProjectSummaryResponse> getUserProjects();

    ProjectResponse getUserProjectById(Long id);

    ProjectResponse createProject(ProjectRequest request);

    ProjectResponse updateProject(Long id, ProjectRequest request);

    void softDelete(Long id);
}
