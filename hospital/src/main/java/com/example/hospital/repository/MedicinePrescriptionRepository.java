package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital.model.MedicinePrescription;

@Repository
public interface  MedicinePrescriptionRepository extends JpaRepository<MedicinePrescription, Long> {
    MedicinePrescription findByMedicineId(int medicineId);
    MedicinePrescription findByPrescriptionId(int prescriptionId);
}