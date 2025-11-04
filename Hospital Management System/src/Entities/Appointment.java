package Entities;

import Interfaces.Displayable;
import Utils.InputHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Appointment implements Displayable {
    private String appointmentId;
    private String patientId;
    private String doctorId;
    private LocalDate appointmentDate;
    private String status;
    private String appointmentTime;
    private String reason;
    private String notes;

    public Appointment(LocalDate appointmentDate, String appointmentId, String appointmentTime, String doctorId, String notes, String patientId, String reason, String status) {
        this.appointmentDate = appointmentDate;
        this.appointmentId = appointmentId;
        this.appointmentTime = appointmentTime;
        this.doctorId = doctorId;
        this.notes = notes;
        this.patientId = patientId;
        this.reason = reason;
        this.status = status;
    }

    public Appointment() {

    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        while (appointmentDate == null || appointmentDate.isBefore(LocalDate.now())) {
            System.out.println("Appointment date cannot be in the past.");
            appointmentDate = InputHandler.getDateInput("Enter a valid appointment date: ");
        }
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        while (!status.equalsIgnoreCase("Scheduled") && !status.equalsIgnoreCase("Rescheduled") && !status.equalsIgnoreCase("Complete") && !status.equalsIgnoreCase("Cancelled")) {
            System.out.println("Invalid status. Must be Scheduled, Rescheduled, Complete, or Cancelled.");
            status = Utils.InputHandler.getStringInput("Enter appointment status: ");
        }
        this.status = status;
    }

    public void displayInfo() {
        System.out.println("Appointment Id: " + appointmentId);
        System.out.println("Patient Id: " + patientId);
        System.out.println("Doctor Id: " + doctorId);
        System.out.println("Appointment Date: " + appointmentDate);
        System.out.println("Appointment Time: " + appointmentTime);
        System.out.println("Status: " + status);
        System.out.println("Reason: " + reason);
        System.out.println("Notes: " + notes);
    }

    @Override
    public void displaySummary() {
        System.out.println("Appointment Id: " + appointmentId);
        System.out.println("appointmentDate: " + appointmentDate);
        System.out.println("appointmentTime: " + appointmentTime);
        System.out.println("patientId: " + patientId);
        System.out.println("doctorId: " + doctorId);
        System.out.println("status" + status);
    }

    public void reschedule(LocalDate newDate, String newTime) {
        this.appointmentDate = newDate;
        this.appointmentTime = newTime;
        this.status = "Rescheduled";
    }

    public void cancel() {
        this.status = "cancel";
    }

    public void complete() {
        this.status = "complete";
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentDate=" + appointmentDate +
                ", appointmentId='" + appointmentId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", status='" + status + '\'' +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", reason='" + reason + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }

    public void addNotes(String notes) {
        this.notes = notes;
        System.out.println("Notes added successfully.");
    }

    public void addNotes(String notes, String addedBy) {
        this.notes = notes + " (Added by: " + addedBy + ")";
        System.out.println("Notes added successfully by " + addedBy + ".");
    }

    public void addNotes(String notes, String addedBy, LocalDateTime timestamp) {
        this.notes = notes + " (Added by: " + addedBy + " at " + timestamp + ")";
        System.out.println("Notes added successfully by " + addedBy + " on " + timestamp + ".");
    }
}