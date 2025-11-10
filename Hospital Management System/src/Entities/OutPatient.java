package Entities;

import Interfaces.Displayable;
import Utils.InputHandler;

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
        while (lastVisitDate.isBefore(getRegistrationDate()) || lastVisitDate.isAfter(LocalDate.now())) {
            System.out.println("Invalid last visit date. It cannot be before registration or in the future.");
            lastVisitDate = InputHandler.getDateInput("Enter Last Visit Date: ");
        }
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
        System.out.println();
    }

    public void scheduleFollowUp(LocalDate visitDate) {
        setLastVisitDate(visitDate);
        setVisitCount(getVisitCount() + 1);
        System.out.println("Follow-up scheduled successfully. Visit count updated to " + visitCount);
    }

    public void updateVisitCount(int visits) {
        setVisitCount(visits);
        System.out.println("Visit count updated successfully to " + visitCount);
    }
}
