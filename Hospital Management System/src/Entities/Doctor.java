package Entities;

import Interfaces.Displayable;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.List;

public class Doctor extends Person implements Displayable {
    private String doctorId;
    private String specialization;
    private String qualification;
    private Integer experienceYears;
    private String departmentId;
    private Double consultationFee;
    private List<String> availableSlots;
    private List<Patient> assignedPatients;

    public Doctor(String address, LocalDate dateOfBirth, String email, String firsName, String gender, String id, String lastName, String phoneNumber, List<Patient> assignedPatients, List<String> availableSlots, Double consultationFee, String departmentId, String doctorId, Integer experienceYears, String qualification, String specialization) {
        super(address, dateOfBirth, email, firsName, gender, id, lastName, phoneNumber);
        this.assignedPatients = assignedPatients;
        this.availableSlots = availableSlots;
        this.consultationFee = consultationFee;
        this.departmentId = departmentId;
        this.doctorId = doctorId;
        this.experienceYears = experienceYears;
        this.qualification = qualification;
        this.specialization = specialization;
    }

    public Doctor() {

    }

    public List<Patient> getAssignedPatients() {
        return assignedPatients;
    }

    public void setAssignedPatients(List<Patient> assignedPatients) {
        this.assignedPatients = assignedPatients;
    }

    public List<String> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<String> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public Double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(Double consultationFee) {
        while (!HelperUtils.isPositive(consultationFee)){
            System.out.println("Invalid consultation fee. It must be positive.");
            consultationFee = InputHandler.getDoubleInput("Enter consultation fee: ");
        }
        this.consultationFee = consultationFee;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Doctor Id: " + doctorId);
        System.out.println("Specialization: " + specialization);
        System.out.println("Qualification: " + qualification);
        System.out.println("Experience Years: " + experienceYears);
        System.out.println("Department Id: " + departmentId);
        System.out.println("Consultation Fee: " + consultationFee);
        System.out.println("availableSlots: " + availableSlots);
        if (assignedPatients != null && !assignedPatients.isEmpty()) {
            System.out.print("assignedPatients: [");
            for (int i = 0; i < assignedPatients.size(); i++) {
                Patient p = assignedPatients.get(i);
                System.out.print(p.getPatientId() + " - " + p.getFirstName() + " " + p.getLastName());
                if (i < assignedPatients.size() - 1) System.out.print(", ");
            }
            System.out.println("]");
        } else {
            System.out.println("assignedPatients: []");
        }
    }

    @Override
    public void displaySummary() {
        System.out.println("Doctor: " + getFirstName() + " " + getLastName() + ", ID: " + doctorId);
    }

    public void assignPatient(Patient patient) {
        assignedPatients.add(patient);
        System.out.println("Assigned patient has been added successfully");

    }

    public void removePatient(Patient patient) {
        assignedPatients.remove(patient);
        System.out.println("Assigned patient has been remove successfully");
    }

    public void updateAvailability(List<String> slots) {
        this.availableSlots = slots;
    }

    public void updateFee(double fee) {
        this.consultationFee = fee;
        System.out.println("Consultation fee updated successfully.");
    }

    public void updateFee(double fee, String reason) {
        this.consultationFee = fee;
        System.out.println("Consultation fee updated successfully. Reason: " + reason);
    }

    public void addAvailability(String slot) {
        this.availableSlots.add(slot);
        System.out.println("Availability slot added successfully: " + slot);
    }

    public void addAvailability(List<String> slots) {
        this.availableSlots.addAll(slots);
        System.out.println("Availability slots added successfully: " + slots);
    }
}