package com.example.hospital.model;
import javax.persistence.IdClass;

import com.example.hospital.compositeKeys.SpecializationId;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "specialization")
@Data
@IdClass(SpecializationId.class)
public class Specialization {
    @Id
    @Column(nullable=false)
    private String specialization;
    @Id
    @Column(nullable=false)
    private int doctorId;
}
