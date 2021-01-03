package com.example.IssueManagement.dto;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Project Data Transfer Object")
public class ProjectDto {
    @ApiModelProperty(value = "Project Id")
    private Long id;
    @NotNull
    @ApiModelProperty(required = true, value = "Name of Project")
    private String projectName;
    @NotNull
    @ApiModelProperty(required = true, value = "Code of Project")
    private String projectCode;
}
