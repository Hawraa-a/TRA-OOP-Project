package Entities;

import Interfaces.Displayable;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Person implements Displayable {
    private String patientId;
    private String bloodGroup;
    private List<String> allergies = new ArrayList<>();
    private String emergencyContact;
    private LocalDate registrationDate;
    private String insuranceId;
    private List<MedicalRecord> medicalRecords = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();

    public Patient(String address, LocalDate dateOfBirth, String email, String firstName, String gender, String id, String lastName, String phoneNumber, List<String> allergies, List<Appointment> appointments, String bloodGroup, String emergencyContact, String insuranceId, List<MedicalRecord> medicalRecords, String patientId, LocalDate registrationDate) {
        super(address, dateOfBirth, email, firstName, gender, id, lastName, phoneNumber);
        this.allergies = allergies != null ? allergies : new ArrayList<>();
        this.appointments = appointments;
        this.bloodGroup = bloodGroup;
        this.emergencyContact = emergencyContact;
        this.insuranceId = insuranceId;
        this.medicalRecords = medicalRecords;
        this.patientId = patientId;
        this.registrationDate = registrationDate;
    }

    public Patient() {
        super();
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        List<String> validGroups = List.of("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");
        while (bloodGroup == null || !validGroups.contains(bloodGroup.toUpperCase())) {
            System.out.println("Invalid blood group. Please enter a valid type (A+, A-, B+, B-, AB+, AB-, O+, O-):");
            bloodGroup = InputHandler.getStringInput("Enter Blood Group: ");
        }
        this.bloodGroup = bloodGroup;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        String regex = "^[0-9]{8,15}$";
        while (HelperUtils.isNull(emergencyContact) || !emergencyContact.matches(regex)) {
            System.out.println("Invalid emergency contact. Please enter a valid phone number (8–15 digits).");
            emergencyContact = InputHandler.getStringInput("Enter Emergency Contact: ");
        }
        this.emergencyContact = emergencyContact;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        while (registrationDate.isBefore(getDateOfBirth()) || registrationDate.isAfter(LocalDate.now())) {
            System.out.println("Registration date cannot be before date of birth OR in the future.");
            registrationDate = InputHandler.getDateInput("Enter Registration Date: ");
        }
        this.registrationDate = registrationDate;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Patient Id: " + patientId);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Allergies: " + (!allergies.isEmpty() ? String.join(", ", allergies) : "None"));
        System.out.println("Emergency Contact: " + emergencyContact);
        System.out.println("Registration Date: " + registrationDate);
        System.out.println("Insurance Id: " + insuranceId);
        System.out.println("Medical Records: " + medicalRecords);
        System.out.println("Appointments: " + appointments);
    }

    @Override
    public void displaySummary() {
        System.out.println("Patient: " + getFirstName() + " " + getLastName() + ", ID: " + patientId);
    }

    public void addMedicalRecord(MedicalRecord record) {
        if (record != null) {
            medicalRecords.add(record);
            System.out.println("Medical Record has been added successfully");
        }
    }

    public void addAppointment(Appointment appointment) {
        if (appointment != null) {
            appointments.add(appointment);
            System.out.println("Appointment has been added successfully");
        }
    }

    public void updateInsurance(String newInsurance) {
        this.insuranceId = newInsurance;
        System.out.println("Insurance has been updated successfully");
    }

    public void updateContact(String phone) {
        setPhoneNumber(phone);
        System.out.println("Phone number updated successfully");
    }

    public void updateContact(String phone, String email) {
        setPhoneNumber(phone);
        setEmail(email);
        System.out.println("Phone number and email updated successfully");
    }

    public void updateContact(String phone, String email, String address) {
        setPhoneNumber(phone);
        setEmail(email);
        setAddress(address);
        System.out.println("Phone number, email and address updated successfully");
    }
}