package com.example.IssueManagement.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("User Data Transfer Object")
public class UserDto {
    @ApiModelProperty(value = "User Id")
    private Long id;
    @ApiModelProperty(value = "User Name Surname")
    private String nameSurname;
}
