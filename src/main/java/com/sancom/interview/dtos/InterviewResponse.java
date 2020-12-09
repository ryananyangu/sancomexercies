package com.sancom.interview.dtos;

import com.sancom.interview.models.Interview.InterviewStatus;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InterviewResponse {


    @ApiModelProperty(position = 0)
    private Integer id;


    @ApiModelProperty(position = 1)
    private JobResponse job;


    @ApiModelProperty(position = 2)
    private UserResponseDTO user;


    @ApiModelProperty(position = 3)
    private InterviewStatus status;
    
}
