package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital.model.Billing;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long> {
    Billing findByBillingId(int billingId);
}