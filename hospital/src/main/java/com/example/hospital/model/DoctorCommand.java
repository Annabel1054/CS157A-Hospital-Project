package com.example.hospital.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DoctorCommand {
    public int doctorId;
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String email;
    public String specialization;

    public DoctorCommand(Integer doctorId, String firstName, String lastName, String phoneNumber, String email,
            String specialization) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.specialization = specialization;
    }

}
