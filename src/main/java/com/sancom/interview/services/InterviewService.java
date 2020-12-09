package com.sancom.interview.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sancom.interview.dtos.InterviewRequest;
import com.sancom.interview.dtos.InterviewResponse;
import com.sancom.interview.exceptions.CustomException;
import com.sancom.interview.models.Interview;
import com.sancom.interview.models.Job;
import com.sancom.interview.models.User;
import com.sancom.interview.models.Interview.InterviewStatus;
import com.sancom.interview.repositories.InterviewRepository;
import com.sancom.interview.repositories.JobRepository;
import com.sancom.interview.repositories.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    public InterviewResponse create(InterviewRequest request){
        Optional<Job> job = jobRepository.findById(request.getJob()); 

        Optional<User> user = userRepository.findById(request.getUser());

        if(!user.isPresent() || !job.isPresent()){
            throw new CustomException("Invalid job or user submitted", HttpStatus.BAD_REQUEST);
        }

        if(job.get().getInterviewDate().compareTo(new Date()) < 0){
            throw new CustomException("Job interview date has already passed", HttpStatus.BAD_REQUEST);

        }

        Interview interview = new Interview();
        interview.setJob(job.get());
        interview.setUser(user.get());
        interview.setStatus(InterviewStatus.ACTIVE);

        return modelMapper.map(interviewRepository.save(interview), InterviewResponse.class);
        
    }


    public InterviewResponse update(int id, InterviewRequest request){
        Optional<Interview> interview = interviewRepository.findById(id);

        if(!interview.isPresent()){
            throw new CustomException("Invalid interview ID", HttpStatus.BAD_REQUEST);

        }

        interview.get().setStatus(request.getStatus());
        return modelMapper.map(interviewRepository.save(interview.get()), InterviewResponse.class);
    }

    public void delete(int id){
        interviewRepository.deleteById(id);
    }


    public List<InterviewResponse> all(){
        return interviewRepository.findAll().stream().map(type -> modelMapper
        .map(type, InterviewResponse.class))
        .collect(Collectors.toList());
    }

    public List<InterviewResponse> allUser(int id){
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new CustomException("Invalid userID", HttpStatus.BAD_REQUEST);
        }
        return interviewRepository.findByUser(user.get()).stream().map(type -> modelMapper
        .map(type, InterviewResponse.class))
        .collect(Collectors.toList());
    }


    
}
