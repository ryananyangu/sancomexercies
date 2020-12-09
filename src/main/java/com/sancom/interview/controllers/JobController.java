package com.sancom.interview.controllers;

import java.util.List;

import javax.validation.Valid;

import com.sancom.interview.dtos.JobRequest;
import com.sancom.interview.dtos.JobResponse;
import com.sancom.interview.dtos.JobType;
import com.sancom.interview.dtos.JobTypeRequest;
import com.sancom.interview.services.JobService;

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
@RequestMapping("api/v1/job")
@Api(tags = "job")
public class JobController {

    @Autowired
    private JobService jobService;


    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${Job.create}", authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
        @ApiResponse(code = 400, message = "Something went wrong"), //
        @ApiResponse(code = 403, message = "Access denied"), //
        @ApiResponse(code = 500, message = "Internal server error")})
    public JobResponse create(@ApiParam("Create Job") @RequestBody JobRequest job) {
      return jobService.create(job);
    }

    @PostMapping("/type/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${Job.Type.create}", authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
        @ApiResponse(code = 400, message = "Something is wrong with submitted request"), //
        @ApiResponse(code = 403, message = "Access denied"), //
        @ApiResponse(code = 500, message = "Internal server error")})
    public JobType typeCreate(@ApiParam("Create Job Type") @RequestBody JobTypeRequest type) {
      return jobService.typeCreate(type);
    }

    @GetMapping("/type/all")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    @ApiOperation(value = "${Job.Type.all}", authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
        @ApiResponse(code = 400, message = "Something is wrong with submitted request"), //
        @ApiResponse(code = 403, message = "Access denied"), //
        @ApiResponse(code = 500, message = "Internal server error")})
    public List<JobType> typeAll() {
      return jobService.typeAll();
    }

    @DeleteMapping(value = "/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${Job.delete}", authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
        @ApiResponse(code = 400, message = "Something went wrong"), //
        @ApiResponse(code = 403, message = "Access denied"), //
        @ApiResponse(code = 404, message = "The user doesn't exist"), //
        @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public String delete(@ApiParam("id") @PathVariable int id) {
      jobService.delete(id);
      return "Success";
    }

    @PutMapping(value = "/update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${Job.delete}", authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
        @ApiResponse(code = 400, message = "Something went wrong"), //
        @ApiResponse(code = 403, message = "Access denied"), //
        @ApiResponse(code = 404, message = "The user doesn't exist"), //
        @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public JobResponse update(@ApiParam("id") @PathVariable int id,@RequestBody @Valid JobRequest request) {
      return jobService.update(id,request);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    @ApiOperation(value = "${Job.all}", authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
        @ApiResponse(code = 400, message = "Something is wrong with submitted request"), //
        @ApiResponse(code = 403, message = "Access denied"), //
        @ApiResponse(code = 500, message = "Internal server error")})
    public List<JobResponse> all() {
      return jobService.all();
    }
    
}
