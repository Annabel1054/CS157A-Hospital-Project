CREATE TABLE PATIENT (
  PATIENT_ID        INT(8) NOT NULL PRIMARY KEY,
  FIRST_NAME        VARCHAR(30),
  LAST_NAME         VARCHAR(30),
  ADDRESS           VARCHAR(50),
  PHONE_NUMBER      VARCHAR(15),
  DATE_OF_BIRTH     VARCHAR(13),
  GENDER            VARCHAR(13),
  EMAIL             VARCHAR(50),
  SSN               CHAR(11)
);

CREATE TABLE DOCTOR (
  DOCTOR_ID    INT(8) PRIMARY KEY NOT NULL,
  FIRST_NAME   VARCHAR(30),
  LAST_NAME    VARCHAR(30),
  PHONE_NUMBER VARCHAR(15),
  EMAIL        VARCHAR(50)
);

CREATE TABLE NURSE (
  NURSE_ID     INT(8) PRIMARY KEY NOT NULL,
  FIRST_NAME   VARCHAR(30),
  LAST_NAME    VARCHAR(30),
  PHONE_NUMBER VARCHAR(15),
  EMAIL        VARCHAR(50)
);

CREATE TABLE MEDICINE (
  MEDICINE_ID INT(8) PRIMARY KEY NOT NULL,
  NAME        VARCHAR(30),
  COST        DECIMAL(10,2),
  DESCRIPTION VARCHAR(200)
);

CREATE TABLE CREDIT_CARD (
  CREDIT_CARD_NUMBER CHAR(16) PRIMARY KEY NOT NULL,
  EXPIRATION_DATE    VARCHAR(5),
  NAME               VARCHAR(50),
  SECURITY_CODE      VARCHAR(3)
);

CREATE TABLE SPECIALIZATIONS (
   SPECIALIZATION   VARCHAR(30) NOT NULL,
   DOCTOR_ID        INT(8) FOREIGN KEY REFERENCES DOCTOR(DOCTOR_ID) NOT NULL,
   CONSTRAINT SPECIALIZATIONS_DOCTOR_PK PRIMARY KEY(SPECIALIZATION, DOCTOR_ID)
);

CREATE TABLE NURSE_DOCTOR_COLLABORATION (
   NURSE_ID         INT(8) FOREIGN KEY REFERENCES NURSE(NURSE_ID) NOT NULL,
   DOCTOR_ID        INT(8) FOREIGN KEY REFERENCES DOCTOR(DOCTOR_ID) NOT NULL,
   CONSTRAINT NURSE_DOCTOR_PK PRIMARY KEY(NURSE_ID, DOCTOR_ID)
);

CREATE TABLE PRESCRIPTION (
   PRESCRIPTION_ID  INT(8) PRIMARY KEY NOT NULL,
   QUANTITY         INT(5),
   INTAKE           INT(5),
   FREQUENCY        VARCHAR(30),
   DATE             DATE,
   DOCTOR_ID        INT(8) FOREIGN KEY REFERENCES DOCTOR(DOCTOR_ID) NOT NULL,
   PATIENT_ID       INT(8) FOREIGN KEY REFERENCES PATIENT(PATIENT_ID) NOT NULL
);

CREATE TABLE APPOINTMENT (
   APPOINTMENT_ID   INT(8) PRIMARY KEY NOT NULL,
   DOCTOR_ID        INT(8) FOREIGN KEY REFERENCES DOCTOR(DOCTOR_ID) NOT NULL,       
   PATIENT_ID       INT(8) FOREIGN KEY REFERENCES PATIENT(PATIENT_ID) NOT NULL, 
   DEPARTMENT       VARCHAR(30),
   ROOM             VARCHAR(30),
   TIME             TIME,
   DATE             DATE,
   TYPE             VARCHAR(50),
   COST             DECIMAL(10,2)
);

CREATE TABLE MEDICINE_PRESCRIPTION (
   MEDICINE_ID         INT(8) FOREIGN KEY REFERENCES MEDICINE(MEDICINE_ID) NOT NULL,
   PRESCRIPTION_ID     INT(8) FOREIGN KEY REFERENCES PRESCRIPTION(PRESCRIPTION_ID) NOT NULL,
   CONSTRAINT MEDICINE_PRESCRIPTION_PK PRIMARY KEY(MEDICINE_ID, PRESCRIPTION_ID)
);

CREATE TABLE BILLING (
   BILLING_ID          INT(8) PRIMARY KEY NOT NULL,
   PATIENT_ID          INT(8) FOREIGN KEY REFERENCES PATIENT(PATIENT_ID) NOT NULL, 
   DATE                DATE,
   AMOUNT              DECIMAL(10, 2),
   CREDIT_CARD_NUMBER  CHAR(16) FOREIGN KEY REFERENCES CREDIT_CARD(CREDIT_CARD_NUMBER)
);
