package com.example.IssueManagement.service;

import com.example.IssueManagement.dto.ProjectDto;
import com.example.IssueManagement.entity.Project;
import com.example.IssueManagement.util.TPage;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto project);
    ProjectDto getById(Long id);
    ProjectDto update(Long id, ProjectDto projectDto);

    TPage<ProjectDto> getAllPageable(Pageable pageable);

    List<Project> getByProjectCode(String projectCode);
    List<Project> getByProjectCodeContains(String projectCode);

    Boolean delete(ProjectDto project);
}
