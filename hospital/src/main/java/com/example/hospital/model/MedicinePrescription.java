package com.example.hospital.model;
import javax.persistence.IdClass;

import com.example.hospital.compositeKeys.MedicinePrescriptionPK;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "medicine_prescription")
@Data
@IdClass(MedicinePrescriptionPK.class)
public class MedicinePrescription {
    @Id
    @Column(nullable=false)
    private int prescriptionId;
    @Id
    @Column(nullable=false)
    private int medicineId;
}
