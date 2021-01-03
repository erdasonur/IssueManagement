package com.example.IssueManagement.dto;

import com.example.IssueManagement.entity.IssueStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Issue Data Transfer Object")
public class IssueDto {
    @ApiModelProperty(required = true, value = "Issue Id")
    private Long id;
    @ApiModelProperty(required = true, value = "Issue Description")
    private String description;
    @ApiModelProperty(required = true, value = "Issue Details")
    private String details;
    @ApiModelProperty(required = true, value = "Issue Date")
    private Date date;
    @ApiModelProperty(required = true, value = "Issue Status")
    private IssueStatus issueStatus;
    @ApiModelProperty(required = true, value = "User Assignee")
    private UserDto assignee;
    @ApiModelProperty(required = true, value = "Project")
    private ProjectDto project;
}
