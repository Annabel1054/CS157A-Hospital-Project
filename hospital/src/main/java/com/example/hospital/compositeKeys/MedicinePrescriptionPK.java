package com.example.hospital.compositeKeys;

import java.io.Serializable;

import lombok.Data;

// Source on creating composite keys: https://www.baeldung.com/jpa-composite-primary-keys

@Data
public class MedicinePrescriptionPK implements Serializable {
    private int medicineId;
    private int prescriptionId;

    public MedicinePrescriptionPK() {
    }

    public MedicinePrescriptionPK(int medicineId, int prescriptionId) {
        this.medicineId = medicineId;
        this.prescriptionId = prescriptionId;
    }
}
