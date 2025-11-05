package Entities;

import Interfaces.Displayable;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.util.ArrayList;
import java.util.List;

public class Department implements Displayable {
    private String departmentId;
    private String departmentName;
    private String headDoctorId;
    private List<Doctor> doctors = new ArrayList<>();;
    private List<Nurse> nurses = new ArrayList<>();;
    private Integer bedCapacity;
    private Integer availableBeds;

    public Department(Integer availableBeds, Integer bedCapacity, String departmentId, String departmentName, List<Doctor> doctors, String headDoctorId, List<Nurse> nurses) {
        this.availableBeds = availableBeds;
        this.bedCapacity = bedCapacity;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.doctors = doctors;
        this.headDoctorId = headDoctorId;
        this.nurses = nurses;
    }

    public Department() {

    }

    public Integer getAvailableBeds() {
        return availableBeds;
    }

    public void setAvailableBeds(Integer availableBeds) {
        while (!HelperUtils.isValidNumber(availableBeds, 0, bedCapacity)) {
            System.out.println("Available beds must be between 0 and " + bedCapacity + ".");
            availableBeds = InputHandler.getIntInput("Enter Valid Available Beds");
        }
        this.availableBeds = availableBeds;
    }

    public Integer getBedCapacity() {
        return bedCapacity;
    }

    public void setBedCapacity(Integer bedCapacity) {
        this.bedCapacity = bedCapacity;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public String getHeadDoctorId() {
        return headDoctorId;
    }

    public void setHeadDoctorId(String headDoctorId) {
        this.headDoctorId = headDoctorId;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(List<Nurse> nurses) {
        this.nurses = nurses;
    }

    public void displayInfo() {
        System.out.println("Department Id: " + departmentId);
        System.out.println("Department Name: " + departmentName);
        System.out.println("Head Entity.Doctor Id: " + headDoctorId);
        System.out.println("Doctors: " + doctors);
        System.out.println("Nurses: " + nurses);
        System.out.println("Bed Capacity: " + bedCapacity);
        System.out.println("Available Beds: " + availableBeds);
    }

    @Override
    public void displaySummary() {
        System.out.println("Department Id: " + departmentId);
        System.out.println("Department Name: " + departmentName);
        System.out.println("Head Entity.Doctor Id: " + headDoctorId);
        System.out.println("Bed Capacity: " + bedCapacity);
        System.out.println("Available Beds: " + availableBeds);
    }

    public void assignDoctor(Doctor doctor) {
        if (doctor != null && doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    public void assignNurse(Nurse nurse) {
        if (nurse != null && nurses.contains(nurse)) {
            nurses.add(nurse);
        }
    }

    public void updateBedAvailability(int availableBeds) {
        this.availableBeds = availableBeds;
    }
}
