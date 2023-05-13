package com.example.hospital.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.hospital.model.Doctor;
import com.example.hospital.model.DoctorCommand;
import com.example.hospital.model.Nurse;
import com.example.hospital.model.Patient;
import com.example.hospital.model.Specialization;
import com.example.hospital.model.Prescription;
import com.example.hospital.model.Appointment;
import com.example.hospital.repository.DoctorRepository;
import com.example.hospital.repository.NurseRepository;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.repository.SpecializationRepository;
import com.example.hospital.repository.PrescriptionRepository;
import com.example.hospital.repository.AppointmentRepository;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsersController {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private SpecializationRepository specializationRepository;
    @Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PrescriptionRepository prescriptionRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @RequestMapping(value = { "/doctor" }, method = RequestMethod.GET)
    public String showDoctorForm(Model model) {
        DoctorCommand dc = new DoctorCommand();
        model.addAttribute("doctorCommand", dc);
        return "doctor";
    }

    @RequestMapping(value = { "/doctor" }, method = RequestMethod.POST)
    public String registerDoctor(@Valid @ModelAttribute("doctorCommand") DoctorCommand dc) {
        Doctor doctor = new Doctor();
        doctor.setEmail(dc.getEmail());
        doctor.setFirstName(dc.getFirstName());
        doctor.setLastName(dc.getLastName());
        doctor.setPhoneNumber(dc.getPhoneNumber());
        Doctor d = doctorRepository.saveAndFlush(doctor);
        System.out.println("Doctor: " + d);

        Specialization s = new Specialization();
        s.setDoctorId(d.getDoctorId());
        s.setSpecialization(dc.getSpecialization());
        specializationRepository.save(s);

        return "doctorTable";
    }

    @RequestMapping(value = { "/allDoctors" }, method = RequestMethod.GET)
    public String showDoctorTable(Model model) {
        List<DoctorCommand> dcList = new ArrayList<DoctorCommand>();
        List<Doctor> doctorList = doctorRepository.findAll();
        System.out.println(doctorList);

        for (Doctor d : doctorList) {
            Specialization s = specializationRepository.findByDoctorId(d.getDoctorId());
            System.out.println("Specialization of id " + d.getDoctorId() + " : " + s);
            DoctorCommand dc = new DoctorCommand(d.getDoctorId(), d.getFirstName(), d.getLastName(), d.getPhoneNumber(),
                    d.getEmail(), s.getSpecialization());
            System.out.println("Doctor Command: " + dc);
            dcList.add(dc);
        }

        model.addAttribute("doctorList", dcList);
        return "doctorTable";
    }

    @RequestMapping(value = { "/nurse" }, method = RequestMethod.GET)
    public String showNurseForm(Model model) {
        Nurse nurse = new Nurse();
        model.addAttribute("nurse", nurse);
        return "nurse";
    }

    @RequestMapping(value = { "/nurse" }, method = RequestMethod.POST)
    public String registerNurse(@Valid @ModelAttribute("nurse") Nurse nurse) {
        System.out.println(nurse);
        nurseRepository.save(nurse);

        return "nurseTable";
    }

    @RequestMapping(value = { "/allNurses" }, method = RequestMethod.GET)
    public String showNurseTable(Model model) {
        model.addAttribute("nurseList", nurseRepository.findAll());
        return "nurseTable";
    }

    @RequestMapping(value = { "/patient" }, method = RequestMethod.GET)
    public String showPatientForm(Model model) {
        Patient patient = new Patient();
        model.addAttribute("patient", patient);
        return "patient";
    }

    @RequestMapping(value = { "/patient" }, method = RequestMethod.POST)
    public String registerPatient(@Valid @ModelAttribute("patient") Patient patient) {
        System.out.println(patient);
        patientRepository.save(patient);

        return "patientTable";
    }

    @RequestMapping(value = { "/allPatients" }, method = RequestMethod.GET)
    public String showPatientTable(Model model) {
        model.addAttribute("patientList", patientRepository.findAll());
        return "patientTable";
    }

    @RequestMapping(value = { "/prescription" }, method = RequestMethod.GET)
    public String showPrescriptionForm(Model model) {
        Prescription prescription = new Prescription();
        model.addAttribute("prescription", prescription);
        return "prescription";
    }

    @RequestMapping(value = { "/prescription" }, method = RequestMethod.POST)
    public String registerPrescription(@Valid @ModelAttribute("prescription") Prescription prescription) {
        System.out.println(prescription);
        prescriptionRepository.save(prescription);

        return "prescriptionTable";
    }

    @RequestMapping(value = { "/allPrescriptions" }, method = RequestMethod.GET)
    public String showPrescriptionTable(Model model) {
        model.addAttribute("prescriptionList", prescriptionRepository.findAll());
        return "prescriptionTable";
    }

    @RequestMapping(value = { "/appointment" }, method = RequestMethod.GET)
    public String showAppointmentForm(Model model) {
        Appointment appointment = new Appointment();
        model.addAttribute("appointment", appointment);
        return "appointment";
    }

    @RequestMapping(value = { "/appointment" }, method = RequestMethod.POST)
    public String registerAppointment(@Valid @ModelAttribute("appointment") Appointment appointment) {
        System.out.println(appointment);
        appointmentRepository.save(appointment);

        return "appointmentTable";
    }

    @RequestMapping(value = { "/allAppointments" }, method = RequestMethod.GET)
    public String showAppointmentTable(Model model) {
        model.addAttribute("appointmentList", appointmentRepository.findAll());
        return "appointmentTable";
    }
}
