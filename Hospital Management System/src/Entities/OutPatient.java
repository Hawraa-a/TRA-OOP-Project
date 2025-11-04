package Entities;

import Interfaces.Displayable;

import java.time.LocalDate;
import java.util.List;

public class OutPatient extends Patient implements Displayable {
    private int visitCount;
    private LocalDate lastVisitDate;
    private String preferredDoctorId;

    public OutPatient(String address, LocalDate dateOfBirth, String email, String firstName, String gender, String id, String lastName, String phoneNumber, List<String> allergies, List<Appointment> appointments, String bloodGroup, String emergencyContact, String insuranceId, List<MedicalRecord> medicalRecords, String patientId, LocalDate registrationDate, int visitCount, LocalDate lastVisitDate, String preferredDoctorId) {
        super(address, dateOfBirth, email, firstName, gender, id, lastName, phoneNumber, allergies, appointments, bloodGroup, emergencyContact, insuranceId, medicalRecords, patientId, registrationDate);
        this.visitCount = visitCount;
        this.lastVisitDate = lastVisitDate;
        this.preferredDoctorId = preferredDoctorId;
    }

    public OutPatient() {

    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public LocalDate getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(LocalDate lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public String getPreferredDoctorId() {
        return preferredDoctorId;
    }

    public void setPreferredDoctorId(String preferredDoctorId) {
        this.preferredDoctorId = preferredDoctorId;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Visit Count: " + visitCount);
        System.out.println("Last Visit Date: " + lastVisitDate);
        System.out.println("Preferred Doctor ID: " + preferredDoctorId);
    }

    public void scheduleFollowUp(LocalDate visitDate) {

    }

    public void updateVisitCount(int visits) {
        this.visitCount = visits;
    }
}
