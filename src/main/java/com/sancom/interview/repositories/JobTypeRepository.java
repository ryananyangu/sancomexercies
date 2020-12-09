package com.sancom.interview.repositories;

import com.sancom.interview.models.JobType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTypeRepository  extends JpaRepository<JobType, Integer>{
    
}
