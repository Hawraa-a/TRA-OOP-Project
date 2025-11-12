package Services;

import Entities.Department;
import Entities.Doctor;
import Entities.Nurse;
import Interfaces.Manageable;
import Interfaces.Searchable;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.util.ArrayList;
import java.util.List;


public class DepartmentService implements Manageable<Department>, Searchable {
    public static List<Department> departmentList = new ArrayList<>();

    @Override
    public Department add() {
        System.out.println("=== Add New Department ===");
        Department department = new Department();
        String departmentId = HelperUtils.generateId("DEP");
        System.out.println("Generated Department ID: " + departmentId);
        department.setDepartmentId(departmentId);
        department.setDepartmentName(InputHandler.getStringInput("Enter Department Name: "));
        department.setBedCapacity(InputHandler.getIntInput("Enter Bed Capacity: "));
        department.setAvailableBeds(department.getBedCapacity());
        String headDoctorId;
        while (true) {
            headDoctorId = InputHandler.getStringInput("Enter Head Doctor ID (required): ");
            if (DoctorService.checkById(headDoctorId)) {
                department.setHeadDoctorId(headDoctorId);
                break;
            } else {
                System.out.println("Doctor not found. Please enter a valid Doctor ID.");
            }
        }
        return department;
    }

    public void save(Department department) {
        departmentList.add(department);
        System.out.println("Department added successfully.");
    }

    public String getDepartmentToRemove() {
        if (departmentList.isEmpty()) {
            System.out.println("No departments in the list.");
            return null;
        }
        String id = InputHandler.getStringInput("Enter Department ID to remove: ");
        while (!checkById(id)) {
            id = InputHandler.getStringInput("Invalid ID. Please enter another Department ID: ");
        }
        return id;
    }

    @Override
    public void remove(String id) {
        if (id == null) {
            System.out.println("Invalid input. No department removed.");
            return;
        }
        if (checkById(id)) {
            departmentList.removeIf(dep -> dep.getDepartmentId().equalsIgnoreCase(id));
            System.out.println("Department removed successfully.");
        } else {
            System.out.println("Department not found.");
        }
    }

    @Override
    public List<Department> getAll() {
        if (departmentList.isEmpty()) {
            System.out.println("No departments found.");
        } else {
            for (Department dep : departmentList) {
                dep.displayInfo();
                System.out.println("------------------------------------");
            }
        }
        return departmentList;
    }

    @Override
    public void search() {
        if (departmentList.isEmpty()) {
            System.out.println("No departments available.");
            return;
        }
        String name = InputHandler.getStringInput("Enter Department Name to search: ");
        for (Department dep : departmentList) {
            if (dep.getDepartmentName().equalsIgnoreCase(name)) {
                dep.displayInfo();
                System.out.println("------------------------------------");
                return;
            }
        }
        System.out.println("No department found with this name");
    }

    @Override
    public void searchById() {
        if (departmentList.isEmpty()) {
            System.out.println("No departments available.");
            return;
        }
        String id = InputHandler.getStringInput("Enter Department ID to search: ");
        for (Department dep : departmentList) {
            if (dep.getDepartmentId().equalsIgnoreCase(id)) {
                dep.displayInfo();
                return;
            }
        }
        System.out.println("No department found with this ID");
    }

    public void editDepartment() {
        if (departmentList.isEmpty()) {
            System.out.println("No departments available.");
            return;
        }

        String id = InputHandler.getStringInput("Enter Department ID to edit: ");
        while (!checkById(id)) {
            id = InputHandler.getStringInput("Invalid ID. Enter a valid Department ID: ");
        }
        Department depToEdit = null;
        for (Department dep : departmentList) {
            if (dep.getDepartmentId().equalsIgnoreCase(id)) {
                depToEdit = dep;
                break;
            }
        }
        if (depToEdit != null) {
            boolean editing = true;
            while (editing) {
                System.out.println("\nEditing Department: " + depToEdit.getDepartmentName());
                System.out.println("1. Department Name");
                System.out.println("2. Head Doctor ID");
                System.out.println("3. Bed Capacity");
                System.out.println("4. Available Beds");
                System.out.println("5. Exit Editing");

                int choice = InputHandler.getIntInput("Enter your choice (1-4): ");
                switch (choice) {
                    case 1 -> depToEdit.setDepartmentName(InputHandler.getStringInput("Enter new Department Name: "));
                    case 2 -> {
                        String headId = InputHandler.getStringInput("Enter new Head Doctor ID: ");
                        if (!headId.isEmpty()) {
                            while (!DoctorService.checkById(headId)) {
                                headId = InputHandler.getStringInput("Doctor not found. Enter a valid Doctor ID: ");
                            }
                            depToEdit.setHeadDoctorId(headId);
                        }
                    }
                    case 3 -> {
                        int newCapacity = InputHandler.getIntInput("Enter new Bed Capacity: ");
                        depToEdit.setBedCapacity(newCapacity);
                    }
                    case 4 -> {
                        while (true) {
                            int newAvailable = InputHandler.getIntInput("Enter new Available Beds (0 - " + depToEdit.getBedCapacity() + "): ");
                            try {
                                depToEdit.setAvailableBeds(newAvailable);
                                System.out.println("Available beds updated successfully to " + newAvailable + ".");
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    case 5 -> editing = false;
                    default -> System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }

    public void assignDoctorToDepartment() {
        String doctorId = InputHandler.getStringInput("Enter Doctor ID to assign: ");
        while (!DoctorService.checkById(doctorId)) {
            doctorId = InputHandler.getStringInput("Doctor not found. Enter a valid Doctor ID: ");
        }
        String departmentId = InputHandler.getStringInput("Enter Department ID to assign doctor: ");
        Department dep = null;
        while (dep == null) {
            for (Department d : departmentList) {
                if (d.getDepartmentId().equalsIgnoreCase(departmentId)) {
                    dep = d;
                    break;
                }
            }
            if (dep == null) {
                departmentId = InputHandler.getStringInput("Department not found. Enter a valid Department ID: ");
            }
        }
        for (Doctor doctor : DoctorService.doctorList) {
            if (doctor.getDoctorId().equalsIgnoreCase(doctorId)) {
                dep.getDoctors().add(doctor);
                doctor.setDepartmentId(departmentId);
                System.out.println("Doctor assigned to department successfully.");
                return;
            }
        }
    }

    public void assignNurseToDepartment() {
        String nurseId = InputHandler.getStringInput("Enter Nurse ID to assign: ");
        while (!NurseService.checkById(nurseId)) {
            nurseId = InputHandler.getStringInput("Nurse not found. Enter a valid Nurse ID: ");
        }
        String departmentId = InputHandler.getStringInput("Enter Department ID to assign nurse: ");
        Department dep = null;
        while (dep == null) {
            for (Department d : DepartmentService.departmentList) {
                if (d.getDepartmentId().equalsIgnoreCase(departmentId)) {
                    dep = d;
                    break;
                }
            }
            if (dep == null) {
                departmentId = InputHandler.getStringInput("Department not found. Enter a valid Department ID: ");
            }
        }
        for (Nurse nurse : NurseService.nursesList) {
            if (nurse.getNurseId().equalsIgnoreCase(nurseId)) {
                dep.getNurses().add(nurse);
                nurse.setDepartmentId(departmentId);
                System.out.println("Nurse assigned to department successfully.");
                return;
            }
        }
    }

    public void displayDepartmentStatistics() {
        if (departmentList.isEmpty()) {
            System.out.println("No departments available.");
            return;
        }
        System.out.println("Department Statistics:");
        for (Department dep : departmentList) {
            dep.displaySummary();
        }
    }

    public List<Department> getAlldepartmentList() {
        return departmentList;
    }

    public static boolean checkById(String id) {
        for (Department dep : departmentList) {
            if (dep.getDepartmentId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public static void addSampleDepartments() {
        String[] departmentNames = {"Cardiology", "Neurology", "Pediatrics"};
        int[] bedCapacities = {30, 25, 20};

        for (int i = 0; i < departmentNames.length; i++) {
            Department department = new Department();

            department.setDepartmentId(HelperUtils.generateId("DEP"));
            department.setDepartmentName(departmentNames[i]);
            department.setBedCapacity(bedCapacities[i]);
            department.setAvailableBeds(bedCapacities[i]);

            if (!DoctorService.doctorList.isEmpty()) {
                department.setHeadDoctorId(DoctorService.doctorList.get(i % DoctorService.doctorList.size()).getDoctorId());
            } else {
                department.setHeadDoctorId("HEAD" + (i + 1));
            }
            departmentList.add(department);
        }
        System.out.println("=== Sample Departments Added Successfully ===");
    }
}