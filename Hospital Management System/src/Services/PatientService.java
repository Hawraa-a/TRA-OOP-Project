package Services;

import Entities.*;
import Interfaces.Manageable;
import Interfaces.Searchable;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientService implements Manageable<Patient>, Searchable {
    public static List<Patient> patientList = new ArrayList<>();

    @Override
    public Patient add() {
        System.out.println("=== Registering New Patient ===");
        Patient patient = new Patient();

        String id = HelperUtils.generateId("PER");
        System.out.println("Generated person id: " + id);
        patient.setId(id);
        patient.setFirstName(InputHandler.getStringInput("Enter the First Name: "));
        patient.setLastName(InputHandler.getStringInput("Enter the Last Name: "));
        patient.setDateOfBirth(InputHandler.getDateInput("Enter the Date of Birth"));
        patient.setGender(InputHandler.getStringInput("Enter the Gender (Male/Female): "));
        patient.setPhoneNumber(InputHandler.getStringInput("Enter the Phone Number: "));
        patient.setEmail(InputHandler.getStringInput("Enter the Email: "));
        patient.setAddress(InputHandler.getStringInput("Enter the Address: "));

        String patientId = HelperUtils.generateId("PAT");
        System.out.println("Generated Patient ID: " + patientId);
        patient.setPatientId(patientId);
        patient.setBloodGroup(InputHandler.getStringInput("Enter the Blood Group: "));
        List<String> allergies = new ArrayList<>();
        System.out.println("Enter The Allergies(type 'q' to finish):");
        while (true) {
            String allergy = InputHandler.getStringInput("- ");
            if (allergy.equalsIgnoreCase("q")) {
                break;
            }
            allergies.add(allergy);
        }
        patient.setAllergies(allergies);
        patient.setEmergencyContact(InputHandler.getStringInput("Enter the Emergency Contact: "));
        patient.setRegistrationDate(InputHandler.getDateInput("Enter the Registration Date"));
        patient.setInsuranceId(InputHandler.getStringInput("Enter the Insurance ID: "));

        return patient;
    }

    public void save(Patient patient) {
        patientList.add(patient);
        System.out.println("The patient was successfully added.");
    }

    public InPatient addInPatient() {
        System.out.println("=== Add New In Patient ===");
        InPatient inPatient = new InPatient();

        String id = HelperUtils.generateId("PER");
        System.out.println("Generated person id: " + id);
        inPatient.setId(id);
        inPatient.setFirstName(InputHandler.getStringInput("Enter the First Name: "));
        inPatient.setLastName(InputHandler.getStringInput("Enter the Last Name: "));
        inPatient.setDateOfBirth(InputHandler.getDateInput("Enter the Date of Birth"));
        inPatient.setGender(InputHandler.getStringInput("Enter the Gender (Male/Female): "));
        inPatient.setPhoneNumber(InputHandler.getStringInput("Enter the Phone Number: "));
        inPatient.setEmail(InputHandler.getStringInput("Enter the Email: "));
        inPatient.setAddress(InputHandler.getStringInput("Enter the Address: "));

        String patientId = HelperUtils.generateId("INP");
        System.out.println("Generated Patient ID: " + patientId);
        inPatient.setPatientId(patientId);
        inPatient.setBloodGroup(InputHandler.getStringInput("Enter the Blood Group: "));
        List<String> allergies = new ArrayList<>();
        System.out.println("Enter The Allergies(type 'q' to finish):");
        while (true) {
            String allergy = InputHandler.getStringInput("- ");
            if (allergy.equalsIgnoreCase("q")) {
                break;
            }
            allergies.add(allergy);
        }
        inPatient.setAllergies(allergies);
        inPatient.setEmergencyContact(InputHandler.getStringInput("Enter the Emergency Contact: "));
        inPatient.setRegistrationDate(InputHandler.getDateInput("Enter the Registration Date"));
        inPatient.setInsuranceId(InputHandler.getStringInput("Enter the Insurance ID: "));

        inPatient.setAdmissionDate(InputHandler.getDateInput("Enter the Admission Date: "));
        inPatient.setDischargeDate(InputHandler.getDateInput("Enter the Discharge Date: "));
        inPatient.setRoomNumber(InputHandler.getStringInput("Enter the Room Number: "));
        inPatient.setBedNumber(InputHandler.getStringInput("Enter the Bed Number: "));
        String AdmittingDoctorId;
        while (true) {
            AdmittingDoctorId = (InputHandler.getStringInput("Enter the Admitting Doctor Id: "));
            if (DoctorService.checkById(AdmittingDoctorId)) {
                inPatient.setAdmittingDoctorId(AdmittingDoctorId);
                break;
            } else {
                System.out.println("Doctor not found. Please enter a valid Doctor ID.");
            }
        }
        inPatient.setDailyCharges(InputHandler.getDoubleInput("Enter the Daily Charges: "));

        return inPatient;
    }

    public OutPatient addOutPatient() {
        System.out.println("=== Add New Out Patient ===");
        OutPatient outPatient = new OutPatient();

        String id = HelperUtils.generateId("PER");
        System.out.println("Generated person id: " + id);
        outPatient.setId(id);
        outPatient.setFirstName(InputHandler.getStringInput("Enter the First Name: "));
        outPatient.setLastName(InputHandler.getStringInput("Enter the Last Name: "));
        outPatient.setDateOfBirth(InputHandler.getDateInput("Enter the Date of Birth"));
        outPatient.setGender(InputHandler.getStringInput("Enter the Gender (Male/Female): "));
        outPatient.setPhoneNumber(InputHandler.getStringInput("Enter the Phone Number: "));
        outPatient.setEmail(InputHandler.getStringInput("Enter the Email: "));
        outPatient.setAddress(InputHandler.getStringInput("Enter the Address: "));

        String patientId = HelperUtils.generateId("OutP");
        System.out.println("Generated Patient ID: " + patientId);
        outPatient.setPatientId(patientId);
        outPatient.setBloodGroup(InputHandler.getStringInput("Enter the Blood Group: "));
        List<String> allergies = new ArrayList<>();
        System.out.println("Enter The Allergies(type 'q' to finish):");
        while (true) {
            String allergy = InputHandler.getStringInput("- ");
            if (allergy.equalsIgnoreCase("q")) {
                break;
            }
            allergies.add(allergy);
        }
        outPatient.setAllergies(allergies);
        outPatient.setEmergencyContact(InputHandler.getStringInput("Enter the Emergency Contact: "));
        outPatient.setRegistrationDate(InputHandler.getDateInput("Enter the Registration Date"));
        outPatient.setInsuranceId(InputHandler.getStringInput("Enter the Insurance ID: "));

        outPatient.setVisitCount(InputHandler.getIntInput("Enter the Visit Count: "));
        outPatient.setLastVisitDate(InputHandler.getDateInput("Enter the Last Visit Date: "));
        String PreferredDoctorId;
        while (true) {
            PreferredDoctorId = (InputHandler.getStringInput("Enter the Preferred Doctor Id: "));
            if (DoctorService.checkById(PreferredDoctorId)) {
                outPatient.setPreferredDoctorId(PreferredDoctorId);
                break;
            } else {
                System.out.println("Doctor not found. Please enter a valid Doctor ID.");
            }
        }
        return outPatient;
    }

    public EmergencyPatient addEmergencyPatient() {
        System.out.println("=== Add New Emergency Patient ===");
        EmergencyPatient emergencyPatient = new EmergencyPatient();
        String id = HelperUtils.generateId("PER");
        System.out.println("Generated person id: " + id);
        emergencyPatient.setId(id);
        emergencyPatient.setFirstName(InputHandler.getStringInput("Enter the First Name: "));
        emergencyPatient.setLastName(InputHandler.getStringInput("Enter the Last Name: "));
        emergencyPatient.setDateOfBirth(InputHandler.getDateInput("Enter the Date of Birth"));
        emergencyPatient.setGender(InputHandler.getStringInput("Enter the Gender (Male/Female): "));
        emergencyPatient.setPhoneNumber(InputHandler.getStringInput("Enter the Phone Number: "));
        emergencyPatient.setEmail(InputHandler.getStringInput("Enter the Email: "));
        emergencyPatient.setAddress(InputHandler.getStringInput("Enter the Address: "));

        String patientId = HelperUtils.generateId("EMP");
        System.out.println("Generated Patient ID: " + patientId);
        emergencyPatient.setPatientId(patientId);
        emergencyPatient.setBloodGroup(InputHandler.getStringInput("Enter the Blood Group: "));
        List<String> allergies = new ArrayList<>();
        System.out.println("Enter The Allergies(type 'q' to finish):");
        while (true) {
            String allergy = InputHandler.getStringInput("- ");
            if (allergy.equalsIgnoreCase("q")) {
                break;
            }
            allergies.add(allergy);
        }
        emergencyPatient.setAllergies(allergies);
        emergencyPatient.setEmergencyContact(InputHandler.getStringInput("Enter the Emergency Contact: "));
        emergencyPatient.setRegistrationDate(InputHandler.getDateInput("Enter the Registration Date"));
        emergencyPatient.setInsuranceId(InputHandler.getStringInput("Enter the Insurance ID: "));

        emergencyPatient.setAdmissionDate(InputHandler.getDateInput("Enter the Admission Date: "));
        emergencyPatient.setDischargeDate(InputHandler.getDateInput("Enter the Discharge Date: "));
        emergencyPatient.setRoomNumber(InputHandler.getStringInput("Enter the Room Number: "));
        emergencyPatient.setBedNumber(InputHandler.getStringInput("Enter the Bed Number: "));
        String AdmittingDoctorId;
        while (true) {
            AdmittingDoctorId = (InputHandler.getStringInput("Enter the Admitting Doctor Id: "));
            if (DoctorService.checkById(AdmittingDoctorId)) {
                emergencyPatient.setAdmittingDoctorId(AdmittingDoctorId);
                break;
            } else {
                System.out.println("Doctor not found. Please enter a valid Doctor ID.");
            }
        }
        emergencyPatient.setDailyCharges(InputHandler.getDoubleInput("Enter the Daily Charges: "));

        emergencyPatient.setEmergencyType(InputHandler.getStringInput("Enter the Emergency Type: "));
        emergencyPatient.setArrivalMode(InputHandler.getStringInput("Enter the Arrival Mode: "));
        emergencyPatient.setTriageLevel(InputHandler.getIntInput("Enter the Triage Level(1 - 5): "));
        emergencyPatient.setAdmittedViaER(InputHandler.getConfirmation("Is Admitted Via ER: "));

        return emergencyPatient;
    }

    public String getPatientToRemove() {
        if (patientList.isEmpty()) {
            System.out.println("No Patient In The List.");
            return null;
        }
        String id = InputHandler.getStringInput("Enter patient ID to remove: ");
        while (!checkById(id)) {
            id = InputHandler.getStringInput("Invalid ID, Please Enter Another ID: ");
        }
        return id;
    }

    @Override
    public void remove(String id) {
        if (id == null) {
            System.out.println("Invalid input. No Patient removed.");
            return;
        }
        if (checkById(id)) {
            patientList.removeIf(patient -> patient.getPatientId().equalsIgnoreCase(id));
            System.out.println("Patient removed successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }

    @Override
    public List<Patient> getAll() {
        if (patientList.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            for (Patient patient : patientList) {
                patient.displayInfo();
            }
        }
        return patientList;
    }

    @Override
    public void search() {
        if (patientList.isEmpty()) {
            System.out.println("There are no Patient Available");
            return;
        }
        String firstName = InputHandler.getStringInput("Enter Patient's First Name to search: ");
        String lastName = InputHandler.getStringInput("Enter Patient's Last Name to search: ");
        for (Patient p : patientList) {
            if (p.getFirstName().equalsIgnoreCase(firstName) && p.getLastName().equalsIgnoreCase(lastName)) {
                p.displayInfo();
                return;
            }
        }
        System.out.println("No Patient found with this name");
    }

    @Override
    public void searchById() {
        if (patientList.isEmpty()) {
            System.out.println("No patients available.");
            return;
        }
        String id = InputHandler.getStringInput("Enter Patient ID to search: ");
        for (Patient patient : patientList) {
            if (patient.getPatientId().equalsIgnoreCase(id)) {
                patient.displayInfo();
                return;
            }
        }
        System.out.println("No patient found with ID: " + id);
    }

    public void editPatient() {
        if (patientList.isEmpty()) {
            System.out.println("No Patient In The List.");
            return;
        }

        String id = InputHandler.getStringInput("Enter patient ID to edit: ");
        Patient patientToEdit = null;
        for (Patient p : patientList) {
            if (p.getPatientId().equalsIgnoreCase(id)) {
                patientToEdit = p;
                break;
            }
        }
        if (patientToEdit == null) {
            System.out.println("Patient not found.");
            return;
        }
        boolean editing = true;
        while (editing) {
            System.out.println("\nEditing Patient: " + patientToEdit.getFirstName() + " " + patientToEdit.getLastName());
            System.out.println("Select the field to edit:");
            System.out.println("1. First Name");
            System.out.println("2. Last Name");
            System.out.println("3. Date of Birth");
            System.out.println("4. Gender");
            System.out.println("5. Phone Number");
            System.out.println("6. Email");
            System.out.println("7. Address");
            System.out.println("8. Blood Group");
            System.out.println("9. Allergies");
            System.out.println("10. Emergency Contact");
            System.out.println("11. Insurance ID");
            System.out.println("12. Registration Date");
            System.out.println("13. Exit Editing");

            Integer choice = InputHandler.getIntInput("Enter your choice (1-13): ");
            switch (choice) {
                case 1 -> {
                    patientToEdit.setFirstName(InputHandler.getStringInput("Enter new First Name: "));
                }
                case 2 -> {
                    patientToEdit.setLastName(InputHandler.getStringInput("Enter new Last Name: "));
                }
                case 3 -> {
                    patientToEdit.setDateOfBirth(InputHandler.getDateInput("Enter new Date of Birth"));
                }
                case 4 -> {
                    patientToEdit.setGender(InputHandler.getStringInput("Enter new Gender: "));
                }
                case 5 -> {
                    patientToEdit.setPhoneNumber(InputHandler.getStringInput("Enter new Phone Number: "));
                }
                case 6 -> {
                    patientToEdit.setEmail(InputHandler.getStringInput("Enter new Email: "));
                }
                case 7 -> {
                    patientToEdit.setAddress(InputHandler.getStringInput("Enter new Address: "));
                }
                case 8 -> {
                    patientToEdit.setBloodGroup(InputHandler.getStringInput("Enter new Blood Group: "));
                }
                case 9 -> {
                    List<String> allergies = new ArrayList<>();
                    System.out.println("Enter new allergies (type 'q' to finish):");
                    while (true) {
                        String allergy = InputHandler.getStringInput("- ");
                        if (allergy.equalsIgnoreCase("q")) break;
                        allergies.add(allergy);
                    }
                    patientToEdit.setAllergies(allergies);
                }
                case 10 -> {
                    patientToEdit.setEmergencyContact(InputHandler.getStringInput("Enter new Emergency Contact: "));
                }
                case 11 -> {
                    patientToEdit.setInsuranceId(InputHandler.getStringInput("Enter new Insurance ID: "));
                }
                case 12 -> {
                    patientToEdit.setRegistrationDate(InputHandler.getDateInput("Enter new Registration Date: "));
                }
                case 13 -> {
                    editing = false;
                    System.out.println("Exiting edit mode.");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public List<Patient> getAllPatientsList() {
        return patientList;
    }

    public Patient addPatient(String firstName, String lastName, String phone) {
        Patient patient = new Patient();
        patient.setId(HelperUtils.generateId("PER"));
        patient.setPatientId(HelperUtils.generateId("PAT"));
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setPhoneNumber(phone);
        patient.setRegistrationDate(LocalDate.now());

        return patient;
    }

    public Patient addPatient(String firstName, String lastName, String phone, String bloodGroup, String email) {
        Patient patient = new Patient();
        patient.setId(HelperUtils.generateId("PER"));
        patient.setPatientId(HelperUtils.generateId("PAT"));
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setPhoneNumber(phone);
        patient.setBloodGroup(bloodGroup);
        patient.setEmail(email);
        patient.setRegistrationDate(LocalDate.now());

        return patient;
    }

    public Patient addPatient(Patient patient) {
        return patient;
    }

    public void searchPatients(String keyword) {
        if (patientList.isEmpty()) {
            System.out.println("There are no Patient Available");
            return;
        }
        boolean found = false;
        for (Patient p : patientList) {
            if ((p.getFirstName() != null && p.getFirstName().toLowerCase().contains(keyword.toLowerCase())) ||
                    (p.getLastName() != null && p.getLastName().toLowerCase().contains(keyword.toLowerCase())) ||
                    (p.getPhoneNumber() != null && p.getPhoneNumber().toLowerCase().contains(keyword.toLowerCase())) ||
                    (p.getEmail() != null && p.getEmail().toLowerCase().contains(keyword.toLowerCase())) ||
                    (p.getBloodGroup() != null && p.getBloodGroup().toLowerCase().contains(keyword.toLowerCase())) ||
                    (p.getAddress() != null && p.getAddress().toLowerCase().contains(keyword.toLowerCase()))) {

                p.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No patients found matching keyword: " + keyword);
        }
    }

    public void searchPatients(String firstName, String lastName) {
        if (patientList.isEmpty()) {
            System.out.println("There are no patients available.");
            return;
        }
        boolean found = false;
        for (Patient p : patientList) {
            if (p.getFirstName().equalsIgnoreCase(firstName) && p.getLastName().equalsIgnoreCase(lastName)) {
                p.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No patients found with name: " + firstName + " " + lastName);
        }
    }

    public void displayPatients() {
        if (patientList.isEmpty()) {
            System.out.println("No patients available.");
            return;
        }
        System.out.println("=== Displaying All Patients ===");
        for (Patient p : patientList) {
            p.displayInfo();
        }
    }

    public void displayPatients(String filter) {
        if (patientList.isEmpty()) {
            System.out.println("No patients available.");
            return;
        }
        System.out.println("=== Displaying Patients Filtered by: " + filter + " ===");
        boolean found = false;
        for (Patient p : patientList) {
            if ((p.getBloodGroup() != null && p.getBloodGroup().equalsIgnoreCase(filter)) ||
                    (p.getGender() != null && p.getGender().equalsIgnoreCase(filter)) ||
                    (p.getAddress() != null && p.getAddress().toLowerCase().contains(filter.toLowerCase()))) {

                p.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No patients found matching filter: " + filter);
        }
    }

    public void displayPatients(int limit) {
        if (patientList.isEmpty()) {
            System.out.println("No patients available.");
            return;
        }
        System.out.println("=== Displaying First " + limit + " Patients ===");
        for (int i = 0; i < limit && i < patientList.size(); i++) {
            patientList.get(i).displayInfo();
        }
    }

    public static Boolean checkById(String id) {
        for (Patient patient : patientList) {
            if (patient.getPatientId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public static void addSamplePatients() {
        for (int i = 0; i < 3; i++) {
            Patient patient = new Patient();
            patient.setId(HelperUtils.generateId("PER"));
            patient.setPatientId(HelperUtils.generateId("PAT"));
            patient.setFirstName("Regular" + i);
            patient.setLastName("Al Mahrouqi" + i);
            patient.setGender(i % 2 == 0 ? "Male" : "Female");
            patient.setDateOfBirth(LocalDate.of(1990 + i, (i % 12) + 1, (i % 27) + 1));
            patient.setPhoneNumber("9000000" + i);
            patient.setEmail("regular" + i + "@example.com");
            patient.setAddress("Muscat, Oman - Block " + i);
            patient.setBloodGroup(i % 2 == 0 ? "O+" : "A+");
            patient.setAllergies(List.of(i % 2 == 0 ? "None" : "Dust"));
            patient.setEmergencyContact("9333000" + i);
            patient.setRegistrationDate(LocalDate.now().minusDays(i));
            patient.setInsuranceId("INS-R" + i);
            patientList.add(patient);
        }

        for (int i = 0; i < 3; i++) {
            InPatient patient = new InPatient();
            patient.setId(HelperUtils.generateId("PER"));
            patient.setPatientId(HelperUtils.generateId("INP"));
            patient.setFirstName("InPatient" + i);
            patient.setLastName("Al Riyami");
            patient.setGender(i % 2 == 0 ? "Male" : "Female");
            patient.setDateOfBirth(LocalDate.of(1985 + i, (i % 12) + 1, (i % 27) + 1));
            patient.setPhoneNumber("9111111" + i);
            patient.setEmail("inpatient" + i + "@example.com");
            patient.setAddress("Sohar, Oman - Building " + i);
            patient.setBloodGroup(i % 2 == 0 ? "B+" : "AB+");
            patient.setAllergies(List.of("None"));
            patient.setEmergencyContact("9444000" + i);
            patient.setRegistrationDate(LocalDate.now().minusDays(i + 1));
            patient.setInsuranceId("INS-I" + i);
            patient.setRoomNumber("R" + (100 + i));
            patient.setBedNumber("B" + i);
            patient.setAdmissionDate(LocalDate.now().minusDays(i));
            patient.setDischargeDate(LocalDate.now().plusDays(2));
            patient.setDailyCharges(10 + i * 50);
            patientList.add(patient);
        }

        for (int i = 0; i < 3; i++) {
            OutPatient patient = new OutPatient();
            patient.setId(HelperUtils.generateId("PER"));
            patient.setPatientId(HelperUtils.generateId("OUTP"));
            patient.setFirstName("OutPatient" + i);
            patient.setLastName("Al Farsi");
            patient.setGender(i % 2 == 0 ? "Female" : "Male");
            patient.setDateOfBirth(LocalDate.of(1995 + i, (i % 12) + 1, (i % 27) + 1));
            patient.setPhoneNumber("9222222" + i);
            patient.setEmail("outpatient" + i + "@example.com");
            patient.setAddress("Ibra, Oman - Street " + i);
            patient.setBloodGroup(i % 2 == 0 ? "A+" : "O+");
            patient.setAllergies(List.of("Pollen"));
            patient.setEmergencyContact("9555000" + i);
            patient.setRegistrationDate(LocalDate.now().minusDays(i + 2));
            patient.setInsuranceId("INS-O" + i);
            patient.setLastVisitDate(LocalDate.now().minusDays(i));
            patient.setVisitCount(i + 1);
            patientList.add(patient);
        }

        for (int i = 0; i < 4; i++) {
            EmergencyPatient patient = new EmergencyPatient();
            patient.setId(HelperUtils.generateId("PER"));
            patient.setPatientId(HelperUtils.generateId("EMP"));
            patient.setFirstName("EmergencyPatient" + i);
            patient.setLastName("Al Balushi");
            patient.setGender(i % 2 == 0 ? "Male" : "Female");
            patient.setDateOfBirth(LocalDate.of(1992 + i, (i % 12) + 1, (i % 27) + 1));
            patient.setPhoneNumber("9333333" + i);
            patient.setEmail("emergency" + i + "@example.com");
            patient.setAddress("Salalah, Oman - Block " + i);
            patient.setBloodGroup(i % 2 == 0 ? "B-" : "A-");
            patient.setAllergies(List.of("None"));
            patient.setEmergencyContact("9666000" + i);
            patient.setRegistrationDate(LocalDate.now().minusDays(i + 3));
            patient.setInsuranceId("INS-E" + i);
            patient.setAdmissionDate(LocalDate.now());
            patient.setDischargeDate(LocalDate.now().plusDays(1));
            patient.setRoomNumber("ER-" + (200 + i));
            patient.setBedNumber("E" + i);
            patient.setAdmittedViaER(true);
            patient.setEmergencyType(i % 2 == 0 ? "Accident" : "Heart Attack");
            patient.setArrivalMode(i % 2 == 0 ? "Ambulance" : "Walk-in");
            patient.setTriageLevel((i % 5) + 1);
            patient.setDailyCharges(100 + i * 50);
            patientList.add(patient);
        }
        System.out.println("=== Sample Patients Added Successfully ===");
    }
}