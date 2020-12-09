package com.sancom.interview.repositories;

import com.sancom.interview.models.Job;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository  extends JpaRepository<Job, Integer> {
    
}
