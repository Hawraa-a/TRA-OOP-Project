package Services;

import Entities.*;

import java.util.List;

public class ReportsService {
    private final AppointmentService appointmentService = new AppointmentService();
    private final DoctorService doctorService = new DoctorService();
    private final DepartmentService departmentService = new DepartmentService();
    private final PatientService patientService = new PatientService();

    public void dailyAppointmentsReport() {
        System.out.println("Daily Appointments Report");
        List<Appointment> appointments = appointmentService.getAll();
        for (Appointment app : appointments) {
            System.out.println("Appointment Id: " + app.getAppointmentId() +
                    " | Patient Id: " + app.getPatientId() +
                    " | Doctor Id: " + app.getDoctorId() +
                    " | Date: " + app.getAppointmentDate() +
                    " | Time: " + app.getAppointmentTime());
        }
    }

    public void doctorPerformanceReport() {
        System.out.println("Doctor Performance Report");
        List<Doctor> doctors = doctorService.getAll();
        for (Doctor doc : doctors) {
            System.out.println("Doctor: " + doc.getFirstName() + " " + doc.getLastName() + " | Patients Assigned: " + doc.getAssignedPatients().size());
        }
    }

    public void departmentOccupancyReport() {
        System.out.println("Department Occupancy Report");
        List<Department> departments = departmentService.getAlldepartmentList();
        if (departments.isEmpty()){
            System.out.println("No departments available to show.");
            return;
        }
        for (Department dep : departments) {
            System.out.println("Department Name: " + dep.getDepartmentName() + "\n Head Doctor Id: "+ dep.getHeadDoctorId() + "\n Bed Capacity: " + dep.getBedCapacity() + "\n Available Capacity: " +dep.getAvailableBeds());
        }
    }

    public void patientStatistics() {
        System.out.println("Patient Statistics");
        List<Patient> patients = patientService.getAllPatientsList();

        if (patients.isEmpty()) {
            System.out.println("No patients available to show statistics.");
            return;
        }
        int totalPatients = patients.size();
        long inPatients = patients.stream().filter(p -> p instanceof InPatient).count();
        long outPatients = patients.stream().filter(p -> p instanceof OutPatient).count();
        long emergencyPatients = patients.stream().filter(p -> p instanceof EmergencyPatient).count();

        System.out.println("Total Patients: " + totalPatients);
        System.out.println("InPatients: " + inPatients);
        System.out.println("OutPatients: " + outPatients);
        System.out.println("Emergency Patients: " + emergencyPatients);
    }

    public void emergencyCasesReport() {
        System.out.println("Emergency Cases Report");
        List<Patient> patients = patientService.getAllPatientsList();

        patients.stream()
                .filter(patient -> patient instanceof EmergencyPatient)
                .forEach(Patient::displayInfo);
    }
}