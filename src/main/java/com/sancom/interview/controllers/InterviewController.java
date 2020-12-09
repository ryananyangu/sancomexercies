package com.sancom.interview.controllers;

import java.util.List;

import com.sancom.interview.dtos.InterviewRequest;
import com.sancom.interview.dtos.InterviewResponse;
import com.sancom.interview.services.InterviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    @ApiOperation(value = "${interview.create}", authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
        @ApiResponse(code = 400, message = "Something went wrong"), //
        @ApiResponse(code = 403, message = "Access denied"), //
        @ApiResponse(code = 500, message = "Internal server error")})
    public InterviewResponse create(@ApiParam("Schedule and interview") @RequestBody InterviewRequest request) {
      return interviewService.create(request);
    }


    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @ApiOperation(value = "${interview.update}", authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
        @ApiResponse(code = 400, message = "Something went wrong"), //
        @ApiResponse(code = 403, message = "Access denied"), //
        @ApiResponse(code = 500, message = "Internal server error")})
    public InterviewResponse update(@ApiParam("id") @PathVariable int id, @RequestBody InterviewRequest request) {
      return interviewService.update(id,request);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${interview.delete}", authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
        @ApiResponse(code = 400, message = "Something went wrong"), //
        @ApiResponse(code = 403, message = "Access denied"), //
        @ApiResponse(code = 500, message = "Internal server error")})
    public String delete(@ApiParam("id") @PathVariable int id) {
        interviewService.delete(id);
      return "Success";
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${interview.all}", authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
        @ApiResponse(code = 400, message = "Something went wrong"), //
        @ApiResponse(code = 403, message = "Access denied"), //
        @ApiResponse(code = 500, message = "Internal server error")})
    public List<InterviewResponse> delete() {
      return interviewService.all();
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${interview.get.users}", authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
        @ApiResponse(code = 400, message = "Something went wrong"), //
        @ApiResponse(code = 403, message = "Access denied"), //
        @ApiResponse(code = 500, message = "Internal server error")})
    public List<InterviewResponse> getByUser(@ApiParam("id") @PathVariable int id) {
      return interviewService.allUser(id);
    }
    
}
