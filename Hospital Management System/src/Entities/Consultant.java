package Entities;

import Interfaces.Displayable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Consultant extends Doctor implements Displayable {
    private List<String> consultationTypes;
    private boolean onlineConsultationAvailable;
    private Integer consultationDuration;

    public Consultant(String address, LocalDate dateOfBirth, String email, String firsName, String gender, String id, String lastName, String phoneNumber, List<Patient> assignedPatients, List<String> availableSlots, Double consultationFee, String departmentId, String doctorId, Integer experienceYears, String qualification, String specialization, Integer consultationDuration, List<String> consultationTypes, boolean onlineConsultationAvailable) {
        super(address, dateOfBirth, email, firsName, gender, id, lastName, phoneNumber, assignedPatients, availableSlots, consultationFee, departmentId, doctorId, experienceYears, qualification, specialization);
        this.consultationDuration = consultationDuration;
        this.consultationTypes = consultationTypes;
        this.onlineConsultationAvailable = onlineConsultationAvailable;
    }

    public Consultant() {

    }

    public List<String> getConsultationTypes() {
        return consultationTypes;
    }

    public void setConsultationTypes(List<String> consultationTypes) {
        this.consultationTypes = consultationTypes;
    }

    public boolean isOnlineConsultationAvailable() {
        return onlineConsultationAvailable;
    }

    public void setOnlineConsultationAvailable(boolean onlineConsultationAvailable) {
        this.onlineConsultationAvailable = onlineConsultationAvailable;
    }

    public Integer getConsultationDuration() {
        return consultationDuration;
    }

    public void setConsultationDuration(Integer consultationDuration) {
        this.consultationDuration = consultationDuration;
    }

    public void scheduleConsultation(String type) {
        if (type != null) {
            consultationTypes.add(type);
            System.out.println("Consultation type '" + type + "' scheduled successfully.");
        } else {
            System.out.println("Invalid consultation type.");
        }
    }

    public void provideSecondOpinion(Patient patient) {
        System.out.println("Providing second opinion for patient: " + patient.getPatientId());
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Consultation Types: " + consultationTypes);
        System.out.println("Online Consultation Available: " + onlineConsultationAvailable);
        System.out.println("Consultations Duration " + consultationDuration);
    }
}
