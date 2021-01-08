package com.example.IssueManagement.api;

import com.example.IssueManagement.dto.ProjectDto;
import com.example.IssueManagement.impl.ProjectServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project/versioning")
@Api()
public class ProjectControllerVersioned {

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectControllerVersioned(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }


    @ApiOperation(value = "Get By Id Operation V1", response = ProjectDto.class)
    @GetMapping(value = "/{id}", params = "version=1")
    public ResponseEntity<ProjectDto> getByIdV1(@PathVariable("id") Long id){
        ProjectDto projectDto = projectServiceImpl.getById(id);
        System.out.println("V1");
        return ResponseEntity.ok(projectDto);
    }
    //TODO Yeni Dto ve Service layerı eklenecek
    @ApiOperation(value = "Get By Id Operation V2", response = ProjectDto.class)
    @GetMapping(value = "/{id}", params = "version=2")
    public ResponseEntity<ProjectDto> getByIdV2(@PathVariable("id") Long id){
        ProjectDto projectDto = projectServiceImpl.getById(id);
        System.out.println("V2");
        return ResponseEntity.ok(projectDto);
    }
}
