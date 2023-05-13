package com.example.hospital.model;

// public class Medicine {

// }

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "medicine", indexes = @Index(name = "altIndex", columnList = "medicineId", unique = true))
@Data
@RequiredArgsConstructor
public class Medicine {

    @Column(nullable = false)
    private Integer medicineId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double cost;
    @Column(nullable = false)
    private String description;
}