package com.example.hospital.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ViewConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/patient").setViewName("patient");
        registry.addViewController("/nurse").setViewName("nurse");
        registry.addViewController("/doctor").setViewName("doctor");
        registry.addViewController("/prescription").setViewName("prescription");
        registry.addViewController("/appointment").setViewName("appointment");
        registry.addViewController("/allDoctors").setViewName("doctorTable");
        registry.addViewController("/allNurses").setViewName("nurseTable");
        registry.addViewController("/allPatients").setViewName("patientTable");
        registry.addViewController("/allAppointments").setViewName("appointmentTable");
    }

}