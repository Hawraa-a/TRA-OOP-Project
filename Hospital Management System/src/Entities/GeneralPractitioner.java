package Entities;

import Interfaces.Displayable;

import java.time.LocalDate;
import java.util.List;

public class GeneralPractitioner extends Doctor implements Displayable {
    private boolean walkinAvailable;
    private boolean homeVisitAvailable;
    private boolean vaccinationCertified;

    public GeneralPractitioner(String address, LocalDate dateOfBirth, String email, String firsName, String gender, String id, String lastName, String phoneNumber, List<Patient> assignedPatients, List<String> availableSlots, Double consultationFee, String departmentId, String doctorId, Integer experienceYears, String qualification, String specialization, boolean homeVisitAvailable, boolean vaccinationCertified, boolean walkinAvailable) {
        super(address, dateOfBirth, email, firsName, gender, id, lastName, phoneNumber, assignedPatients, availableSlots, consultationFee, departmentId, doctorId, experienceYears, qualification, specialization);
        this.homeVisitAvailable = homeVisitAvailable;
        this.vaccinationCertified = vaccinationCertified;
        this.walkinAvailable = walkinAvailable;
    }

    public GeneralPractitioner() {

    }

    public boolean isWalkinAvailable() {
        return walkinAvailable;
    }

    public void setWalkinAvailable(boolean walkinAvailable) {
        this.walkinAvailable = walkinAvailable;
    }

    public boolean isHomeVisitAvailable() {
        return homeVisitAvailable;
    }

    public void setHomeVisitAvailable(boolean homeVisitAvailable) {
        this.homeVisitAvailable = homeVisitAvailable;
    }

    public boolean isVaccinationCertified() {
        return vaccinationCertified;
    }

    public void setVaccinationCertified(boolean vaccinationCertified) {
        this.vaccinationCertified = vaccinationCertified;
    }

    public void scheduleHomeVisit(Patient patient) {
        if (homeVisitAvailable) {
            System.out.println("Scheduled home visit for patient: " + patient.getPatientId());
        }
        else {
            System.out.println("Home visit not available.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Walkin available: " + walkinAvailable);
        System.out.println("Home visit available: " + homeVisitAvailable);
        System.out.println("Vaccination certified: " + vaccinationCertified);
    }

    public void administerVaccine(Patient patient) {
        if (vaccinationCertified) {
            System.out.println("Administered vaccine to patient: " + patient.getPatientId());
        }
        else {
            System.out.println("Not certified to administer vaccines.");
        }
    }
}