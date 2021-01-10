package com.example.IssueManagement.api;

import com.example.IssueManagement.dto.ProjectDto;
import com.example.IssueManagement.impl.ProjectServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/project")
@Api()
@Slf4j
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;
    private final ModelMapper modelMapper;

    public ProjectController(ProjectServiceImpl projectServiceImpl, ModelMapper modelMapper) {
        this.projectServiceImpl = projectServiceImpl;
        this.modelMapper = modelMapper;
    }

    @ApiOperation(value = "Get By Id Operation", response = ProjectDto.class)
    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id){
        log.debug("Project Controller -> GetById -> PARAM: " +id);
        ProjectDto projectDto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @ApiOperation(value = "Create Operation", response = ProjectDto.class)
    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto project){
        log.debug("Project Controller -> Create ");
        return ResponseEntity.ok(projectServiceImpl.save(project));
    }

    @ApiOperation(value = "Update Operation", response = ProjectDto.class)
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable Long id, @RequestBody ProjectDto project){
        log.debug("Project Controller -> Update " +id);
        return ResponseEntity.ok(projectServiceImpl.update(id, project));
    }

    @ApiOperation(value = "Delete Operation", response = Boolean.class)
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id", required = true) Long id){
        log.debug("Project Controller -> Delete -> PARAM: " +id);
        ProjectDto projectDto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectServiceImpl.delete(projectDto));
    }

}
