package com.sancom.interview.repositories;

import java.util.List;

import com.sancom.interview.models.Interview;
import com.sancom.interview.models.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface InterviewRepository   extends JpaRepository<Interview, Integer> {

    List<Interview> findByUser(User user);
    
}
