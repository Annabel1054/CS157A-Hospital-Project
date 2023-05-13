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
@Table(name = "prescription", indexes = @Index(name = "altIndex", columnList = "prescriptionId", unique = true))
@Data
@RequiredArgsConstructor
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer prescriptionId;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private int intake;
    @Column(nullable = false)
    private String frequency;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private int doctorId;
    @Column(nullable = false)
    private int patientId;
}
