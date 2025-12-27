package com.application.vibecoding.vibecoding.entity;

import com.application.vibecoding.vibecoding.enums.ProjectRole;

import java.time.Instant;

public class ProjectMember {

    ProjectMemberId id;

    User user;
    Project project;

    ProjectRole projectRole;

    Instant invitedAt;
    Instant acceptedAt;

}
