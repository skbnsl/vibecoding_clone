package com.application.vibecoding.vibecoding.dto.project;

import java.util.List;

public record FileTreeResponse(
        List<FileNode> files
) {
}
