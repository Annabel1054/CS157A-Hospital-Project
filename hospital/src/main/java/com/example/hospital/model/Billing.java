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
@Table(name = "billing", indexes = @Index(name = "altIndex", columnList = "billingId", unique = true))
@Data
@RequiredArgsConstructor
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer billingId;

    @Column(nullable = false)
    private String patientId;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private String amount;
    @Column(nullable = false)
    private String creditCardNumber;
}