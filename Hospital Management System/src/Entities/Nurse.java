package Entities;

import Interfaces.Displayable;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.List;

public class Nurse extends Person implements Displayable {
    private String nurseId;
    private String departmentId;
    private String shift; //Morning/Evening/Night
    private String qualification;
    private List<Patient> assignedPatients;

    public Nurse(String address, LocalDate dateOfBirth, String email, String firsName, String gender, String id, String lastName, String phoneNumber, List<Patient> assignedPatients, String departmentId, String nurseId, String qualification, String shift) {
        super(address, dateOfBirth, email, firsName, gender, id, lastName, phoneNumber);
        this.assignedPatients = assignedPatients;
        this.departmentId = departmentId;
        this.nurseId = nurseId;
        this.qualification = qualification;
        this.shift = shift;
    }

    public Nurse() {

    }

    public List<Patient> getAssignedPatients() {
        return assignedPatients;
    }

    public void setAssignedPatients(List<Patient> assignedPatients) {
        this.assignedPatients = assignedPatients;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getNurseId() {
        return nurseId;
    }

    public void setNurseId(String nurseId) {
        this.nurseId = nurseId;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        while (!shift.equalsIgnoreCase("Morning") && !shift.equalsIgnoreCase("Evening") && !shift.equalsIgnoreCase("Night")) {
            System.out.println("Invalid shift. Must be Morning, Evening, or Night.");
            shift = InputHandler.getStringInput("Enter Shift: ");
        }
        this.shift = shift;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Nurse Id: " + nurseId);
        System.out.println("departmentId: " + departmentId);
        System.out.println("shift: " + shift);
        System.out.println("qualification: " + qualification);
        System.out.println("assignedPatients: " + assignedPatients);
        System.out.println("---------------------------------------------");
    }

    public void assignPatient(Patient patient) {
        assignedPatients.add(patient);
        System.out.println("Assigned patient has been added successfully");
    }

    public void removePatient(Patient patient) {
        assignedPatients.remove(patient);
        System.out.println("Assigned patient has been removed successfully");
    }
}
