package com.sancom.interview.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.envers.Audited;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Audited
@Data
@EqualsAndHashCode(callSuper = false)
public class Interview  extends Auditable<String>{
    public enum InterviewStatus {
        ACTIVE,CLOSED;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // @Column(unique = false, nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Job job;

    // @Column(unique = false, nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(unique = false, nullable = false)
    private InterviewStatus status;


    
}
