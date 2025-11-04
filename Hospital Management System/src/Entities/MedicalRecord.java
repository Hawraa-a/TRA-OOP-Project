package Entities;

import Interfaces.Displayable;

import java.time.LocalDate;

public class MedicalRecord implements Displayable {
    private String recordId;
    private String patientId;
    private String doctorId;
    private LocalDate visitDate;
    private String diagnosis;
    private String prescription;
    private String testResults;
    private String notes;

    public MedicalRecord(String diagnosis, String doctorId, String notes, String patientId, String prescription, String recordId, String testResults, LocalDate visitDate) {
        this.diagnosis = diagnosis;
        this.doctorId = doctorId;
        this.notes = notes;
        this.patientId = patientId;
        this.prescription = prescription;
        this.recordId = recordId;
        this.testResults = testResults;
        this.visitDate = visitDate;
    }

    public MedicalRecord() {

    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
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

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        this.testResults = testResults;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public void displayInfo() {
        System.out.println("Record Id: " + recordId);
        System.out.println("Patient Id: " + patientId);
        System.out.println("Doctor Id: " + doctorId);
        System.out.println("Visit Date: " + visitDate);
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Prescription: " + prescription);
        System.out.println("Test Results: " + testResults);
        System.out.println("Notes: " + notes);
    }
    @Override
    public void displaySummary() {
        System.out.println("Record Id: " + recordId);
        System.out.println("Patient Id: " + patientId);
        System.out.println("Doctor Id: " + doctorId);
        System.out.println("Visit Date: " + visitDate);
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "diagnosis='" + diagnosis + '\'' +
                ", recordId='" + recordId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", visitDate=" + visitDate +
                ", prescription='" + prescription + '\'' +
                ", testResults='" + testResults + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
