package Entities;

import Interfaces.Displayable;

import java.time.LocalDate;
import java.util.List;

public class EmergencyPatient extends InPatient implements Displayable {
    private String emergencyType;
    private String arrivalMode;
    private Integer triageLevel; // 1-5
    private boolean admittedViaER;

    public EmergencyPatient(String address, LocalDate dateOfBirth, String email, String firstName, String gender, String id, String lastName, String phoneNumber, List<String> allergies, List<Appointment> appointments, String bloodGroup, String emergencyContact, String insuranceId, List<MedicalRecord> medicalRecords, String patientId, LocalDate registrationDate, LocalDate admissionDate, LocalDate dischargeDate, String roomNumber, String bedNumber, String admittingDoctorId, double dailyCharges, boolean admittedViaER, String arrivalMode, String emergencyType, Integer triageLevel) {
        super(address, dateOfBirth, email, firstName, gender, id, lastName, phoneNumber, allergies, appointments, bloodGroup, emergencyContact, insuranceId, medicalRecords, patientId, registrationDate, admissionDate, dischargeDate, roomNumber, bedNumber, admittingDoctorId, dailyCharges);
        this.admittedViaER = admittedViaER;
        this.arrivalMode = arrivalMode;
        this.emergencyType = emergencyType;
        this.triageLevel = triageLevel;
    }

    public EmergencyPatient() {

    }

    public String getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(String emergencyType) {
        this.emergencyType = emergencyType;
    }

    public String getArrivalMode() {
        return arrivalMode;
    }

    public void setArrivalMode(String arrivalMode) {
        this.arrivalMode = arrivalMode;
    }

    public Integer getTriageLevel() {
        return triageLevel;
    }

    public void setTriageLevel(Integer triageLevel) {
        while (triageLevel == null || triageLevel < 1 || triageLevel > 5) {
            System.out.println("Triage level must be between 1 and 5.");
            triageLevel = Utils.InputHandler.getIntInput("Enter triage level (1-5): ", 1, 5);
        }
        this.triageLevel = triageLevel;
    }

    public boolean isAdmittedViaER() {
        return admittedViaER;
    }

    public void setAdmittedViaER(boolean admittedViaER) {
        this.admittedViaER = admittedViaER;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Emergency Type: " + emergencyType);
        System.out.println("Arrival Mode: " + arrivalMode);
        System.out.println("Triage Level: " + triageLevel);
        System.out.println("Admitted ViaER: " + admittedViaER);
    }
}
