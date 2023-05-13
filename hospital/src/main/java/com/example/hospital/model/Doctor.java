package com.example.hospital.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity 
@Table(name = "doctor", indexes=@Index(name = "altIndex", columnList = "doctorId", unique = true))
@Data
@RequiredArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer doctorId;

    @Column(nullable=false)
    private String firstName ;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String email;
}