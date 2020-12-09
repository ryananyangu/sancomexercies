package com.sancom.interview.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobTypeRequest {

    @ApiModelProperty(position = 0)
    private String name;
    
}
