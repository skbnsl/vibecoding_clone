package com.application.vibecoding.vibecoding.mapper;

import com.application.vibecoding.vibecoding.dto.project.ProjectResponse;
import com.application.vibecoding.vibecoding.dto.project.ProjectSummaryResponse;
import com.application.vibecoding.vibecoding.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    //@Mapping(target = "owner", ignore = true)
    ProjectResponse toProjectResponse(Project project);

    @Mapping(source = "name", target = "projectName")
    ProjectSummaryResponse toProjectSummaryResponse(Project project);

    List<ProjectSummaryResponse>  toListOfProjectSummaryResponse(List<Project> projects);
}
