package Entities;

import Interfaces.Billable;
import Interfaces.Displayable;
import Utils.InputHandler;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class InPatient extends Patient implements Displayable, Billable {
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private String roomNumber;
    private String bedNumber;
    private String admittingDoctorId;
    private double dailyCharges;

    public InPatient(String address, LocalDate dateOfBirth, String email, String firstName, String gender, String id, String lastName, String phoneNumber, List<String> allergies, List<Appointment> appointments, String bloodGroup, String emergencyContact, String insuranceId, List<MedicalRecord> medicalRecords, String patientId, LocalDate registrationDate, LocalDate admissionDate, LocalDate dischargeDate, String roomNumber, String bedNumber, String admittingDoctorId, double dailyCharges) {
        super(address, dateOfBirth, email, firstName, gender, id, lastName, phoneNumber, allergies, appointments, bloodGroup, emergencyContact, insuranceId, medicalRecords, patientId, registrationDate);
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.admittingDoctorId = admittingDoctorId;
        this.dailyCharges = dailyCharges;
    }

    public InPatient() {

    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        while ((getRegistrationDate() != null && admissionDate.isBefore(getRegistrationDate())) || admissionDate.isAfter(LocalDate.now())) {
            System.out.println("Invalid admission date. It cannot be before registration or in the future.");
            admissionDate = InputHandler.getDateInput("Enter Admission Date: ");
        }
        this.admissionDate = admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        while (admissionDate != null && dischargeDate.isBefore(admissionDate)){
            System.out.println("Invalid discharge date. It must be after admission.");
            dischargeDate = InputHandler.getDateInput("Enter Discharge Date: ");
        }
        this.dischargeDate = dischargeDate;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getAdmittingDoctorId() {
        return admittingDoctorId;
    }

    public void setAdmittingDoctorId(String admittingDoctorId) {
        this.admittingDoctorId = admittingDoctorId;
    }

    public double getDailyCharges() {
        return dailyCharges;
    }

    public void setDailyCharges(double dailyCharges) {
        this.dailyCharges = dailyCharges;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Admission Date: " + admissionDate);
        System.out.println("Discharge Date: " + dischargeDate);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Bed Number: " + bedNumber);
        System.out.println("Admitting Doctor ID: " + admittingDoctorId);
        System.out.println("Daily Charges: " + dailyCharges);
    }

    public double calculateStayDuration() {
        if (admissionDate == null) {
            System.out.println("Admission date is missing for patient " + getPatientId());
            return 0;
        }
        if (dischargeDate == null) {
            dischargeDate = LocalDate.now();
        }
        return ChronoUnit.DAYS.between(admissionDate, dischargeDate);
    }

    public double calculateTotalCharges() {
        return calculateStayDuration() * dailyCharges;
    }

    @Override
    public double calculateCharges() {
        return calculateTotalCharges();
    }

    @Override
    public void generateBill() {
        System.out.println("Bill for " + getFirstName() + " " + getLastName() + ": " + calculateCharges());
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Payment of " + amount + " received for patient " + getPatientId());
    }
}