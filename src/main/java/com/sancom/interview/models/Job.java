package com.sancom.interview.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;

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
    private Integer id;

    @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
    @Column(unique = false, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String description;
    @Column(unique = true, nullable = false)
    private double experience;
    @Column(unique = true, nullable = false)
    private Date interviewDate;
    @Column(unique = true, nullable = false)
    private double duration;
    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private Status status;

    
}
