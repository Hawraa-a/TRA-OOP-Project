package Services;

import Entities.*;
import Interfaces.Manageable;
import Interfaces.Searchable;
import Utils.HelperUtils;
import Utils.InputHandler;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DoctorService implements Manageable<Doctor>, Searchable {
    public static List<Doctor> doctorList = new ArrayList<>();

    @Override
    public Doctor add() {
        System.out.println("=== Add New Doctor ===");
        Doctor doctor = new Doctor();

        String id = HelperUtils.generateId("PER");
        System.out.println("Generated person id: " + id);
        doctor.setId(id);
        doctor.setFirstName(InputHandler.getStringInput("Enter the First Name: "));
        doctor.setLastName(InputHandler.getStringInput("Enter the Last Name: "));
        doctor.setDateOfBirth(InputHandler.getDateInput("Enter the Date of Birth"));
        doctor.setGender(InputHandler.getStringInput("Enter the Gender (Male/Female): "));
        doctor.setPhoneNumber(InputHandler.getStringInput("Enter the Phone Number: "));
        doctor.setEmail(InputHandler.getStringInput("Enter the Email: "));
        doctor.setAddress(InputHandler.getStringInput("Enter the Address: "));

        String doctorId = HelperUtils.generateId("DR");
        System.out.println("Generated Doctor ID: " + doctorId);
        doctor.setDoctorId(doctorId);
        doctor.setSpecialization(InputHandler.getStringInput("Enter Specialization: "));
        doctor.setQualification(InputHandler.getStringInput("Enter Qualification: "));
        doctor.setExperienceYears(InputHandler.getIntInput("Enter Experience Years: "));
        doctor.setConsultationFee(InputHandler.getDoubleInput("Enter Consultation Fee: "));
        List<String> availableSlots = new ArrayList<>();
        System.out.println("Enter the available time slot (e.g., 'Monday 10AM', 'Day time'):");
        System.out.println("Type 'q' when you have finished entering all slots.");
        while (true) {
            String slot = InputHandler.getStringInput("Slot: ");
            if (slot.equalsIgnoreCase("q")) {
                break;
            }
            availableSlots.add(slot);
        }
        doctor.setAvailableSlots(availableSlots);
        doctor.setAssignedPatients(new ArrayList<>());

        return doctor;
    }

    public void save(Doctor doctor) {
        doctorList.add(doctor);
        System.out.println("The doctor was successfully added.");
    }

    public Surgeon addSurgeon() {
        System.out.println("=== Add New Surgeon ===");
        Surgeon surgeon = new Surgeon();

        String id = Utils.HelperUtils.generateId("PER");
        System.out.println("Generated person id: " + id);
        surgeon.setId(id);
        surgeon.setFirstName(InputHandler.getStringInput("Enter the First Name: "));
        surgeon.setLastName(InputHandler.getStringInput("Enter the Last Name: "));
        surgeon.setDateOfBirth(InputHandler.getDateInput("Enter the Date of Birth"));
        surgeon.setGender(InputHandler.getStringInput("Enter the Gender (Male/Female): "));
        surgeon.setPhoneNumber(InputHandler.getStringInput("Enter the Phone Number: "));
        surgeon.setEmail(InputHandler.getStringInput("Enter the Email: "));
        surgeon.setAddress(InputHandler.getStringInput("Enter the Address: "));

        String doctorId = HelperUtils.generateId("SUR");
        System.out.println("Generated Doctor ID: " + doctorId);
        surgeon.setDoctorId(doctorId);
        surgeon.setSpecialization(InputHandler.getStringInput("Enter Specialization: "));
        surgeon.setQualification(InputHandler.getStringInput("Enter Qualification: "));
        surgeon.setExperienceYears(InputHandler.getIntInput("Enter Experience Years: "));
        surgeon.setConsultationFee(InputHandler.getDoubleInput("Enter Consultation Fee: "));
        List<String> availableSlots = new ArrayList<>();
        System.out.println("Enter the available time slot (e.g., 'Monday 10AM', 'Day time'):");
        System.out.println("Type 'q' when you have finished entering all slots.");
        while (true) {
            String slot = InputHandler.getStringInput("Slot: ");
            if (slot.equalsIgnoreCase("q")) {
                break;
            }
            availableSlots.add(slot);
        }
        surgeon.setAvailableSlots(availableSlots);

        surgeon.setOperationTheatreAccess(InputHandler.getConfirmation("Operation Theatre Access: "));
        surgeon.setSurgeriesPerformed(InputHandler.getIntInput("Number of Surgeries Performed: "));
        List<String> surgeryTypes = new ArrayList<>();
        System.out.println("Enter Surgery Types (type 'q' to finish):");
        while (true) {
            String type = InputHandler.getStringInput("Surgery Type: ");
            if (type.equalsIgnoreCase("q")) break;
            surgeryTypes.add(type);
        }
        surgeon.setSurgeryTypes(surgeryTypes);
        surgeon.setAssignedPatients(new ArrayList<>());
        return surgeon;
    }

    public Consultant addConsultant() {
        System.out.println("=== Add New Consultant ===");
        Consultant consultant = new Consultant();

        String id = HelperUtils.generateId("PER");
        System.out.println("Generated person id: " + id);
        consultant.setId(id);
        consultant.setFirstName(InputHandler.getStringInput("Enter the First Name: "));
        consultant.setLastName(InputHandler.getStringInput("Enter the Last Name: "));
        consultant.setDateOfBirth(InputHandler.getDateInput("Enter the Date of Birth"));
        consultant.setGender(InputHandler.getStringInput("Enter the Gender (Male/Female): "));
        consultant.setPhoneNumber(InputHandler.getStringInput("Enter the Phone Number: "));
        consultant.setEmail(InputHandler.getStringInput("Enter the Email: "));
        consultant.setAddress(InputHandler.getStringInput("Enter the Address: "));

        String doctorId = HelperUtils.generateId("CON");
        System.out.println("Generated Doctor ID: " + doctorId);
        consultant.setDoctorId(doctorId);
        consultant.setSpecialization(InputHandler.getStringInput("Enter Specialization: "));
        consultant.setQualification(InputHandler.getStringInput("Enter Qualification: "));
        consultant.setExperienceYears(InputHandler.getIntInput("Enter Experience Years: "));
        consultant.setConsultationFee(InputHandler.getDoubleInput("Enter Consultation Fee: "));
        List<String> availableSlots = new ArrayList<>();
        System.out.println("Enter the available time slot (e.g., 'Monday 10AM', 'Day time'):");
        System.out.println("Type 'q' when you have finished entering all slots.");
        while (true) {
            String slot = InputHandler.getStringInput("Slot: ");
            if (slot.equalsIgnoreCase("q")) {
                break;
            }
            availableSlots.add(slot);
        }
        consultant.setAvailableSlots(availableSlots);

        List<String> consultationTypes = new ArrayList<>();
        System.out.println("Enter Consultation Types (type 'q' to finish):");
        while (true) {
            String type = InputHandler.getStringInput("Consultation Type: ");
            if (type.equalsIgnoreCase("q")) break;
            consultationTypes.add(type);
        }
        consultant.setConsultationTypes(consultationTypes);
        consultant.setOnlineConsultationAvailable(InputHandler.getConfirmation("Online Consultation Available: "));
        consultant.setConsultationDuration(InputHandler.getIntInput("Consultation Duration (minutes): "));
        consultant.setAssignedPatients(new ArrayList<>());
        return consultant;
    }

    public GeneralPractitioner addGeneralPractitioner() {
        System.out.println("=== Add New General Practitioner ===");
        GeneralPractitioner generalPractitioner = new GeneralPractitioner();

        String id = HelperUtils.generateId("PER");
        System.out.println("Generated person id: " + id);
        generalPractitioner.setId(id);
        generalPractitioner.setFirstName(InputHandler.getStringInput("Enter the First Name: "));
        generalPractitioner.setLastName(InputHandler.getStringInput("Enter the Last Name: "));
        generalPractitioner.setDateOfBirth(InputHandler.getDateInput("Enter the Date of Birth"));
        generalPractitioner.setGender(InputHandler.getStringInput("Enter the Gender (Male/Female): "));
        generalPractitioner.setPhoneNumber(InputHandler.getStringInput("Enter the Phone Number: "));
        generalPractitioner.setEmail(InputHandler.getStringInput("Enter the Email: "));
        generalPractitioner.setAddress(InputHandler.getStringInput("Enter the Address: "));

        String doctorId = HelperUtils.generateId("GP");
        System.out.println("Generated Doctor ID: " + doctorId);
        generalPractitioner.setDoctorId(doctorId);
        generalPractitioner.setSpecialization(InputHandler.getStringInput("Enter Specialization: "));
        generalPractitioner.setQualification(InputHandler.getStringInput("Enter Qualification: "));
        generalPractitioner.setExperienceYears(InputHandler.getIntInput("Enter Experience Years: "));
        generalPractitioner.setConsultationFee(InputHandler.getDoubleInput("Enter Consultation Fee: "));
        List<String> availableSlots = new ArrayList<>();
        System.out.println("Enter the available time slot (e.g., 'Monday 10AM', 'Day time'):");
        System.out.println("Type 'q' when you have finished entering all slots.");
        while (true) {
            String slot = InputHandler.getStringInput("Slot: ");
            if (slot.equalsIgnoreCase("q")) {
                break;
            }
            availableSlots.add(slot);
        }
        generalPractitioner.setAvailableSlots(availableSlots);

        generalPractitioner.setWalkinAvailable(InputHandler.getConfirmation("Walk-in Available: "));
        generalPractitioner.setHomeVisitAvailable(InputHandler.getConfirmation("Home Visit Available: "));
        generalPractitioner.setVaccinationCertified(InputHandler.getConfirmation("Vaccination Certified: "));
        generalPractitioner.setAssignedPatients(new ArrayList<>());

        return generalPractitioner;
    }

    public void editDoctor() {
        if (doctorList.isEmpty()) {
            System.out.println("No Doctor In The List.");
            return;
        }

        String id = InputHandler.getStringInput("Enter Doctor ID to edit: ");
        Doctor doctorToEdit = null;
        for (Doctor doctor : doctorList) {
            if (doctor.getDoctorId().equalsIgnoreCase(id)) {
                doctorToEdit = doctor;
                break;
            }
        }
        if (doctorToEdit == null) {
            System.out.println("Doctor not found.");
            return;
        }
        boolean editing = true;
        while (editing) {
            System.out.println("\nEditing Doctor: " + doctorToEdit.getFirstName() + " " + doctorToEdit.getLastName());
            System.out.println("1. First Name");
            System.out.println("2. Last Name");
            System.out.println("3. Date of Birth");
            System.out.println("4. Gender");
            System.out.println("5. Phone Number");
            System.out.println("6. Email");
            System.out.println("7. Address");
            System.out.println("8. Specialization");
            System.out.println("9. Qualification");
            System.out.println("10. Experience Years");
            System.out.println("11. Department ID");
            System.out.println("12. Consultation Fee");
            System.out.println("13. Exit Editing");
            Integer choice = InputHandler.getIntInput("Enter your choice (1-13): ");
            switch (choice) {
                case 1 -> {
                    doctorToEdit.setFirstName(InputHandler.getStringInput("Enter new First Name: "));
                }
                case 2 -> {
                    doctorToEdit.setLastName(InputHandler.getStringInput("Enter new Last Name: "));
                }
                case 3 -> {
                    doctorToEdit.setDateOfBirth(InputHandler.getDateInput("Enter new Date of Birth: "));
                }
                case 4 -> {
                    doctorToEdit.setGender(InputHandler.getStringInput("Enter new Gender: "));
                }
                case 5 -> {
                    doctorToEdit.setPhoneNumber(InputHandler.getStringInput("Enter new Phone Number: "));
                }
                case 6 -> {
                    doctorToEdit.setEmail(InputHandler.getStringInput("Enter new Email: "));
                }
                case 7 -> {
                    doctorToEdit.setAddress(InputHandler.getStringInput("Enter new Address: "));
                }
                case 8 -> {
                    doctorToEdit.setSpecialization(InputHandler.getStringInput("Enter new Specialization: "));
                }
                case 9 -> {
                    doctorToEdit.setQualification(InputHandler.getStringInput("Enter new Qualification: "));
                }
                case 10 -> {
                    doctorToEdit.setExperienceYears(InputHandler.getIntInput("Enter new Experience Years: "));
                }
                case 11 -> {
                    String newDeptId;
                    while (true) {
                        newDeptId = InputHandler.getStringInput("Enter new Department ID (required): ");
                        if (DepartmentService.checkById(newDeptId)) {
                            doctorToEdit.setDepartmentId(newDeptId);
                            break;
                        } else {
                            System.out.println("Department not found. Please enter a valid Department ID.");
                        }
                    }
                }
                case 12 -> {
                    doctorToEdit.setConsultationFee(InputHandler.getDoubleInput("Enter new Consultation Fee: "));
                }
                case 13 -> {
                    editing = false;
                    System.out.println("Exiting edit mode.");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public String getDoctorToRemove() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors in the list.");
            return null;
        }
        String id = InputHandler.getStringInput("Enter doctor ID to remove: ");

        while (!checkById(id)) {
            id = InputHandler.getStringInput("Invalid ID. Please enter another doctor ID: ");
        }
        return id;
    }

    @Override
    public void remove(String id) {
        if (id == null) {
            System.out.println("Invalid input. No doctor removed.");
            return;
        }
        if (checkById(id)) {
            doctorList.removeIf(doctor -> doctor.getDoctorId().equalsIgnoreCase(id));
            System.out.println("Doctor removed successfully.");
        } else {
            System.out.println("Doctor not found.");
        }
    }

    @Override
    public List<Doctor> getAll() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors found.");
        } else {
            for (Doctor doctor : doctorList) {
                doctor.displayInfo();
            }
        }
        return doctorList;
    }

    @Override
    public void search() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors available.");
            return;
        }
        String name = InputHandler.getStringInput("Enter Doctor First Name to search: ");
        for (Doctor doctor : doctorList) {
            if (doctor.getFirstName().equalsIgnoreCase(name)) {
                doctor.displayInfo();
                return;
            }
        }
        System.out.println("No doctor found with the name: " + name);
    }

    @Override
    public void searchById() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors available.");
            return;
        }
        String id = InputHandler.getStringInput("Enter Doctor ID to search: ");
        for (Doctor doctor : doctorList) {
            if (doctor.getDoctorId().equalsIgnoreCase(id)) {
                doctor.displayInfo();
                return;
            }
        }
        System.out.println("No doctor found with ID: " + id);
    }

    public void getDoctorsBySpecialization() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors available.");
            return;
        }
        String specialization = InputHandler.getStringInput("Enter Specialization: ");
        List<Doctor> doctorsBySpecial = new ArrayList<>();
        for (Doctor doctor : doctorList) {
            if (doctor.getSpecialization() != null && doctor.getSpecialization().equalsIgnoreCase(specialization)) {
                doctorsBySpecial.add(doctor);
            }
        }
        if (doctorsBySpecial.isEmpty()) {
            System.out.println("No doctors found for specialization: " + specialization);
        } else {
            System.out.println("Doctors with specialization " + specialization + ":");
            for (Doctor doctor : doctorsBySpecial) {
                doctor.displayInfo();
            }
        }
    }

    public void getAvailableDoctors() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors available.");
            return;
        }
        String slot = InputHandler.getStringInput("Enter the time slot (e.g., 'Monday 10AM', 'Day time'): ");
        for (Doctor doctor : doctorList) {
            List<String> slots = doctor.getAvailableSlots();
            if (!slots.isEmpty() && slots.stream().anyMatch(s -> s.equalsIgnoreCase(slot))) {
                System.out.println("The List of The Available Doctors");
                doctor.displaySummary();
                return;
            }
        }
        System.out.println("No Doctors available at the specified time slot.");
    }

    public void assignPatientToDoctor() {
        String doctorId = InputHandler.getStringInput("Enter Doctor ID: ");
        if (!checkById(doctorId)) {
            System.out.println("Doctor not found.");
            return;
        }
        Doctor doctorToAssign = null;
        for (Doctor doctor : doctorList) {
            if (doctor.getDoctorId().equalsIgnoreCase(doctorId)) {
                doctorToAssign = doctor;
                break;
            }
        }
        String patientId = InputHandler.getStringInput("Enter Patient ID to assign: ");
        if (!PatientService.checkById(patientId)) {
            System.out.println("Patient not found.");
            return;
        }
        Patient patientToAssign = null;
        for (Patient patient : PatientService.patientList) {
            if (patient.getPatientId().equalsIgnoreCase(patientId)) {
                patientToAssign = patient;
                break;
            }
        }
        if (doctorToAssign != null && patientToAssign != null) {
            doctorToAssign.assignPatient(patientToAssign);
        }
    }

    public Doctor addDoctor(String name, String specialization, String phone) {
        Doctor doctor = new Doctor();
        doctor.setId(HelperUtils.generateId("PER"));
        doctor.setDoctorId(HelperUtils.generateId("DOC"));
        doctor.setFirstName(name);
        doctor.setSpecialization(specialization);
        doctor.setPhoneNumber(phone);

        return doctor;
    }

    public Doctor addDoctor(String name, String specialization, String phone, double consultationFee) {
        Doctor doctor = new Doctor();
        doctor.setId(HelperUtils.generateId("PER"));
        doctor.setDoctorId(HelperUtils.generateId("DOC"));
        doctor.setFirstName(name);
        doctor.setSpecialization(specialization);
        doctor.setPhoneNumber(phone);
        doctor.setConsultationFee(consultationFee);

        return doctor;
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctor;
    }

    public void assignPatient(String doctorId, String patientId) {
        Doctor doctor = null;
        for (Doctor d : DoctorService.doctorList) {
            if (d.getDoctorId().equalsIgnoreCase(doctorId)) {
                doctor = d;
                break;
            }
        }
        if (doctor == null) {
            System.out.println("Doctor not found with ID: " + doctorId);
            return;
        }
        Patient patient = null;
        for (Patient p : PatientService.patientList) {
            if (p.getPatientId().equalsIgnoreCase(patientId)) {
                patient = p;
                break;
            }
        }
        if (patient == null) {
            System.out.println("Patient not found with ID: " + patientId);
            return;
        }
        if (doctor.getAssignedPatients() == null) {
            doctor.setAssignedPatients(new java.util.ArrayList<>());
        }
        doctor.getAssignedPatients().add(patient);
        System.out.println("Patient " + patient.getFirstName() + " assigned successfully to Doctor " + doctor.getFirstName());
    }

    public void assignPatient(Doctor doctor, Patient patient) {
        if (doctor == null) {
            System.out.println("Doctor is null. Cannot assign patient.");
            return;
        }
        if (patient == null) {
            System.out.println("Patient is null. Cannot assign to doctor.");
            return;
        }

        if (doctor.getAssignedPatients() == null) {
            doctor.setAssignedPatients(new java.util.ArrayList<>());
        }
        doctor.getAssignedPatients().add(patient);
        System.out.println("Patient " + patient.getFirstName() + " successfully assigned to Doctor " + doctor.getFirstName());
    }

    public static void assignPatient(String doctorId, List<String> patientIds) {
        Doctor doctor = null;
        for (Doctor d : doctorList) {
            if (d.getDoctorId().equalsIgnoreCase(doctorId)) {
                doctor = d;
                break;
            }
        }
        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }
        if (doctor.getAssignedPatients() == null) {
            doctor.setAssignedPatients(new ArrayList<>());
        }

        for (String patientId : patientIds) {
            for (Patient p : PatientService.patientList) {
                if (p.getPatientId().equalsIgnoreCase(patientId)) {
                    doctor.getAssignedPatients().add(p);
                    break;
                }
            }
        }
        System.out.println("Patients " + patientIds + " assigned to Doctor " + doctor.getFirstName());
    }

    public void displayDoctors() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors available.");
            return;
        }

        System.out.println("=== Displaying All Doctors ===");
        for (Doctor d : doctorList) {
            d.displayInfo();
        }
    }

    public void displayDoctors(String specialization) {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors available.");
            return;
        }
        boolean found = false;
        System.out.println("=== Doctors with specialization: " + specialization + " ===");
        for (Doctor d : doctorList) {
            if (d.getSpecialization() != null && d.getSpecialization().equalsIgnoreCase(specialization)) {
                d.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No doctors found with specialization: " + specialization);
        }
    }

    public static void displayDoctors(String departmentId, boolean showAvailableOnly) {
        boolean found = false;
        for (Doctor doctor : doctorList) {
            if (doctor.getDepartmentId().equalsIgnoreCase(departmentId)) {
                if (!showAvailableOnly || (doctor.getAvailableSlots() != null && !doctor.getAvailableSlots().isEmpty())) {
                    doctor.displayInfo();
                    System.out.println("Available Slots: " + doctor.getAvailableSlots());
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No doctors found for department: " + departmentId);
        }
    }

    public static boolean checkById(String id) {
        for (Doctor doctor : doctorList) {
            if (doctor.getDoctorId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public static void addSampleDoctors() {
        for (int i = 0; i < 3; i++) {
            Surgeon surgeon = new Surgeon();
            surgeon.setId(HelperUtils.generateId("PER"));
            surgeon.setDoctorId(HelperUtils.generateId("SUR"));
            surgeon.setFirstName("Surgeon" + i);
            surgeon.setLastName("Al Harthy");
            surgeon.setGender(i % 2 == 0 ? "Male" : "Female");
            surgeon.setDateOfBirth(LocalDate.of(1980 + i, (i % 12) + 1, (i % 27) + 1));
            surgeon.setPhoneNumber("9800000" + i);
            surgeon.setEmail("sur" + i + "@hospital.com");
            surgeon.setAddress("Muscat, Oman - Block " + i);
            surgeon.setSpecialization(i % 2 == 0 ? "Cardiac Surgery" : "Neurosurgery");
            surgeon.setQualification("MD, PhD");
            surgeon.setExperienceYears(10 + i);
            surgeon.setConsultationFee(50.0 + (i * 10));
            surgeon.setAvailableSlots(List.of("Monday 10AM", "Wednesday 3PM"));
            surgeon.setOperationTheatreAccess(true);
            surgeon.setSurgeriesPerformed(100 + (i * 20));
            surgeon.setSurgeryTypes(List.of("Appendectomy", "Bypass Surgery"));
            surgeon.setAssignedPatients(new ArrayList<>());
            doctorList.add(surgeon);
        }

        for (int i = 0; i < 3; i++) {
            Consultant consultant = new Consultant();
            consultant.setId(HelperUtils.generateId("PER"));
            consultant.setDoctorId(HelperUtils.generateId("CON"));
            consultant.setFirstName("Consultant" + i);
            consultant.setLastName("Al Habsi");
            consultant.setGender(i % 2 == 0 ? "Female" : "Male");
            consultant.setDateOfBirth(LocalDate.of(1982 + i, (i % 12) + 1, (i % 27) + 1));
            consultant.setPhoneNumber("9700000" + i);
            consultant.setEmail("con" + i + "@hospital.com");
            consultant.setAddress("Sohar, Oman - Building " + i);
            consultant.setSpecialization(i % 2 == 0 ? "Dermatology" : "Pediatrics");
            consultant.setQualification("MBBS, MSc");
            consultant.setExperienceYears(8 + i);
            consultant.setConsultationFee(35.0 + (i * 5));
            consultant.setAvailableSlots(List.of("Tuesday 2PM", "Thursday 9AM"));
            consultant.setConsultationTypes(List.of("In-person", "Online"));
            consultant.setOnlineConsultationAvailable(i % 2 == 0);
            consultant.setConsultationDuration(30 + (i * 10));
            consultant.setAssignedPatients(new ArrayList<>());
            doctorList.add(consultant);
        }

        for (int i = 0; i < 2; i++) {
            GeneralPractitioner gp = new GeneralPractitioner();
            gp.setId(HelperUtils.generateId("PER"));
            gp.setDoctorId(HelperUtils.generateId("GP"));
            gp.setFirstName("GP" + i);
            gp.setLastName("Al Busaidi");
            gp.setGender(i % 2 == 0 ? "Male" : "Female");
            gp.setDateOfBirth(LocalDate.of(1985 + i, (i % 12) + 1, (i % 27) + 1));
            gp.setPhoneNumber("9600000" + i);
            gp.setEmail("gp" + i + "@hospital.com");
            gp.setAddress("Nizwa, Oman - Street " + i);
            gp.setSpecialization("General Medicine");
            gp.setQualification("MBBS");
            gp.setExperienceYears(5 + i);
            gp.setConsultationFee(20.0 + (i * 5));
            gp.setAvailableSlots(List.of("Sunday 9AM", "Tuesday 1PM"));
            gp.setWalkinAvailable(true);
            gp.setHomeVisitAvailable(i % 2 == 0);
            gp.setVaccinationCertified(true);
            gp.setAssignedPatients(new ArrayList<>());
            doctorList.add(gp);
        }
        System.out.println("=== Sample Doctors Added Successfully ===");
    }
}