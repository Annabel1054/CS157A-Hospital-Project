package com.example.hospital.compositeKeys;

import java.io.Serializable;

import lombok.Data;

// Source on creating composite keys: https://www.baeldung.com/jpa-composite-primary-keys

@Data
public class SpecializationId implements Serializable {
    private String specialization;
    private int doctorId;

    public SpecializationId() {}

    public SpecializationId(String specializaiton, int doctorId) {
        this.specialization = specializaiton;
        this.doctorId = doctorId;
    }
}