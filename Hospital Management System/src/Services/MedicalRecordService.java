package Services;

import Entities.MedicalRecord;
import Entities.Patient;
import Interfaces.Manageable;
import Interfaces.Searchable;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordService implements Manageable<MedicalRecord>, Searchable {
    public static List<MedicalRecord> recordList = new ArrayList<>();

    @Override
    public MedicalRecord add() {
        System.out.println("=== Add New Medical Record ===");
        MedicalRecord record = new MedicalRecord();

        String recordId = HelperUtils.generateId("MR");
        System.out.println("Generated Record ID: " + recordId);
        record.setRecordId(recordId);

        String patientId;
        while (true) {
            patientId = InputHandler.getStringInput("Enter Patient ID: ");
            if (PatientService.checkById(patientId)) {
                break;
            } else {
                System.out.println("No patient found with ID: " + patientId + " Please try again.");
            }
        }
        record.setPatientId(patientId);
        String doctorId;
        while (true) {
            doctorId = InputHandler.getStringInput("Enter Doctor ID: ");
            if (DoctorService.checkById(doctorId)) {
                break;
            } else {
                System.out.println("No doctor found with ID: " + doctorId + " Please try again.");
            }
        }
        record.setDoctorId(doctorId);

        LocalDate visitDate = InputHandler.getDateInput("Enter Visit Date: ");
        record.setVisitDate(visitDate);
        record.setDiagnosis(InputHandler.getStringInput("Enter Diagnosis: "));
        record.setPrescription(InputHandler.getStringInput("Enter Prescription: "));
        record.setTestResults(InputHandler.getStringInput("Enter Test Results: "));
        record.setNotes(InputHandler.getStringInput("Enter Notes: "));

        return record;
    }

    public void save(MedicalRecord record) {
        recordList.add(record);
        if (PatientService.checkById(record.getPatientId())) {
            for (Patient p : PatientService.patientList) {
                if (p.getPatientId().equalsIgnoreCase(record.getPatientId())) {
                    if (p.getMedicalRecords() == null) {
                        p.setMedicalRecords(new ArrayList<>());
                    }
                    p.getMedicalRecords().add(record);
                    break;
                }
            }
        }
        System.out.println("Medical record added successfully.");
    }

    public void editMedicalRecord() {
        if (recordList.isEmpty()) {
            System.out.println("No medical records in the list.");
            return;
        }

        String id = InputHandler.getStringInput("Enter Medical Record ID to edit: ");
        MedicalRecord recordToEdit = null;

        for (MedicalRecord record : recordList) {
            if (record.getRecordId().equalsIgnoreCase(id)) {
                recordToEdit = record;
                break;
            }
        }
        if (recordToEdit == null) {
            System.out.println("Medical record not found.");
            return;
        }

        boolean editing = true;
        while (editing) {
            System.out.println("\nEditing Medical Record ID: " + recordToEdit.getRecordId());
            System.out.println("""
                    1. Patient ID
                    2. Doctor ID
                    3. Visit Date
                    4. Diagnosis
                    5. Prescription
                    6. Test Results
                    7. Notes
                    8. Exit Editing
                    """);

            Integer choice = InputHandler.getIntInput("Enter your choice (1-8): ");
            switch (choice) {
                case 1 -> recordToEdit.setPatientId(InputHandler.getStringInput("Enter new Patient ID: "));
                case 2 -> recordToEdit.setDoctorId(InputHandler.getStringInput("Enter new Doctor ID: "));
                case 3 -> recordToEdit.setVisitDate(InputHandler.getDateInput("Enter new Visit Date"));
                case 4 -> recordToEdit.setDiagnosis(InputHandler.getStringInput("Enter new Diagnosis: "));
                case 5 -> recordToEdit.setPrescription(InputHandler.getStringInput("Enter new Prescription: "));
                case 6 -> recordToEdit.setTestResults(InputHandler.getStringInput("Enter new Test Results: "));
                case 7 -> recordToEdit.setNotes(InputHandler.getStringInput("Enter new Notes: "));
                case 8 -> {
                    editing = false;
                    System.out.println("Exiting edit mode.");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public String getRecordToRemove() {
        if (recordList.isEmpty()) {
            System.out.println("No medical records in the list.");
            return null;
        }
        String id = InputHandler.getStringInput("Enter Medical Record ID to remove: ");
        while (!checkById(id)) {
            id = InputHandler.getStringInput("Invalid ID. Please enter another Record ID: ");
        }
        return id;
    }

    @Override
    public void remove(String id) {
        if (id == null) {
            System.out.println("Invalid input. No record removed.");
            return;
        }
        if (checkById(id)) {
            recordList.removeIf(record -> record.getRecordId().equalsIgnoreCase(id));
            System.out.println("Record removed successfully.");
        } else {
            System.out.println("Record not found.");
        }
    }

    @Override
    public List<MedicalRecord> getAll() {
        if (recordList.isEmpty()) {
            System.out.println("No medical records found.");
        } else {
            System.out.println("\n=== All Medical Records ===");
            for (MedicalRecord record : recordList) {
                record.displayInfo();
            }
        }
        return recordList;
    }

    @Override
    public void search() {
        if (recordList.isEmpty()) {
            System.out.println("No medical records available.");
            return;
        }
        String patientId = InputHandler.getStringInput("Enter patient ID to search: ");
        for (MedicalRecord record : recordList) {
            if (record.getPatientId().equalsIgnoreCase(patientId)) {
                System.out.println("Medical record found:");
                record.displayInfo();
                return;
            }
        }
        System.out.println("No medical record found for this patient.");
    }

    @Override
    public void searchById() {
        if (recordList.isEmpty()) {
            System.out.println("No medical records available.");
            return;
        }

        String doctorId = InputHandler.getStringInput("Enter doctor ID to search: ");

        for (MedicalRecord record : recordList) {
            if (record.getDoctorId().equalsIgnoreCase(doctorId)) {
                System.out.println("Medical record found:");
                record.displayInfo();
                return;
            }
        }

        System.out.println("No medical record found for this doctor.");
    }

    public void displayPatientHistory() {
        if (recordList.isEmpty()) {
            System.out.println("No medical records available.");
            return;
        }

        String patientId = InputHandler.getStringInput("Enter Patient ID to display history:");
        for (MedicalRecord record : recordList) {
            if (record.getPatientId().equalsIgnoreCase(patientId)) {
                record.displayInfo();
                return;
            }
        }
        System.out.println("No history found for Patient ID: " + patientId);
    }

    public static boolean checkById(String id) {
        for (MedicalRecord record : recordList) {
            if (record.getRecordId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public static void addSampleMedicalRecords() {
        if (PatientService.patientList.isEmpty() || DoctorService.doctorList.isEmpty()) {
            System.out.println("Please make sure sample Patients and Doctors are added before generating Medical Records.");
            return;
        }

        for (int i = 0; i < 12; i++) {
            MedicalRecord record = new MedicalRecord();
            record.setRecordId(HelperUtils.generateId("MR"));
            record.setPatientId(PatientService.patientList.get(i % PatientService.patientList.size()).getPatientId());
            record.setDoctorId(DoctorService.doctorList.get(i % DoctorService.doctorList.size()).getDoctorId());

            record.setVisitDate(LocalDate.now().minusDays(i % 5));
            record.setDiagnosis("Diagnosis " + (i + 1));
            record.setPrescription("Prescription " + (i + 1));
            record.setTestResults("Blood Test: Normal, X-Ray: Clear " + (i + 1));
            record.setNotes("Follow-up visit scheduled.");

            recordList.add(record);

            Patient patient = PatientService.patientList.get(i % PatientService.patientList.size());
            if (patient.getMedicalRecords() == null) {
                patient.setMedicalRecords(new ArrayList<>());
            }
            patient.getMedicalRecords().add(record);
        }
        System.out.println("=== Sample Medical Records Added Successfully ===");
    }
}