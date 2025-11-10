package Main;

import Entities.*;
import Services.*;

import java.util.Scanner;

public class MainApplication {
    public static Scanner scanner = new Scanner(System.in);
    public static Integer mainMenuOption = 0;

    public static void main(String[] args) {
        addSampleDataForAll();
        while (mainMenuOption != 8) {
            showMainMenu();
            System.out.println("Enter Your Choice:");
            mainMenuOption = scanner.nextInt();
            switch (mainMenuOption) {
                case 1 -> {
                    handlePatientMenu();
                }
                case 2 -> {
                    handleDoctorMenu();
                }
                case 3 -> {
                    handleNurseMenu();
                }
                case 4 -> {
                    handleAppointmentMenu();
                }
                case 5 -> {
                    handleMedicalRecordsMenu();
                }
                case 6 -> {
                    handleDepartmentMenu();
                }
                case 7 -> {
                    handleReportsAndStatisticsMenu();
                }
                case 8 -> System.out.println("Exiting System");
                default -> System.out.println("Please enter a number from the menu");
            }
        }
    }

    public static void showMainMenu() {
        System.out.println("Welcome To Hospital Management System");
        System.out.println("""
                1- Patient Management
                2- Doctor Management
                3. Nurse Management
                4. Appointment Management
                5. Medical Records Management
                6. Department Management
                7. Reports and Statistics
                8. Exit
                """);
    }

    public static void showPatientMenu() {
        System.out.println("Patient Management");
        System.out.println("""
                1- Register New Patient
                2- Register InPatient
                3. Register OutPatient
                4. Register Emergency Patient
                5. View All Patients
                6. Search Patient
                7. Update Patient Information
                8. Remove Patient
                9. View Patient Medical History
                10. Exit
                """);
    }

    public static void handlePatientMenu() {
        PatientService patientService = new PatientService();
        int option = 0;

        while (option != 10) {
            showPatientMenu();
            System.out.println("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    patientService.save(patientService.add());
                }
                case 2 -> {
                    patientService.save(patientService.addInPatient());
                }
                case 3 -> {
                    patientService.save(patientService.addOutPatient());
                }
                case 4 -> {
                    patientService.save(patientService.addEmergencyPatient());
                }
                case 5 -> {
                    patientService.getAll();
                }
                case 6 -> {
                    System.out.println("Search Patient By:");
                    System.out.println("1. ID");
                    System.out.println("2. Name");
                    System.out.print("Enter your choice(1 or 2): ");
                    String choice = scanner.nextLine();

                    switch (choice) {
                        case "1" -> patientService.searchById();
                        case "2" -> patientService.search();
                        default -> System.out.println("Invalid choice. Returning to patient menu.");
                    }
                }
                case 7 -> {
                    patientService.editPatient();
                }
                case 8 -> {
                    patientService.remove(patientService.getPatientToRemove());
                }
                case 9 -> {
                    MedicalRecordService medicalRecordService = new MedicalRecordService();
                    medicalRecordService.displayPatientHistory();
                }
                case 10 -> System.out.println("Returning to main menu");
                default -> System.out.println("Please enter a number from the menu");
            }
        }
    }

    public static void showDoctorMenu() {
        System.out.println("Doctor Management");
        System.out.println("""
                1- Add Doctor
                2- Add Surgeon
                3. Add Consultant
                4. Add General Practitioner
                5. View All Doctors
                6. Search Doctor by Specialization
                7. View Available Doctors
                8. Assign Patient to Doctor
                9. Update Doctor Information
                10. Remove Doctor
                11. Exit
                """);
    }

    public static void handleDoctorMenu() {
        DoctorService doctorService = new DoctorService();
        int option = 0;
        while (option != 11) {
            showDoctorMenu();
            System.out.println("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    doctorService.save(doctorService.add());
                }
                case 2 -> {
                    doctorService.save(doctorService.addSurgeon());
                }
                case 3 -> {
                    doctorService.save(doctorService.addConsultant());
                }
                case 4 -> {
                    doctorService.save(doctorService.addGeneralPractitioner());
                }
                case 5 -> {
                    doctorService.getAll();
                }
                case 6 -> {
                    doctorService.getDoctorsBySpecialization();
                }
                case 7 -> {
                    doctorService.getAvailableDoctors();
                }
                case 8 -> {
                    doctorService.assignPatientToDoctor();
                }
                case 9 -> {
                    doctorService.editDoctor();
                }
                case 10 -> {
                    doctorService.remove(doctorService.getDoctorToRemove());
                }
                case 11 -> System.out.println("Exiting Doctor Menu");
                default -> System.out.println("Please enter a number from the menu");
            }
        }
    }

    public static void showNurseMenu() {
        System.out.println("Nurse Management");
        System.out.println("""
                1- Add Nurse
                2- View All Nurses
                3. View Nurses by Department
                4. View Nurses by Shift
                5. Assign Nurse to Patient
                6. Update Nurse Information
                7. Remove Nurse
                8. Exit
                """);
    }

    public static void handleNurseMenu() {
        NurseService nurseService = new NurseService();
        int option = 0;
        while (option != 8) {
            showNurseMenu();
            System.out.println("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    nurseService.save(nurseService.add());
                }
                case 2 -> {
                    nurseService.getAll();
                }
                case 3 -> {
                    nurseService.getNursesByDepartment();
                }
                case 4 -> {
                    nurseService.getNursesByShift();
                }
                case 5 -> {
                    nurseService.assignPatientToNurse();
                }
                case 6 -> {
                    nurseService.editNurse();
                }
                case 7 -> {
                    nurseService.remove(nurseService.getNurseToRemove());
                }
                case 8 -> System.out.println("Exiting Nurse Menu");
                default -> System.out.println("Please enter a number from the menu");
            }
        }
    }

    public static void showAppointmentMenu() {
        System.out.println("Appointment Management");
        System.out.println("""
                1- Schedule New Appointment
                2- View All Appointments
                3. View Appointments by Patient
                4. View Appointments by Doctor
                5. View Appointments by Date
                6. Reschedule Appointment
                7. Cancel Appointment
                8. Complete Appointment
                9. View Upcoming Appointments
                10. Exit
                """);
    }

    public static void handleAppointmentMenu() {
        AppointmentService appointmentService = new AppointmentService();
        int option = 0;
        while (option != 10) {
            showAppointmentMenu();
            System.out.println("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    appointmentService.scheduleAppointment();
                }
                case 2 -> {
                    appointmentService.getAll();
                }
                case 3 -> {
                    appointmentService.getAppointmentsByPatient();
                }
                case 4 -> {
                    appointmentService.getAppointmentsByDoctor();
                }
                case 5 -> {
                    appointmentService.getAppointmentsByDate();
                }
                case 6 -> {
                    appointmentService.rescheduleAppointment();
                }
                case 7 -> {
                    appointmentService.cancelAppointment();
                }
                case 8 -> {
                    appointmentService.completeAppointment();
                }
                case 9 -> {
                    appointmentService.viewUpcomingAppointments();
                }
                case 10 -> System.out.println("Exiting Appointment Menu");
                default -> System.out.println("Please enter a number from the menu");
            }
        }
    }

    public static void showMedicalRecordsMenu() {
        System.out.println("Medical Records Management");
        System.out.println("""
                1- Create Medical Record
                2- View All Records
                3. View Records by Patient
                4. View Records by Doctor
                5. Update Medical Record
                6. Delete Medical Record
                7. Generate Patient History Report
                8. Exit
                """);
    }

    public static void handleMedicalRecordsMenu() {
        MedicalRecordService medicalRecordService = new MedicalRecordService();
        int option = 0;
        while (option != 8) {
            showMedicalRecordsMenu();
            System.out.println("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    medicalRecordService.save(medicalRecordService.add());
                }
                case 2 -> {
                    medicalRecordService.getAll();
                }
                case 3 -> {
                    medicalRecordService.getRecordsByPatientId();
                }
                case 4 -> {
                    medicalRecordService.getRecordsByDoctorId();
                }
                case 5 -> {
                    medicalRecordService.editMedicalRecord();
                }
                case 6 -> {
                    medicalRecordService.remove(medicalRecordService.getRecordToRemove());
                }
                case 7 -> {
                    medicalRecordService.displayPatientHistory();
                }
                case 8 -> System.out.println("Exiting Medical Records Menu");
                default -> System.out.println("Please enter a number from the menu");
            }
        }
    }

    public static void showDepartmentMenu() {
        System.out.println("Department Management");
        System.out.println("""
                1- Add Department
                2- View All Departments
                3. View Department Details
                4. Assign Doctor to Department
                5. Assign Nurse to Department
                6. Update Department Information
                7. View Department Statistics
                8. Exit
                """);
    }

    public static void handleDepartmentMenu() {
        DepartmentService departmentService = new DepartmentService();
        int option = 0;
        while (option != 8) {
            showDepartmentMenu();
            System.out.println("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    departmentService.save(departmentService.add());
                }
                case 2 -> {
                    departmentService.getAll();
                }
                case 3 -> {
                    departmentService.searchById();
                }
                case 4 -> {
                    departmentService.assignDoctorToDepartment();
                }
                case 5 -> {
                    departmentService.assignNurseToDepartment();
                }
                case 6 -> {
                    departmentService.editDepartment();
                }
                case 7 -> {
                    departmentService.displayDepartmentStatistics();
                }
                case 8 -> System.out.println("Exiting Department Menu");
                default -> System.out.println("Please enter a number from the menu");
            }
        }
    }

    public static void showReportsAndStatisticsMenu() {
        System.out.println("Reports and Statistics Management");
        System.out.println("""
                1- Daily Appointments Report
                2- Doctor Performance Report
                3. Department Occupancy Report
                4. Patient Statistics
                5. Emergency Cases Report
                6. Exit
                """);
    }

    public static void handleReportsAndStatisticsMenu() {
        ReportsService reportsService = new ReportsService();
        int option = 0;
        while (option != 6) {
            showReportsAndStatisticsMenu();
            System.out.println("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    reportsService.dailyAppointmentsReport();
                }
                case 2 -> {
                    reportsService.doctorPerformanceReport();
                }
                case 3 -> {
                    reportsService.departmentOccupancyReport();
                }
                case 4 -> {
                    reportsService.patientStatistics();
                }
                case 5 -> {
                    reportsService.emergencyCasesReport();
                }
                case 6 -> System.out.println("Exiting Reports & Statistics Menu");
                default -> System.out.println("Please enter a number from the menu");
            }
        }
    }

    public static void addSampleDataForAll() {
        PatientService.addSamplePatients();
        DoctorService.addSampleDoctors();
        NurseService.sampleDataNurse();
        DepartmentService.addSampleDepartments();
        AppointmentService.sampleDataAppointment();
        MedicalRecordService.addSampleMedicalRecords();
        linkSampleData();
    }

    public static void linkSampleData() {
        // Link Doctors to Departments
        for (int i = 0; i < DoctorService.doctorList.size(); i++) {
            Doctor doctor = DoctorService.doctorList.get(i);
            Department dept = DepartmentService.departmentList.get(i % DepartmentService.departmentList.size());
            doctor.setDepartmentId(dept.getDepartmentId());
            dept.getDoctors().add(doctor);
        }
        // Link Nurses to Departments
        for (int i = 0; i < NurseService.nursesList.size(); i++) {
            Nurse nurse = NurseService.nursesList.get(i);
            Department dept = DepartmentService.departmentList.get(i % DepartmentService.departmentList.size());
            nurse.setDepartmentId(dept.getDepartmentId());
            dept.getNurses().add(nurse);
        }
        // Assign Patients to Doctors and Nurses
        for (int i = 0; i < PatientService.patientList.size(); i++) {
            Patient patient = PatientService.patientList.get(i);
            Doctor doctor = DoctorService.doctorList.get(i % DoctorService.doctorList.size());
            doctor.getAssignedPatients().add(patient);

            Nurse nurse = NurseService.nursesList.get(i % NurseService.nursesList.size());
            nurse.getAssignedPatients().add(patient);

            if (patient instanceof InPatient inPatient) {
                inPatient.setAdmittingDoctorId(doctor.getDoctorId());
            } else if (patient instanceof EmergencyPatient emergencyPatient) {
                emergencyPatient.setAdmittingDoctorId(doctor.getDoctorId());
            } else if (patient instanceof OutPatient outPatient) {
                outPatient.setPreferredDoctorId(doctor.getDoctorId());
            }
        }
        System.out.println("Data linking completed successfully.");
    }
}