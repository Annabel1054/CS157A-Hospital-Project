package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital.model.Nurse;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Long> {
    Nurse findByNurseId(int nurseId) ;
}
