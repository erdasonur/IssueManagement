package com.example.IssueManagement.dto;

import com.example.IssueManagement.entity.Issue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("User Data Transfer Object")
public class UserDto {
    @ApiModelProperty(value = "User Id")
    private Long id;
    @ApiModelProperty(value = "User Name")
    private String username;
    @ApiModelProperty(value = "User Name Surname")
    private String nameSurname;
    @ApiModelProperty(value = "Email")
    private String email;
    @ApiModelProperty(value = "Issues")
    private List<Issue> issues;
}
