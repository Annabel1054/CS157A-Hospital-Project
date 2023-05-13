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
@Table(name = "appointment", indexes = @Index(name = "altIndex", columnList = "appointmentId", unique = true))
@Data
@RequiredArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer appointmentId;

    @Column(nullable = false)
    private int doctorId;
    @Column(nullable = false)
    private int patientId;
    @Column(nullable = false)
    private String department;
    @Column(nullable = false)
    private String room;
    @Column(nullable = false)
    private String time;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String cost;
}