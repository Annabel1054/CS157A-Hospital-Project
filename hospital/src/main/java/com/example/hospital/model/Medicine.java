package com.example.hospital.model;

// public class Medicine {
    
// }

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
@Table(name = "medicine", indexes=@Index(name = "altIndex", columnList = "medicineId", unique = true))
@Data
@RequiredArgsConstructor
public class Medicine{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer medicineId;
    
    @Column(nullable=false)
    private String name;
    @Column(nullable = false)
    private String cost;
    @Column(nullable = false)
    private String description;
}