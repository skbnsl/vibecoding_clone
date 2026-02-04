package com.application.vibecoding.vibecoding.mapper;

import com.application.vibecoding.vibecoding.dto.project.ProjectResponse;
import com.application.vibecoding.vibecoding.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    @Mapping(target = "owner", ignore = true)
    ProjectResponse toProjectResponse(Project project);

}
