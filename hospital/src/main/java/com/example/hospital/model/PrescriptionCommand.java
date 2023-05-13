package com.example.hospital.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PrescriptionCommand {
    private Integer prescriptionId;
    private int medicineId;
    private int quantity;
    private int intake;
    private String frequency;
    private String date;
    private int doctorId;
    private int patientId;
    private String name;
    private String description;
    private Double cost;

    public PrescriptionCommand(
        Integer prescriptionId, 
        int medicineId,
        String name, 
        double cost, 
        String description, 
        int quantity,
        int intake,
        String frequency,
        String date,
        int doctorId,
        int patientId) {
            this.prescriptionId = prescriptionId;
            this.medicineId = medicineId;
            this.name = name;
            this.cost = cost;
            this.description = description;
            this.quantity = quantity;
            this.intake = intake;
            this.frequency = frequency;
            this.date = date;
            this.doctorId = doctorId;
            this.patientId = patientId;
    }
}
