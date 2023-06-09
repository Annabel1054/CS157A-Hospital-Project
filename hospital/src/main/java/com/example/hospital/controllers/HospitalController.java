package com.example.hospital.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.hospital.model.Doctor;
import com.example.hospital.model.DoctorCommand;
import com.example.hospital.model.Medicine;
import com.example.hospital.model.MedicinePrescription;
import com.example.hospital.model.Nurse;
import com.example.hospital.model.Patient;
import com.example.hospital.model.Specialization;
import com.example.hospital.model.Prescription;
import com.example.hospital.model.PrescriptionCommand;
import com.example.hospital.model.Appointment;
import com.example.hospital.model.Billing;
import com.example.hospital.model.CreditCard;
import com.example.hospital.model.PaymentCommand;
import com.example.hospital.repository.DoctorRepository;
import com.example.hospital.repository.MedicinePrescriptionRepository;
import com.example.hospital.repository.MedicineRepository;
import com.example.hospital.repository.NurseRepository;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.repository.SpecializationRepository;
import com.example.hospital.repository.PrescriptionRepository;
import com.example.hospital.repository.AppointmentRepository;
import com.example.hospital.repository.BillingRepository;
import com.example.hospital.repository.CreditCardRepository;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HospitalController {
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
    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private MedicinePrescriptionRepository medicinePrescriptionRepository;
    @Autowired
    private BillingRepository billingRepository;
    @Autowired
    private CreditCardRepository creditCardRepository;

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
        PrescriptionCommand prescriptionCommand = new PrescriptionCommand();
        model.addAttribute("prescriptionCommand", prescriptionCommand);
        List<Medicine> medicineOptions = medicineRepository.findAll();
        model.addAttribute("medicineOptions", medicineOptions);
        return "prescription";
    }

    @RequestMapping(value = { "/prescription" }, method = RequestMethod.POST)
    public String registerPrescription(@Valid @ModelAttribute("prescriptionCommand") PrescriptionCommand pc) {
        System.out.println(pc);
        Prescription prescription = new Prescription();

        Medicine m = medicineRepository.findByMedicineId(pc.getMedicineId());
        System.out.println("Medicine after retrieval: " + m);
        System.out.println("Medicine name: " + m.getName());
        prescription.setName(m.getName());
        prescription.setDate(pc.getDate());
        prescription.setDoctorId(pc.getDoctorId());
        prescription.setFrequency(pc.getFrequency());
        prescription.setIntake(pc.getIntake());
        prescription.setPatientId(pc.getPatientId());
        prescription.setQuantity(pc.getQuantity());
        System.out.println(prescription);
        Prescription p = prescriptionRepository.saveAndFlush(prescription);
        System.out.println("Prescription after insert: " + p);

        MedicinePrescription mp = new MedicinePrescription();
        mp.setMedicineId(pc.getMedicineId());
        mp.setPrescriptionId(p.getPrescriptionId());
        medicinePrescriptionRepository.save(mp);

        return "prescriptionTable";
    }

    @RequestMapping(value = { "/allPrescriptions" }, method = RequestMethod.GET)
    public String showPrescriptionTable(Model model) {
        List<PrescriptionCommand> pcList = new ArrayList<PrescriptionCommand>();
        List<Prescription> prescriptionList = prescriptionRepository.findAll();

        System.out.println(prescriptionList);

        for (Prescription p : prescriptionList) {
            MedicinePrescription mp = medicinePrescriptionRepository.findByPrescriptionId(p.getPrescriptionId());
            System.out.println("Medicine id of prescription " + p.getPrescriptionId() + " : " + mp.getMedicineId());
            Medicine m = medicineRepository.findByMedicineId(mp.getMedicineId());
            PrescriptionCommand pc = new PrescriptionCommand(
                    p.getPrescriptionId(),
                    m.getMedicineId(),
                    m.getName(),
                    m.getCost(),
                    m.getDescription(),
                    p.getQuantity(),
                    p.getIntake(),
                    p.getFrequency(),
                    p.getDate(),
                    p.getDoctorId(),
                    p.getPatientId());
            pcList.add(pc);
        }

        model.addAttribute("prescriptionList", pcList);
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

    @RequestMapping(value = { "/payment" }, method = RequestMethod.GET)
    public String showPaymentForm(Model model) {
        PaymentCommand pc = new PaymentCommand();
        model.addAttribute("paymentCommand", pc);
        return "payment";
    }

    @RequestMapping(value = { "/payment" }, method = RequestMethod.POST)
    public String registerPayment(@Valid @ModelAttribute("paymentCommand") PaymentCommand pc) {
        Billing billing = new Billing();
        System.out.println(pc);
        billing.setPatientId(pc.getPatientId());
        billing.setDate(pc.getDate());
        billing.setAmount(pc.getAmount());
        billing.setCreditCardNumber(pc.getCreditCardNumber());
        System.out.println(billing);
        billingRepository.save(billing);
        System.out.println(pc);
        // Billing b = billingRepository.saveAndFlush(billing);
        // System.out.println("Billing: " + b);

        CreditCard c = new CreditCard();
        c.setCreditCardNumber(pc.getCreditCardNumber());
        c.setExpirationDate(pc.getExpirationDate());
        c.setFirstName(pc.getFirstName());
        c.setLastName(pc.getLastName());
        c.setSecurityCode(pc.getSecurityCode());
        System.out.println(c);
        creditCardRepository.save(c);

        return "billingTable";
    }

    @RequestMapping(value = { "/allBillings" }, method = RequestMethod.GET)
    public String showBillingTable(Model model) {
        model.addAttribute("billingList", billingRepository.findAll());
        return "billingTable";
    }
}
