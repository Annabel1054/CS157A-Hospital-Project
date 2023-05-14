package com.example.hospital.model;


import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class PaymentCommand {
   public String patientId;
   public String date;
   public String amount;
   public String creditCardNumber;
   public String expirationDate;
   public String firstName;
   public String lastName;
   public String securityCode;


   public PaymentCommand(String patientId, String date, String amount, String creditCardNumber,
           String expirationDate,
           String firstName, String lastName, String securityCode) {
       this.patientId = patientId;
       this.date = date;
       this.amount = amount;
       this.creditCardNumber = creditCardNumber;
       this.expirationDate = expirationDate;
       this.firstName = firstName;
       this.lastName = lastName;
       this.securityCode = securityCode;
   }


}


