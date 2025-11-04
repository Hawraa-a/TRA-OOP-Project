package Entities;

import Interfaces.Displayable;

import java.time.LocalDate;
import java.util.List;

public class Surgeon extends Doctor implements Displayable {
    private int surgeriesPerformed;
    private List<String> surgeryTypes;
    private boolean operationTheatreAccess;

    public Surgeon(String address, LocalDate dateOfBirth, String email, String firsName, String gender, String id, String lastName, String phoneNumber, List<Patient> assignedPatients, List<String> availableSlots, Double consultationFee, String departmentId, String doctorId, Integer experienceYears, String qualification, String specialization, boolean operationTheatreAccess, int surgeriesPerformed, List<String> surgeryTypes) {
        super(address, dateOfBirth, email, firsName, gender, id, lastName, phoneNumber, assignedPatients, availableSlots, consultationFee, departmentId, doctorId, experienceYears, qualification, specialization);
        this.operationTheatreAccess = operationTheatreAccess;
        this.surgeriesPerformed = surgeriesPerformed;
        this.surgeryTypes = surgeryTypes;
    }

    public Surgeon(boolean operationTheatreAccess, int surgeriesPerformed, List<String> surgeryTypes) {
        this.operationTheatreAccess = operationTheatreAccess;
        this.surgeriesPerformed = surgeriesPerformed;
        this.surgeryTypes = surgeryTypes;
    }

    public Surgeon() {

    }

    public int getSurgeriesPerformed() {
        return surgeriesPerformed;
    }

    public void setSurgeriesPerformed(int surgeriesPerformed) {
        this.surgeriesPerformed = surgeriesPerformed;
    }

    public List<String> getSurgeryTypes() {
        return surgeryTypes;
    }

    public void setSurgeryTypes(List<String> surgeryTypes) {
        this.surgeryTypes = surgeryTypes;
    }

    public boolean isOperationTheatreAccess() {
        return operationTheatreAccess;
    }

    public void setOperationTheatreAccess(boolean operationTheatreAccess) {
        this.operationTheatreAccess = operationTheatreAccess;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Surgeries Performed: " + surgeriesPerformed);
        System.out.println("Surgery Types: " + String.join(", ", surgeryTypes));
        System.out.println("Operation Theatre Access: " + operationTheatreAccess);
    }

    public void performSurgery(String surgeryType){
        if (operationTheatreAccess) {
            surgeriesPerformed++;
            surgeryTypes.add(surgeryType);
            System.out.println("Performed surgery: " + surgeryType);
        } else {
            System.out.println("No theatre access.");
        }
    }

    public void updateSurgeryCount(int count) {
        if (count > 0) {
            this.surgeriesPerformed = count;
        }
    }
}