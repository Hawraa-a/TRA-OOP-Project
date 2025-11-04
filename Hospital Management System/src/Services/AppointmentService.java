package Services;

import Entities.Appointment;
import Entities.Patient;
import Interfaces.Appointable;
import Interfaces.Manageable;
import Interfaces.Searchable;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppointmentService implements Manageable<Appointment>, Searchable, Appointable {
    public static List<Appointment> appointmentList = new ArrayList<>();

    @Override
    public Appointment add() {
        System.out.println("=== Schedule New Appointment ===");
        Appointment appointment = new Appointment();
        String appointmentId = HelperUtils.generateId("AP");
        System.out.println("Generated Appointment ID: " + appointmentId);
        appointment.setAppointmentId(appointmentId);
        String patientId;
        while (true) {
            patientId = InputHandler.getStringInput("Enter Patient ID: ");
            if (PatientService.checkById(patientId)) {
                break;
            } else {
                System.out.println("No patient found with ID: " + patientId + " Please try again.");
            }
        }
        appointment.setPatientId(patientId);
        String doctorId;
        while (true) {
            doctorId = InputHandler.getStringInput("Enter Doctor ID: ");
            if (DoctorService.checkById(doctorId)) {
                break;
            } else {
                System.out.println("No doctor found with ID: " + doctorId + " Please try again.");
            }
        }
        appointment.setDoctorId(doctorId);
        LocalDate date = InputHandler.getDateInput("Enter Appointment Date: ");
        appointment.setAppointmentDate(date);
        String time = InputHandler.getStringInput("Enter Appointment Time (e.g., 10:30 AM): ");
        appointment.setAppointmentTime(time);
        String reason = InputHandler.getStringInput("Enter Reason for Visit: ");
        appointment.setReason(reason);
        String notes = InputHandler.getStringInput("Enter Notes: ");
        appointment.setNotes(notes);
        appointment.setStatus("Scheduled");

        return appointment;
    }

    public void save(Appointment appointment) {
        appointmentList.add(appointment);
        if (PatientService.checkById(appointment.getPatientId())) {
            for (Patient p : PatientService.patientList) {
                if (p.getPatientId().equalsIgnoreCase(appointment.getPatientId())) {
                    if (p.getAppointments() == null) {
                        p.setAppointments(new ArrayList<>());
                    }
                    p.getAppointments().add(appointment);
                    break;
                }
            }
        }
        System.out.println("Appointment saved successfully.");
    }

    public String getAppointmentToRemove() {
        if (appointmentList.isEmpty()) {
            System.out.println("No appointments in the list.");
            return null;
        }
        String id = InputHandler.getStringInput("Enter Appointment ID to remove: ");
        while (!checkById(id)) {
            id = InputHandler.getStringInput("Invalid ID. Please enter another Appointment ID: ");
        }
        return id;
    }

    @Override
    public void remove(String id) {
        if (id == null) {
            System.out.println("Invalid input. No appointment removed.");
            return;
        }

        if (checkById(id)) {
            appointmentList.removeIf(a -> a.getAppointmentId().equalsIgnoreCase(id));
            System.out.println("Appointment removed successfully.");
        } else {
            System.out.println("Appointment not found.");
        }
    }

    @Override
    public List<Appointment> getAll() {
        if (appointmentList.isEmpty()) {
            System.out.println("No appointments found.");
        }
        System.out.println("=== All Appointments ===");
        for (Appointment a : appointmentList) {
            a.displayInfo();
            System.out.println("------------------------------------");
        }
        return appointmentList;
    }

    @Override
    public void search() {

    }

    @Override
    public void searchById() {
        if (appointmentList.isEmpty()) {
            System.out.println("No appointments available.");
            return;
        }
        String id = InputHandler.getStringInput("Enter Appointment ID to search: ");
        boolean found = false;
        for (Appointment a : appointmentList) {
            if (a.getAppointmentId().equalsIgnoreCase(id)) {
                a.displayInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No appointment found with ID: " + id);
        }
    }

    @Override
    public void scheduleAppointment() {
        Appointment appointment = add();
        save(appointment);
    }

    @Override
    public void cancelAppointment() {
        if (appointmentList.isEmpty()) {
            System.out.println("No appointments available to cancel.");
            return;
        }
        String id = InputHandler.getStringInput("Enter Appointment ID to cancel: ");
        cancelAppointment(id);
    }

    @Override
    public void rescheduleAppointment() {
        String appointmentId = InputHandler.getStringInput("Enter Appointment ID to reschedule: ");
        LocalDate newDate = InputHandler.getDateInput("Enter New Date: ");
        String newTime = InputHandler.getStringInput("Enter New Time: ");
        for (Appointment a : appointmentList) {
            if (a.getAppointmentId().equalsIgnoreCase(appointmentId)) {
                a.reschedule(newDate, newTime);
                System.out.println("Appointment rescheduled successfully.");
                return;
            }
        }
        System.out.println("Appointment not found with ID: " + appointmentId);
    }

    public void getAppointmentsByPatient() {
        String patientId = InputHandler.getStringInput("Enter Patient ID: ");
        boolean found = false;
        for (Appointment a : appointmentList) {
            if (a.getPatientId().equalsIgnoreCase(patientId)) {
                a.displayInfo();
                System.out.println("------------------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No appointments found for this Patient.");
        }
    }

    public void getAppointmentsByDoctor() {
        String doctorId = InputHandler.getStringInput("Enter Doctor ID: ");
        boolean found = false;
        for (Appointment a : appointmentList) {
            if (a.getDoctorId().equalsIgnoreCase(doctorId)) {
                a.displayInfo();
                System.out.println("------------------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No appointments found for this Doctor.");
        }
    }

    public void getAppointmentsByDate() {
        LocalDate date = InputHandler.getDateInput("Enter Appointment Date: ");
        boolean found = false;
        for (Appointment a : appointmentList) {
            if (a.getAppointmentDate().equals(date)) {
                a.displayInfo();
                System.out.println("------------------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No appointments found on: " + date);
        }
    }

    public void completeAppointment() {
        String id = InputHandler.getStringInput("Enter Appointment ID to mark as completed: ");
        boolean found = false;
        for (Appointment a : appointmentList) {
            if (a.getAppointmentId().equalsIgnoreCase(id)) {
                a.complete(); // you already have this method in Appointment
                System.out.println("Appointment marked as completed.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Appointment not found.");
        }
    }

    public void cancelAppointment(String appointmentId) {
        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointmentId().equalsIgnoreCase(appointmentId)) {
                if ("Cancelled".equalsIgnoreCase(appointment.getStatus())) {
                    System.out.println("This appointment is already cancelled.");
                    return;
                }
                appointment.cancel();
                System.out.println("Appointment cancelled successfully.");
                return;
            }
        }
        System.out.println("Appointment not found with ID: " + appointmentId);
    }

    public void viewUpcomingAppointments() {
        LocalDate today = LocalDate.now();
        boolean found = false;
        for (Appointment a : appointmentList) {
            if (a.getAppointmentDate().isAfter(today)
                    && !"Cancelled".equalsIgnoreCase(a.getStatus())) {
                a.displaySummary();
                System.out.println("------------------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No upcoming appointments found.");
        }
    }

    public Appointment createAppointment(String patientId, String doctorId, LocalDate date) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(HelperUtils.generateId("AP"));
        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctorId);
        appointment.setAppointmentDate(date);
        appointment.setStatus("Scheduled");
        appointmentList.add(appointment);
        System.out.println("Appointment created successfully with ID: " + appointment.getAppointmentId());
        return appointment;
    }

    public Appointment createAppointment(String patientId, String doctorId, LocalDate date, String time) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(HelperUtils.generateId("AP"));
        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctorId);
        appointment.setAppointmentDate(date);
        appointment.setAppointmentTime(time);
        appointment.setStatus("Scheduled");
        appointmentList.add(appointment);
        System.out.println("Appointment created successfully with ID: " + appointment.getAppointmentId());
        return appointment;
    }

    public Appointment createAppointment(Appointment appointment) {
        if (appointment == null) {
            System.out.println("Invalid appointment object.");
            return null;
        }
        if (appointment.getAppointmentId() == null) {
            appointment.setAppointmentId(HelperUtils.generateId("AP"));
        }
        appointmentList.add(appointment);
        System.out.println("Appointment created successfully (using object).");
        return appointment;
    }

    public void rescheduleAppointment(String appointmentId, LocalDate newDate) {
        for (Appointment a : appointmentList) {
            if (a.getAppointmentId().equalsIgnoreCase(appointmentId)) {
                a.reschedule(newDate, a.getAppointmentTime());
                System.out.println("Appointment rescheduled to " + newDate);
                return;
            }
        }
        System.out.println("Appointment not found with ID: " + appointmentId);
    }

    public void rescheduleAppointment(String appointmentId, LocalDate newDate, String newTime) {
        for (Appointment a : appointmentList) {
            if (a.getAppointmentId().equalsIgnoreCase(appointmentId)) {
                a.reschedule(newDate, newTime);
                System.out.println("Appointment rescheduled to " + newDate + " at " + newTime);
                return;
            }
        }
        System.out.println("Appointment not found with ID: " + appointmentId);
    }

    public void rescheduleAppointment(Appointment appointment, LocalDate newDate, String newTime, String reason) {
        if (appointment == null) {
            System.out.println("Invalid appointment object.");
            return;
        }
        appointment.setAppointmentDate(newDate);
        appointment.setAppointmentTime(newTime);
        appointment.setReason(reason);
        System.out.println("Appointment updated: new date " + newDate + ", time " + newTime + ", reason updated.");
    }

    public void displayAppointments(LocalDate date) {
        boolean found = false;
        System.out.println("=== Appointments on " + date + " ===");
        for (Appointment a : appointmentList) {
            if (a.getAppointmentDate().equals(date)) {
                a.displayInfo();
                System.out.println("------------------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No appointments found on this date.");
        }
    }

    public void displayAppointments(String doctorId, LocalDate startDate, LocalDate endDate) {
        boolean found = false;
        System.out.println("=== Appointments for Doctor " + doctorId + " between " + startDate + " and " + endDate + " ===");
        for (Appointment a : appointmentList) {
            if (a.getDoctorId().equalsIgnoreCase(doctorId)
                    && (a.getAppointmentDate().isEqual(startDate) || a.getAppointmentDate().isAfter(startDate))
                    && (a.getAppointmentDate().isEqual(endDate) || a.getAppointmentDate().isBefore(endDate))) {
                a.displayInfo();
                System.out.println("------------------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No appointments found in this range for the doctor.");
        }
    }

    public static boolean checkById(String id) {
        for (Appointment a : appointmentList) {
            if (a.getAppointmentId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }
}