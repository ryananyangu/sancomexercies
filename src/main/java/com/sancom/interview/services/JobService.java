package com.sancom.interview.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sancom.interview.dtos.JobRequest;
import com.sancom.interview.dtos.JobResponse;
import com.sancom.interview.dtos.JobTypeRequest;
import com.sancom.interview.exceptions.CustomException;
import com.sancom.interview.models.Job;
import com.sancom.interview.models.JobType;
import com.sancom.interview.repositories.JobRepository;
import com.sancom.interview.repositories.JobTypeRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobTypeRepository jobTypeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public JobResponse create(JobRequest request){
        Job job = modelMapper.map(request, Job.class);

        Optional<JobType> jobType = jobTypeRepository.findById(request.getType());
        if(!jobType.isPresent()){
            throw new CustomException("Invalid job Type", HttpStatus.BAD_REQUEST);
        }

        job.setType(jobType.get());
        
        job = jobRepository.save(job);
        return modelMapper.map(jobRepository.save(job), JobResponse.class);
        
    }

    public com.sancom.interview.dtos.JobType typeCreate(JobTypeRequest request){
        JobType type = modelMapper.map(request, JobType.class);
        type = jobTypeRepository.save(type);
        return modelMapper.map(type, com.sancom.interview.dtos.JobType.class);
    }

    public List<com.sancom.interview.dtos.JobType> typeAll(){
        return jobTypeRepository.findAll().stream()
        .map(type -> modelMapper
        .map(type, com.sancom.interview.dtos.JobType.class))
        .collect(Collectors.toList());
    }

    public void delete(int id){
        jobRepository.deleteById(id);
    }

    public JobResponse update(int id,JobRequest request){

        Job job = modelMapper.map(request, Job.class);

        Optional<JobType> jobType = jobTypeRepository.findById(request.getType());
        if(!jobType.isPresent()){
            throw new CustomException("Invalid job Type", HttpStatus.BAD_REQUEST);
        }

        job.setType(jobType.get());

        Optional<Job> retrievedJob = jobRepository.findById(id);
        if(!retrievedJob.isPresent()){
            throw new CustomException("Invalid job id", HttpStatus.BAD_REQUEST);
        }

        job.setId(retrievedJob.get().getId());

        return modelMapper.map(jobRepository.save(job), JobResponse.class);        
    }

    public List<JobResponse> all(){
        return jobRepository.findAll().stream()
        .map(job -> modelMapper
        .map(job, JobResponse.class))
        .collect(Collectors.toList());

    }

    
    
}
