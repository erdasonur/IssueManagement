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
@ApiModel("Issue History Data Transfer Object")
public class IssueHistoryDto {

    @ApiModelProperty(required = true, value = "IssueHistory Id")
    private long id;
    @ApiModelProperty(required = true, value = "IssueHistory description")
    private String description;
    @ApiModelProperty(required = true, value = "IssueHistory details")
    private String details;
    @ApiModelProperty(required = true, value = "IssueHistory date")
    private Date date;
    @ApiModelProperty(required = true, value = "IssueHistory issueStatus")
    private IssueStatus issueStatus;
    @ApiModelProperty(required = true, value = "IssueHistory issue")
    private IssueDto issue;
    @ApiModelProperty(required = true, value = "IssueHistory assignee")
    private UserDto assignee;
}
