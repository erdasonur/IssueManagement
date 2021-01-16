package com.example.IssueManagement.impl;

import com.example.IssueManagement.dto.ProjectDto;
import com.example.IssueManagement.entity.Project;
import com.example.IssueManagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.IssueManagement.repository.ProjectRepository;
import com.example.IssueManagement.service.ProjectService;

import java.util.Arrays;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto project) {
        if(project.getProjectCode() == null)
            throw new IllegalArgumentException("Project code can't be null");
        Project p = modelMapper.map(project,Project.class);
        return modelMapper.map(projectRepository.save(p),ProjectDto.class);
    }

    @Override
    public ProjectDto getById(Long id) {

        Project p = projectRepository.getOne(id);
        return modelMapper.map(p,ProjectDto.class);
    }

    @Override
    public ProjectDto update(Long id, ProjectDto projectDto) {
        Project project = projectRepository.getOne(id);
        if(project == null)
            throw new IllegalArgumentException("Project doesn't exist id : " + id);
        if(project.getProjectCode() == null)
            throw new IllegalArgumentException("Project code can't be null");
        project.setProjectCode(projectDto.getProjectCode());
        project.setProjectName(projectDto.getProjectName());
        projectRepository.save(project);
        return modelMapper.map(project, ProjectDto.class);
    }

    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {
        Page<Project> data = projectRepository.findAll(pageable);
        TPage<ProjectDto> response = new TPage<>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
        return response;
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
        return projectRepository.getByProjectCode(projectCode);
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return projectRepository.getByProjectCodeContains(projectCode);
    }

    @Override
    public Boolean delete(ProjectDto project) {
        Project p = modelMapper.map(project, Project.class);
        projectRepository.delete(p);
        return true;
    }
}
