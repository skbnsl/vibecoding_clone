package com.application.vibecoding.vibecoding.mapper;

import com.application.vibecoding.vibecoding.dto.project.ProjectResponse;
import com.application.vibecoding.vibecoding.entity.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);

}
