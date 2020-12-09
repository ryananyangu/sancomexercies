package com.sancom.interview.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobType {


    @ApiModelProperty(position = 0)
    private Integer id;

    @ApiModelProperty(position = 1)
    private String name;
    
}
