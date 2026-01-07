package com.application.vibecoding.vibecoding.service;

import com.application.vibecoding.vibecoding.dto.project.FileContentResponse;
import com.application.vibecoding.vibecoding.dto.project.FileNode;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface FileService {
    List<FileNode> getFileTree(Long projectId, Long userId);

    FileContentResponse getFileContent(Long projectId, String path, Long userId);
}
