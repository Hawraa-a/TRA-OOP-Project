package Services;

import Entities.Nurse;
import Entities.Patient;
import Interfaces.Manageable;
import Interfaces.Searchable;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.util.ArrayList;
import java.util.List;

public class NurseService implements Manageable<Nurse>, Searchable {
    public static List<Nurse> nursesList = new ArrayList<>();

    @Override
    public Nurse add() {
        System.out.println("=== Add New Nurse ===");
        Nurse nurse = new Nurse();

        String id = Utils.HelperUtils.generateId("PER");
        System.out.println("Generated person id: " + id);
        nurse.setId(id);
        nurse.setFirstName(InputHandler.getStringInput("Enter the First Name: "));
        nurse.setLastName(InputHandler.getStringInput("Enter the Last Name: "));
        nurse.setDateOfBirth(InputHandler.getDateInput("Enter the Date of Birth"));
        nurse.setGender(InputHandler.getStringInput("Enter the Gender (Male/Female): "));
        nurse.setPhoneNumber(InputHandler.getStringInput("Enter the Phone Number: "));
        nurse.setEmail(InputHandler.getStringInput("Enter the Email: "));
        nurse.setAddress(InputHandler.getStringInput("Enter the Address: "));

        String nurseId = HelperUtils.generateId("NUR");
        System.out.println("Generated Nurse ID: " + nurseId);
        nurse.setNurseId(nurseId);
        String shift = InputHandler.getStringInput("Enter Shift (Morning/Evening/Night): ");
        nurse.setShift(shift);
        String qualification = InputHandler.getStringInput("Enter Qualification: ");
        nurse.setQualification(qualification);
        nurse.setAssignedPatients(new ArrayList<>());

        return nurse;
    }

    public void save(Nurse nurse) {
        nursesList.add(nurse);
        System.out.println("The nurse was successfully added.");
    }

    public String getNurseToRemove() {
        if (nursesList.isEmpty()) {
            System.out.println("No Nurse In The List.");
            return null;
        }
        String id = InputHandler.getStringInput("Enter nurse ID to remove: ");
        while (!checkById(id)) {
            id = InputHandler.getStringInput("Invalid ID, Please Enter Another ID");
        }
        return id;
    }

    @Override
    public void remove(String id) {
        if (id == null) {
            System.out.println("Invalid input. No Nurse removed.");
            return;
        }
        if (checkById(id)) {
            nursesList.removeIf(nurse -> nurse.getNurseId().equals(id));
            System.out.println("Nurse removed successfully.");
        } else {
            System.out.println("Nurse not found.");
        }
    }


    @Override
    public List<Nurse> getAll() {
        if (nursesList.isEmpty()) {
            System.out.println("No nurses found.");
        } else {
            for (Nurse nurse : nursesList) {
                nurse.displayInfo();
            }
        }
        return nursesList;
    }

    @Override
    public void search() {
        if (nursesList.isEmpty()) {
            System.out.println("There Are No Nurse Available");
            return;
        }
        String nursesName = InputHandler.getStringInput("Enter Nurse First Name to search");
        boolean found = false;
        for (Nurse n : nursesList) {
            if (n.getFirstName().equalsIgnoreCase(nursesName)) {
                n.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No Nurse found with this name");
        }
    }

    @Override
    public void searchById() {
        if (nursesList.isEmpty()) {
            System.out.println("No nurses available.");
            return;
        }
        String id = InputHandler.getStringInput("Enter Nurse ID to search: ");
        boolean found = false;

        for (Nurse nurse : nursesList) {
            if (nurse.getNurseId().equalsIgnoreCase(id)) {
                nurse.displayInfo();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No nurse found with ID: " + id);
        }
    }

    public void editNurse() {
        String id = InputHandler.getStringInput("Enter nurse ID to edit: ");
        Nurse nurseToEdit = null;

        for (Nurse n : nursesList) {
            if (n.getNurseId().equalsIgnoreCase(id)) {
                nurseToEdit = n;
                break;
            }
        }
        if (nurseToEdit == null) {
            System.out.println("Nurse not found.");
            return;
        }
        boolean editing = true;
        while (editing) {
            System.out.println("\nEditing Nurse: " + nurseToEdit.getFirstName() + " " + nurseToEdit.getLastName());
            System.out.println("Select the field to edit:");
            System.out.println("1. First Name");
            System.out.println("2. Last Name");
            System.out.println("3. Date of Birth");
            System.out.println("4. Gender");
            System.out.println("5. Phone Number");
            System.out.println("6. Email");
            System.out.println("7. Address");
            System.out.println("8. Department ID");
            System.out.println("9. Shift");
            System.out.println("10. Qualification");
            System.out.println("11. Exit Editing");

            Integer choice = InputHandler.getIntInput("Enter your choice (1-11): ");
            switch (choice) {
                case 1 -> {
                    nurseToEdit.setFirstName(InputHandler.getStringInput("Enter new First Name: "));
                }
                case 2 -> {
                    nurseToEdit.setLastName(InputHandler.getStringInput("Enter new Last Name: "));
                }
                case 3 -> {
                    nurseToEdit.setDateOfBirth(InputHandler.getDateInput("Enter new Date of Birth: "));
                }
                case 4 -> {
                    nurseToEdit.setGender(InputHandler.getStringInput("Enter new Gender: "));
                }
                case 5 -> {
                    nurseToEdit.setPhoneNumber(InputHandler.getStringInput("Enter new Phone Number: "));
                }
                case 6 -> {
                    nurseToEdit.setEmail(InputHandler.getStringInput("Enter new Email: "));
                }
                case 7 -> {
                    nurseToEdit.setAddress(InputHandler.getStringInput("Enter new Address: "));
                }
                case 8 -> {
                    String newDeptId;
                    while (true) {
                        newDeptId = InputHandler.getStringInput("Enter new Department ID (required): ");
                        if (DepartmentService.checkById(newDeptId)) {
                            nurseToEdit.setDepartmentId(newDeptId);
                            break;
                        } else {
                            System.out.println("Department not found. Please enter a valid Department ID.");
                        }
                    }
                }
                case 9 -> {
                    nurseToEdit.setShift(InputHandler.getStringInput("Enter new Shift: "));
                }
                case 10 -> nurseToEdit.setQualification(InputHandler.getStringInput("Enter new Qualification: "));
                case 11 -> {
                    editing = false;
                    System.out.println("Exiting edit mode.");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void getNursesByDepartment() {
        if (nursesList.isEmpty()) {
            System.out.println("No nurses available.");
            return;
        }
        String departmentId = InputHandler.getStringInput("Enter Department ID: ");
        List<Nurse> nursesByDepartment = new ArrayList<>();
        for (Nurse nurse : nursesList) {
            if (nurse.getDepartmentId() != null && nurse.getDepartmentId().equalsIgnoreCase(departmentId)) {
                nursesByDepartment.add(nurse);
            }
        }
        if (nursesByDepartment.isEmpty()) {
            System.out.println("No nurses found for department: " + departmentId);
        } else {
            System.out.println("Nurses in Department " + departmentId + ":");
            for (Nurse nurse : nursesByDepartment) {
                nurse.displayInfo();
            }
        }
    }

    public void getNursesByShift() {
        if (nursesList.isEmpty()) {
            System.out.println("No nurses available.");
            return;
        }
        String shift = InputHandler.getStringInput("Enter Shift (Morning/Evening/Night): ");
        List<Nurse> nursesByShift = new ArrayList<>();
        for (Nurse nurse : nursesList) {
            if (nurse.getShift() != null && nurse.getShift().equalsIgnoreCase(shift)) {
                nursesByShift.add(nurse);
            }
        }
        if (nursesByShift.isEmpty()) {
            System.out.println("No nurses found for shift: " + shift);
        } else {
            System.out.println("Nurses in " + shift + " shift: ");
            for (Nurse nurse : nursesByShift) {
                nurse.displayInfo();
            }
        }
    }

    public void assignPatientToNurse() {
        String nurseId = InputHandler.getStringInput("Enter Nurse ID: ");
        if (!checkById(nurseId)) {
            System.out.println("Nurse not found.");
            return;
        }
        Nurse nurseToAssign = null;
        for (Nurse nurse : nursesList) {
            if (nurse.getNurseId().equalsIgnoreCase(nurseId)) {
                nurseToAssign = nurse;
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
        if (patientToAssign != null && nurseToAssign != null) {
            nurseToAssign.assignPatient(patientToAssign);
        }
    }

    public static Boolean checkById(String id) {
        for (Nurse nurse : nursesList) {
            if (nurse.getNurseId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }
}