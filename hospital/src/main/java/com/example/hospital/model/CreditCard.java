package com.example.hospital.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Column;

import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity 
@Table(name = "creditcard", indexes=@Index(name = "altIndex", columnList = "creditCardNumber", unique = true))
@Data
@RequiredArgsConstructor
public class CreditCard {
    @Id
    private Integer creditCardNumber;
    
    @Column(nullable=false)
    private String expirationDate ;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String securityCode;
}