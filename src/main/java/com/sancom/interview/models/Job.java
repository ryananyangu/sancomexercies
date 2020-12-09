package com.sancom.interview.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.envers.Audited;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Audited
@Data
@EqualsAndHashCode(callSuper = false)
public class Job extends Auditable<String>{

    public enum Status {
        ACTIVE,CANCELLED,EXPIRED;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
    @Column(unique = false, nullable = false)
    private String name;

    @Column(unique = false, nullable = false)
    private String description;
    @Column(unique = false, nullable = false)
    private double experience;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(unique = false, nullable = false)
    private Date interviewDate;

    @Column(unique = false, nullable = false)
    private double duration;
    @Enumerated(EnumType.STRING)
    @Column(unique = false, nullable = false)
    private Status status;

    
    // @Column(unique = false, nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private JobType type;



    
}
