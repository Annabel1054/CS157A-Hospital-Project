package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital.model.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    Medicine findByMedicineId(int medicineId);
}