package com.sancom.interview.dtos;

import java.util.List;

import com.sancom.interview.models.Role;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import com.sancom.interview.models.User.EducationLevel;

@Getter
@Setter
public class UserDataDTO {
  
  @ApiModelProperty(position = 0)
  private String username;
  @ApiModelProperty(position = 1)
  private String email;
  @ApiModelProperty(position = 2)
  private String phonenumber;
  @ApiModelProperty(position = 3)
  private String password;
  @ApiModelProperty(position = 4)
  private double experience;
  @ApiModelProperty(position = 5)
  private EducationLevel educationLevel;
  @ApiModelProperty(position = 6)
  private String lastName;
  @ApiModelProperty(position = 7)
  private String firstName;
  @ApiModelProperty(position = 8)
  List<Role> roles;
}