package com.sancom.interview.controllers;

import com.sancom.interview.dtos.InterviewRequest;
import com.sancom.interview.dtos.InterviewResponse;
import com.sancom.interview.services.InterviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("api/v1/interview")
@Api(tags = "interview")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @ApiOperation(value = "${Job.create}", authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
        @ApiResponse(code = 400, message = "Something went wrong"), //
        @ApiResponse(code = 403, message = "Access denied"), //
        @ApiResponse(code = 500, message = "Internal server error")})
    public InterviewResponse create(@ApiParam("Schedule and interview") @RequestBody InterviewRequest request) {
      return interviewService.create(request);
    }
    
}
