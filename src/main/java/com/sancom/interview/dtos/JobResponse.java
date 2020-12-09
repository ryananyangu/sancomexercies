package com.sancom.interview.dtos;

import java.util.Date;
import com.sancom.interview.models.Job.Status;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobResponse {

    @ApiModelProperty(position = 0)
    private long id;

    @ApiModelProperty(position = 1)
    private String name;

    @ApiModelProperty(position = 2)
    private String description;

    @ApiModelProperty(position = 3)
    private double experience;

    @ApiModelProperty(position = 4)
    private Date interviewDate;

    @ApiModelProperty(position = 5)
    private double duration;

    @ApiModelProperty(position = 6)
    private Status status;

    @ApiModelProperty(position = 6)
    private JobType type;
    
}
