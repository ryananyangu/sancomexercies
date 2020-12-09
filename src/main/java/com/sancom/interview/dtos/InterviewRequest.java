package com.sancom.interview.dtos;


import com.sancom.interview.models.Interview.InterviewStatus;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InterviewRequest {


    @ApiModelProperty(position = 0)
    private int job;


    @ApiModelProperty(position = 1)
    private int user;


    @ApiModelProperty(position = 2)
    private InterviewStatus status;
    
}
