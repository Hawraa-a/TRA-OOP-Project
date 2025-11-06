package Services;

import Entities.*;
import Utils.HelperUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SampleData {

    private final DepartmentService departmentService = new DepartmentService();
    private final DoctorService doctorService = new DoctorService();
    private final NurseService nurseService = new NurseService();
    private final PatientService patientService = new PatientService();
    private final AppointmentService appointmentService = new AppointmentService();
    private final MedicalRecordService medicalRecordService = new MedicalRecordService();

    public static void initializeAllData() {
        System.out.println("initializeAllData: initialize sample data and run tests");
        SampleData init = new SampleData();
        System.out.println("\n=== INITIALIZING SAMPLE DATA ===\n");
        init.populateSampleData();
        System.out.println("\n=== RUNNING SYSTEM TESTS ===\n");
        init.testAllFunctions();
        System.out.println("\n=== FINISHED ===\n");
    }

    public void populateSampleData() {
        System.out.println("populateSampleData: create departments, doctors, nurses, patients, appointments, medical records");
        addDepartments();
        addDoctors();
        addNurses();
        addPatients();
        addAppointments();
        addMedicalRecords();
        System.out.println("Sample data populated.");
    }

    private void addDepartments() {
        System.out.println("addDepartments: add 3 departments to DepartmentService.departmentList");
        Department dep1 = new Department();
        dep1.setDepartmentId(HelperUtils.generateId("DEP"));
        dep1.setDepartmentName("Cardiology");
        dep1.setBedCapacity(30);
        dep1.setAvailableBeds(30);

        Department dep2 = new Department();
        dep2.setDepartmentId(HelperUtils.generateId("DEP"));
        dep2.setDepartmentName("Neurology");
        dep2.setBedCapacity(20);
        dep2.setAvailableBeds(20);

        Department dep3 = new Department();
        dep3.setDepartmentId(HelperUtils.generateId("DEP"));
        dep3.setDepartmentName("Pediatrics");
        dep3.setBedCapacity(25);
        dep3.setAvailableBeds(25);

        DepartmentService.departmentList.add(dep1);
        DepartmentService.departmentList.add(dep2);
        DepartmentService.departmentList.add(dep3);
    }

    private void addDoctors() {
        System.out.println("addDoctors: add 8 doctors (mix of Doctor, Surgeon, Consultant, GP)");

        Doctor d1 = new Doctor();
        d1.setId(HelperUtils.generateId("PER"));
        d1.setDoctorId(HelperUtils.generateId("DR"));
        d1.setFirstName("Ahmed");
        d1.setLastName("Alawi");
        d1.setDateOfBirth(LocalDate.of(1978, 4, 5));
        d1.setGender("Male");
        d1.setPhoneNumber("97170000001");
        d1.setEmail("ahmed.alawi@example.com");
        d1.setAddress("Muscat");
        d1.setSpecialization("Cardiology");
        d1.setQualification("MBBS, MD");
        d1.setExperienceYears(15);
        d1.setConsultationFee(60.0);
        d1.setDepartmentId(DepartmentService.departmentList.getFirst().getDepartmentId());
        d1.setAvailableSlots(new ArrayList<>(Arrays.asList("Mon 10AM", "Wed 2PM")));
        d1.setAssignedPatients(new ArrayList<>());

        Surgeon s2 = new Surgeon();
        s2.setId(HelperUtils.generateId("PER"));
        s2.setDoctorId(HelperUtils.generateId("SUR"));
        s2.setFirstName("Khalid");
        s2.setLastName("Yousef");
        s2.setDateOfBirth(LocalDate.of(1980, 6, 12));
        s2.setGender("Male");
        s2.setPhoneNumber("97170000002");
        s2.setEmail("khalid.yousef@example.com");
        s2.setAddress("Muscat");
        s2.setSpecialization("Cardiac Surgery");
        s2.setQualification("MBBS, MS");
        s2.setExperienceYears(12);
        s2.setConsultationFee(120.0);
        s2.setOperationTheatreAccess(true);
        s2.setSurgeriesPerformed(320);
        s2.setSurgeryTypes(new ArrayList<>(Arrays.asList("Bypass", "Valve Repair")));
        s2.setDepartmentId(DepartmentService.departmentList.getFirst().getDepartmentId());
        s2.setAvailableSlots(new ArrayList<>(Arrays.asList("Tue 9AM", "Thu 3PM")));
        s2.setAssignedPatients(new ArrayList<>());

        Consultant c3 = new Consultant();
        c3.setId(HelperUtils.generateId("PER"));
        c3.setDoctorId(HelperUtils.generateId("CON"));
        c3.setFirstName("Sara");
        c3.setLastName("Hassan");
        c3.setDateOfBirth(LocalDate.of(1985, 2, 18));
        c3.setGender("Female");
        c3.setPhoneNumber("97170000003");
        c3.setEmail("sara.hassan@example.com");
        c3.setAddress("Muscat");
        c3.setSpecialization("Neurology");
        c3.setQualification("MBBS, DM");
        c3.setExperienceYears(10);
        c3.setConsultationFee(80.0);
        c3.setDepartmentId(DepartmentService.departmentList.get(1).getDepartmentId());
        c3.setAvailableSlots(new ArrayList<>(Arrays.asList("Mon 1PM", "Fri 10AM")));
        c3.setAssignedPatients(new ArrayList<>());

        GeneralPractitioner g4 = new GeneralPractitioner();
        g4.setId(HelperUtils.generateId("PER"));
        g4.setDoctorId(HelperUtils.generateId("GP"));
        g4.setFirstName("Mohammed");
        g4.setLastName("Salem");
        g4.setDateOfBirth(LocalDate.of(1990, 9, 3));
        g4.setGender("Male");
        g4.setPhoneNumber("97170000004");
        g4.setEmail("mohammed.salem@example.com");
        g4.setAddress("Seeb");
        g4.setSpecialization("General Medicine");
        g4.setQualification("MBBS");
        g4.setExperienceYears(8);
        g4.setConsultationFee(30.0);
        g4.setDepartmentId(DepartmentService.departmentList.get(2).getDepartmentId());
        g4.setAvailableSlots(new ArrayList<>(Arrays.asList("Mon 9AM", "Wed 11AM")));
        g4.setAssignedPatients(new ArrayList<>());

        Surgeon s5 = new Surgeon();
        s5.setId(HelperUtils.generateId("PER"));
        s5.setDoctorId(HelperUtils.generateId("SUR"));
        s5.setFirstName("Fatma");
        s5.setLastName("Rashid");
        s5.setDateOfBirth(LocalDate.of(1986, 11, 7));
        s5.setGender("Female");
        s5.setPhoneNumber("97170000005");
        s5.setEmail("fatma.rashid@example.com");
        s5.setAddress("Salalah");
        s5.setSpecialization("Pediatric Surgery");
        s5.setQualification("MBBS, MS");
        s5.setExperienceYears(9);
        s5.setConsultationFee(100.0);
        s5.setOperationTheatreAccess(true);
        s5.setSurgeriesPerformed(150);
        s5.setSurgeryTypes(new ArrayList<>(List.of("Appendix", "Hernia")));
        s5.setDepartmentId(DepartmentService.departmentList.get(2).getDepartmentId());
        s5.setAvailableSlots(new ArrayList<>(List.of("Tue 2PM")));
        s5.setAssignedPatients(new ArrayList<>());

        Consultant c6 = new Consultant();
        c6.setId(HelperUtils.generateId("PER"));
        c6.setDoctorId(HelperUtils.generateId("CON"));
        c6.setFirstName("Omar");
        c6.setLastName("Idris");
        c6.setDateOfBirth(LocalDate.of(1975, 12, 1));
        c6.setGender("Male");
        c6.setPhoneNumber("97170000006");
        c6.setEmail("omar.idris@example.com");
        c6.setAddress("Muscat");
        c6.setSpecialization("Cardiology");
        c6.setQualification("MBBS, FACC");
        c6.setExperienceYears(18);
        c6.setConsultationFee(90.0);
        c6.setDepartmentId(DepartmentService.departmentList.getFirst().getDepartmentId());
        c6.setAvailableSlots(new ArrayList<>(List.of("Thu 11AM")));
        c6.setAssignedPatients(new ArrayList<>());

        GeneralPractitioner g7 = new GeneralPractitioner();
        g7.setId(HelperUtils.generateId("PER"));
        g7.setDoctorId(HelperUtils.generateId("GP"));
        g7.setFirstName("Layla");
        g7.setLastName("Mahmoud");
        g7.setDateOfBirth(LocalDate.of(1992, 3, 21));
        g7.setGender("Female");
        g7.setPhoneNumber("97170000007");
        g7.setEmail("layla.mahmoud@example.com");
        g7.setAddress("Nizwa");
        g7.setSpecialization("Pediatrics");
        g7.setQualification("MBBS");
        g7.setExperienceYears(6);
        g7.setConsultationFee(35.0);
        g7.setDepartmentId(DepartmentService.departmentList.get(2).getDepartmentId());
        g7.setAvailableSlots(new ArrayList<>(List.of("Fri 9AM")));
        g7.setAssignedPatients(new ArrayList<>());

        Consultant c8 = new Consultant();
        c8.setId(HelperUtils.generateId("PER"));
        c8.setDoctorId(HelperUtils.generateId("CON"));
        c8.setFirstName("Huda");
        c8.setLastName("Khalil");
        c8.setDateOfBirth(LocalDate.of(1983, 8, 30));
        c8.setGender("Female");
        c8.setPhoneNumber("97170000008");
        c8.setEmail("huda.khalil@example.com");
        c8.setAddress("Salalah");
        c8.setSpecialization("Neurology");
        c8.setQualification("MBBS, DM");
        c8.setExperienceYears(11);
        c8.setConsultationFee(85.0);
        c8.setDepartmentId(DepartmentService.departmentList.get(1).getDepartmentId());
        c8.setAvailableSlots(new ArrayList<>(List.of("Wed 3PM")));
        c8.setAssignedPatients(new ArrayList<>());

        DoctorService.doctorList.add(d1);
        DoctorService.doctorList.add(s2);
        DoctorService.doctorList.add(c3);
        DoctorService.doctorList.add(g4);
        DoctorService.doctorList.add(s5);
        DoctorService.doctorList.add(c6);
        DoctorService.doctorList.add(g7);
        DoctorService.doctorList.add(c8);
    }

    private void addNurses() {
        System.out.println("addNurses: add 5 nurses to NurseService.nursesList");
        Nurse n1 = new Nurse();
        n1.setId(HelperUtils.generateId("PER"));
        n1.setNurseId(HelperUtils.generateId("NUR"));
        n1.setFirstName("Nawal");
        n1.setLastName("Saeed");
        n1.setDateOfBirth(LocalDate.of(1993, 1, 10));
        n1.setGender("Female");
        n1.setPhoneNumber("97180000001");
        n1.setEmail("nawal.saeed@example.com");
        n1.setAddress("Muscat");
        n1.setShift("Morning");
        n1.setQualification("BSc Nursing");
        n1.setDepartmentId(DepartmentService.departmentList.getFirst().getDepartmentId());
        n1.setAssignedPatients(new ArrayList<>());

        Nurse n2 = new Nurse();
        n2.setId(HelperUtils.generateId("PER"));
        n2.setNurseId(HelperUtils.generateId("NUR"));
        n2.setFirstName("Hassan");
        n2.setLastName("Yousuf");
        n2.setDateOfBirth(LocalDate.of(1990, 5, 2));
        n2.setGender("Male");
        n2.setPhoneNumber("97180000002");
        n2.setEmail("hassan.yousuf@example.com");
        n2.setAddress("Nizwa");
        n2.setShift("Evening");
        n2.setQualification("Diploma Nursing");
        n2.setDepartmentId(DepartmentService.departmentList.get(1).getDepartmentId());
        n2.setAssignedPatients(new ArrayList<>());

        Nurse n3 = new Nurse();
        n3.setId(HelperUtils.generateId("PER"));
        n3.setNurseId(HelperUtils.generateId("NUR"));
        n3.setFirstName("Maryam");
        n3.setLastName("Ali");
        n3.setDateOfBirth(LocalDate.of(1994, 7, 14));
        n3.setGender("Female");
        n3.setPhoneNumber("97180000003");
        n3.setEmail("maryam.ali@example.com");
        n3.setAddress("Salalah");
        n3.setShift("Night");
        n3.setQualification("BSc Nursing");
        n3.setDepartmentId(DepartmentService.departmentList.get(2).getDepartmentId());
        n3.setAssignedPatients(new ArrayList<>());

        Nurse n4 = new Nurse();
        n4.setId(HelperUtils.generateId("PER"));
        n4.setNurseId(HelperUtils.generateId("NUR"));
        n4.setFirstName("Khalid");
        n4.setLastName("Nasser");
        n4.setDateOfBirth(LocalDate.of(1988, 10, 9));
        n4.setGender("Male");
        n4.setPhoneNumber("97180000004");
        n4.setEmail("khalid.nasser@example.com");
        n4.setAddress("Seeb");
        n4.setShift("Morning");
        n4.setQualification("Diploma Nursing");
        n4.setDepartmentId(DepartmentService.departmentList.getFirst().getDepartmentId());
        n4.setAssignedPatients(new ArrayList<>());

        Nurse n5 = new Nurse();
        n5.setId(HelperUtils.generateId("PER"));
        n5.setNurseId(HelperUtils.generateId("NUR"));
        n5.setFirstName("Rasha");
        n5.setLastName("Salem");
        n5.setDateOfBirth(LocalDate.of(1991, 12, 20));
        n5.setGender("Female");
        n5.setPhoneNumber("97180000005");
        n5.setEmail("rasha.salem@example.com");
        n5.setAddress("Muscat");
        n5.setShift("Evening");
        n5.setQualification("BSc Nursing");
        n5.setDepartmentId(DepartmentService.departmentList.get(1).getDepartmentId());
        n5.setAssignedPatients(new ArrayList<>());

        NurseService.nursesList.add(n1);
        NurseService.nursesList.add(n2);
        NurseService.nursesList.add(n3);
        NurseService.nursesList.add(n4);
        NurseService.nursesList.add(n5);
    }

    private void addPatients() {
        System.out.println("addPatients: add at least 10 patients (regular, in, out, emergency) and ensure DOB < registrationDate <= today");

        Patient p1 = new Patient();
        p1.setId(HelperUtils.generateId("PER"));
        p1.setPatientId(HelperUtils.generateId("PAT"));
        p1.setFirstName("Aisha");
        p1.setLastName("Khaled");
        p1.setDateOfBirth(LocalDate.of(1995, 3, 15));
        p1.setGender("Female");
        p1.setPhoneNumber("97190000001");
        p1.setEmail("aisha.khaled@example.com");
        p1.setAddress("Muttrah");

        p1.setRegistrationDate(p1.getDateOfBirth().plusYears(20));
        p1.setBloodGroup("A+");
        p1.setEmergencyContact("97111223344");
        p1.setMedicalRecords(new ArrayList<>());
        p1.setAppointments(new ArrayList<>());

        Patient p2 = new Patient();
        p2.setId(HelperUtils.generateId("PER"));
        p2.setPatientId(HelperUtils.generateId("PAT"));
        p2.setFirstName("Suleiman");
        p2.setLastName("Othman");
        p2.setDateOfBirth(LocalDate.of(1987, 6, 2));
        p2.setGender("Male");
        p2.setPhoneNumber("97190000002");
        p2.setEmail("suleiman.othman@example.com");
        p2.setAddress("Seeb");
        p2.setRegistrationDate(p2.getDateOfBirth().plusYears(30));
        p2.setBloodGroup("B+");
        p2.setEmergencyContact("97112223344");
        p2.setMedicalRecords(new ArrayList<>());
        p2.setAppointments(new ArrayList<>());

        Patient p3 = new Patient();
        p3.setId(HelperUtils.generateId("PER"));
        p3.setPatientId(HelperUtils.generateId("PAT"));
        p3.setFirstName("Mona");
        p3.setLastName("Abdullah");
        p3.setDateOfBirth(LocalDate.of(1998, 11, 11));
        p3.setGender("Female");
        p3.setPhoneNumber("97190000003");
        p3.setEmail("mona.abdullah@example.com");
        p3.setAddress("Nizwa");
        p3.setRegistrationDate(p3.getDateOfBirth().plusYears(18));
        p3.setBloodGroup("O+");
        p3.setEmergencyContact("97113334455");
        p3.setMedicalRecords(new ArrayList<>());
        p3.setAppointments(new ArrayList<>());

        Patient p4 = new Patient();
        p4.setId(HelperUtils.generateId("PER"));
        p4.setPatientId(HelperUtils.generateId("PAT"));
        p4.setFirstName("Hassan");
        p4.setLastName("Fahad");
        p4.setDateOfBirth(LocalDate.of(1990, 2, 28));
        p4.setGender("Male");
        p4.setPhoneNumber("97190000004");
        p4.setEmail("hassan.fahad@example.com");
        p4.setAddress("Rustaq");
        p4.setRegistrationDate(p4.getDateOfBirth().plusYears(25));
        p4.setBloodGroup("AB+");
        p4.setEmergencyContact("97114445566");
        p4.setMedicalRecords(new ArrayList<>());
        p4.setAppointments(new ArrayList<>());

        InPatient ip1 = new InPatient();
        ip1.setId(HelperUtils.generateId("PER"));
        ip1.setPatientId(HelperUtils.generateId("INP"));
        ip1.setFirstName("Inaya");
        ip1.setLastName("Rami");
        ip1.setDateOfBirth(LocalDate.of(2000, 5, 5));
        ip1.setGender("Female");
        ip1.setPhoneNumber("97190000005");
        ip1.setEmail("inaya.rami@example.com");
        ip1.setAddress("Muscat");
        ip1.setRegistrationDate(ip1.getDateOfBirth().plusYears(19));
        ip1.setAdmissionDate(ip1.getRegistrationDate().plusDays(10));
        ip1.setDischargeDate(ip1.getAdmissionDate().plusDays(3));
        ip1.setRoomNumber("101");
        ip1.setBedNumber("A1");
        ip1.setDailyCharges(50.0);
        ip1.setAdmittingDoctorId(DoctorService.doctorList.getFirst().getDoctorId());
        ip1.setMedicalRecords(new ArrayList<>());
        ip1.setAppointments(new ArrayList<>());

        InPatient ip2 = new InPatient();
        ip2.setId(HelperUtils.generateId("PER"));
        ip2.setPatientId(HelperUtils.generateId("INP"));
        ip2.setFirstName("Zain");
        ip2.setLastName("Hadi");
        ip2.setDateOfBirth(LocalDate.of(1996, 8, 8));
        ip2.setGender("Male");
        ip2.setPhoneNumber("97190000006");
        ip2.setEmail("zain.hadi@example.com");
        ip2.setAddress("Sohar");
        ip2.setRegistrationDate(ip2.getDateOfBirth().plusYears(22));
        ip2.setAdmissionDate(ip2.getRegistrationDate().plusDays(5));
        ip2.setDischargeDate(ip2.getAdmissionDate().plusDays(2));
        ip2.setRoomNumber("102");
        ip2.setBedNumber("B2");
        ip2.setDailyCharges(70.0);
        ip2.setAdmittingDoctorId(DoctorService.doctorList.get(1).getDoctorId());
        ip2.setMedicalRecords(new ArrayList<>());
        ip2.setAppointments(new ArrayList<>());

        OutPatient op1 = new OutPatient();
        op1.setId(HelperUtils.generateId("PER"));
        op1.setPatientId(HelperUtils.generateId("OUT"));
        op1.setFirstName("Rami");
        op1.setLastName("Naji");
        op1.setDateOfBirth(LocalDate.of(1993, 4, 4));
        op1.setGender("Male");
        op1.setPhoneNumber("97190000007");
        op1.setEmail("rami.naji@example.com");
        op1.setAddress("Bahla");
        op1.setRegistrationDate(op1.getDateOfBirth().plusYears(20));
        op1.setVisitCount(3);
        op1.setLastVisitDate(op1.getRegistrationDate().plusDays(60));
        op1.setPreferredDoctorId(DoctorService.doctorList.get(2).getDoctorId());
        op1.setMedicalRecords(new ArrayList<>());
        op1.setAppointments(new ArrayList<>());

        OutPatient op2 = new OutPatient();
        op2.setId(HelperUtils.generateId("PER"));
        op2.setPatientId(HelperUtils.generateId("OUT"));
        op2.setFirstName("Laila");
        op2.setLastName("Saber");
        op2.setDateOfBirth(LocalDate.of(1997, 12, 12));
        op2.setGender("Female");
        op2.setPhoneNumber("97190000008");
        op2.setEmail("laila.saber@example.com");
        op2.setAddress("Ibri");
        op2.setRegistrationDate(op2.getDateOfBirth().plusYears(18));
        op2.setVisitCount(1);
        op2.setLastVisitDate(op2.getRegistrationDate().plusDays(30));
        op2.setPreferredDoctorId(DoctorService.doctorList.get(3).getDoctorId());
        op2.setMedicalRecords(new ArrayList<>());
        op2.setAppointments(new ArrayList<>());

        EmergencyPatient ep1 = new EmergencyPatient();
        ep1.setId(HelperUtils.generateId("PER"));
        ep1.setPatientId(HelperUtils.generateId("EMP"));
        ep1.setFirstName("Emergency");
        ep1.setLastName("Case1");
        ep1.setDateOfBirth(LocalDate.of(2002, 2, 2));
        ep1.setGender("Male");
        ep1.setPhoneNumber("97190000009");
        ep1.setEmail("emergency.case1@example.com");
        ep1.setAddress("Muscat");
        ep1.setRegistrationDate(ep1.getDateOfBirth().plusYears(18));
        ep1.setEmergencyType("Accident");
        ep1.setArrivalMode("Ambulance");
        ep1.setTriageLevel(2);
        ep1.setAdmittedViaER(true);
        ep1.setMedicalRecords(new ArrayList<>());
        ep1.setAppointments(new ArrayList<>());

        Patient p10 = new Patient();
        p10.setId(HelperUtils.generateId("PER"));
        p10.setPatientId(HelperUtils.generateId("PAT"));
        p10.setFirstName("Fatima");
        p10.setLastName("Al Balushi");
        p10.setDateOfBirth(LocalDate.of(1994, 9, 9));
        p10.setGender("Female");
        p10.setPhoneNumber("97190000010");
        p10.setEmail("fatima.albalushi@example.com");
        p10.setAddress("Barka");
        p10.setRegistrationDate(p10.getDateOfBirth().plusYears(21));
        p10.setBloodGroup("O-");
        p10.setEmergencyContact("97117778899");
        p10.setMedicalRecords(new ArrayList<>());
        p10.setAppointments(new ArrayList<>());

        PatientService.patientList.add(p1);
        PatientService.patientList.add(p2);
        PatientService.patientList.add(p3);
        PatientService.patientList.add(p4);
        PatientService.patientList.add(ip1);
        PatientService.patientList.add(ip2);
        PatientService.patientList.add(op1);
        PatientService.patientList.add(op2);
        PatientService.patientList.add(ep1);
        PatientService.patientList.add(p10);
    }

    private void addAppointments() {
        System.out.println("addAppointments: create 15 appointments and link them to patients & doctors safely");
        for (int i = 0; i < 15; i++) {
            Appointment a = new Appointment();
            a.setAppointmentId(HelperUtils.generateId("AP"));
            if (!PatientService.patientList.isEmpty() && !DoctorService.doctorList.isEmpty()) {
                a.setPatientId(PatientService.patientList.get(i % PatientService.patientList.size()).getPatientId());
                a.setDoctorId(DoctorService.doctorList.get(i % DoctorService.doctorList.size()).getDoctorId());
            }
            a.setAppointmentDate(LocalDate.now().plusDays(i + 1));
            a.setAppointmentTime((9 + (i % 8)) + ":00");
            a.setReason("Routine check " + (i + 1));
            a.setStatus("Scheduled");
            AppointmentService.appointmentList.add(a);
            Patient linked = PatientService.patientList.get(i % PatientService.patientList.size());
            if (linked.getAppointments() == null) linked.setAppointments(new ArrayList<>());
            linked.getAppointments().add(a);
        }
    }

    private void addMedicalRecords() {
        System.out.println("addMedicalRecords: create 12 medical records and link to patients & doctors");
        // create 12 medical records manually
        for (int i = 0; i < 12; i++) {
            MedicalRecord r = new MedicalRecord();
            r.setRecordId(HelperUtils.generateId("MR"));
            if (!PatientService.patientList.isEmpty()) {
                r.setPatientId(PatientService.patientList.get(i % PatientService.patientList.size()).getPatientId());
            }
            if (!DoctorService.doctorList.isEmpty()) {
                r.setDoctorId(DoctorService.doctorList.get(i % DoctorService.doctorList.size()).getDoctorId());
            }
            r.setDiagnosis("Diagnosis " + (i + 1));
            r.setPrescription("Prescription " + (i + 1));
            r.setTestResults("Test results " + (i + 1));
            r.setVisitDate(LocalDate.now().minusDays(i + 1));
            MedicalRecordService.recordList.add(r);

            Patient linked = PatientService.patientList.get(i % PatientService.patientList.size());
            if (linked.getMedicalRecords() == null) linked.setMedicalRecords(new ArrayList<>());
            linked.getMedicalRecords().add(r);
        }
    }

    public void testAllFunctions() {
        System.out.println("testAllFunctions: run all tests (CRUD, overloaded methods, interfaces, utils, inheritance/polymorphism)");
        testCrudOperations();
        testOverloadedMethods();
        testInterfaceImplementations();
        testHelperUtils();
        testInheritancePolymorphism();
    }

    private void testCrudOperations() {
        System.out.println("testCrudOperations: validate basic create/read/update/delete flows for patients, appointments, and records");

        System.out.println("-- Patients before add: " + PatientService.patientList.size());
        Patient temp = new Patient();
        temp.setId(HelperUtils.generateId("PER"));
        temp.setPatientId(HelperUtils.generateId("PAT"));
        temp.setFirstName("Temp");
        temp.setDateOfBirth(LocalDate.of(1999, 1, 1));
        temp.setGender("Male");
        temp.setPhoneNumber("97190000999");
        temp.setEmail("temp@example.com");
        temp.setRegistrationDate(temp.getDateOfBirth().plusYears(20));
        PatientService.patientList.add(temp);
        System.out.println("-- Patients after add: " + PatientService.patientList.size());

        System.out.println("-- Removing the temp patient.");
        PatientService.patientList.removeIf(p -> "Temp".equals(p.getFirstName()));
        System.out.println("-- Patients after remove: " + PatientService.patientList.size());

        System.out.println("-- Appointments count: " + AppointmentService.appointmentList.size());
        Appointment ap = new Appointment();
        ap.setAppointmentId(HelperUtils.generateId("AP"));
        ap.setPatientId(PatientService.patientList.getFirst().getPatientId());
        ap.setDoctorId(DoctorService.doctorList.getFirst().getDoctorId());
        ap.setAppointmentDate(LocalDate.now().plusDays(7));
        ap.setAppointmentTime("10:00");
        AppointmentService.appointmentList.add(ap);
        System.out.println("-- Appointments after add: " + AppointmentService.appointmentList.size());
        AppointmentService.appointmentList.remove(ap);
        System.out.println("-- Appointments after remove: " + AppointmentService.appointmentList.size());

        System.out.println("-- Medical records count: " + MedicalRecordService.recordList.size());
        MedicalRecord rec = new MedicalRecord();
        rec.setRecordId(HelperUtils.generateId("MR"));
        rec.setPatientId(PatientService.patientList.getFirst().getPatientId());
        rec.setVisitDate(LocalDate.now().minusDays(2));
        MedicalRecordService.recordList.add(rec);
        System.out.println("-- Medical records after add: " + MedicalRecordService.recordList.size());
        MedicalRecordService.recordList.remove(rec);
        System.out.println("-- Medical records after remove: " + MedicalRecordService.recordList.size());

        System.out.println();
    }

    private void testOverloadedMethods() {
        System.out.println("testOverloadedMethods: exercise methods overloaded across Doctor, Patient, Appointment, AppointmentService");
        Doctor doc = DoctorService.doctorList.getFirst();
        System.out.println("-- Original fee: " + doc.getConsultationFee());
        doc.updateFee(75.0);
        System.out.println("-- After updateFee(75.0): " + doc.getConsultationFee());
        doc.updateFee(80.0, "New policy");
        System.out.println("-- After updateFee(80.0, reason): " + doc.getConsultationFee());

        Patient pat = PatientService.patientList.getFirst();
        System.out.println("-- Original contact/email: " + pat.getPhoneNumber() + " / " + pat.getEmail());
        pat.updateContact("9799999999");
        System.out.println("-- After updateContact(phone): " + pat.getPhoneNumber());
        pat.updateContact("9788888888", "newemail@example.com");
        System.out.println("-- After updateContact(phone,email): " + pat.getPhoneNumber() + " / " + pat.getEmail());

        if (!AppointmentService.appointmentList.isEmpty()) {
            Appointment a = AppointmentService.appointmentList.getFirst();
            a.addNotes("Simple note");
            System.out.println("-- Appointment notes after addNotes(note): " + a.getNotes());
            a.addNotes("Note 2", "Nurse A");
            System.out.println("-- Appointment notes after addNotes(note,addedBy): " + a.getNotes());
            a.addNotes("Final note", "Dr. X", LocalDate.now().atStartOfDay());
            System.out.println("-- Appointment notes after addNotes(note,addedBy,timestamp): " + a.getNotes());
        }

        if (PatientService.patientList.size() >= 3 && DoctorService.doctorList.size() >= 3) {
            Appointment created1 = appointmentService.createAppointment(
                    PatientService.patientList.get(0).getPatientId(),
                    DoctorService.doctorList.get(0).getDoctorId(),
                    LocalDate.now().plusDays(2)
            );
            Appointment created2 = appointmentService.createAppointment(
                    PatientService.patientList.get(1).getPatientId(),
                    DoctorService.doctorList.get(1).getDoctorId(),
                    LocalDate.now().plusDays(3),
                    "11:30"
            );
            Appointment objApp = new Appointment();
            objApp.setPatientId(PatientService.patientList.get(2).getPatientId());
            objApp.setDoctorId(DoctorService.doctorList.get(2).getDoctorId());
            appointmentService.createAppointment(objApp);
        }

        System.out.println();
    }

    private void testInterfaceImplementations() {
        System.out.println("testInterfaceImplementations: call displaySummary/displayInfo for Displayable classes and billable where applicable");
        System.out.println("-- Display summaries for doctors:");
        for (Doctor d : DoctorService.doctorList) {
            d.displaySummary();
        }

        System.out.println("-- Display summaries for patients:");
        for (Patient p : PatientService.patientList) {
            p.displaySummary();
        }

        System.out.println("-- Display some medical record info:");
        if (!MedicalRecordService.recordList.isEmpty()) {
            MedicalRecordService.recordList.getFirst().displaySummary();
        }

        for (Patient p : PatientService.patientList) {
            if (p instanceof InPatient) {
                InPatient ip = (InPatient) p;
                System.out.println("-- Generating bill for inpatient " + ip.getPatientId());
                ip.generateBill();
            }
        }

        System.out.println();
    }

    private void testHelperUtils() {
        System.out.println("testHelperUtils: test HelperUtils.generateId and other utility checks");
        String id1 = HelperUtils.generateId("TST");
        String id2 = HelperUtils.generateId("TST");
        System.out.println("-- Generated IDs: " + id1 + ", " + id2);
        if (!AppointmentService.appointmentList.isEmpty()) {
            System.out.println("-- check appointment by id (sample): " + AppointmentService.checkById(AppointmentService.appointmentList.getFirst().getAppointmentId()));
        } else {
            System.out.println("-- No appointments to test checkById()");
        }
        System.out.println();
    }

    private void testInheritancePolymorphism() {
        System.out.println("testInheritancePolymorphism: verify polymorphic behavior across Patient and Doctor subclasses");

        System.out.println("-- Polymorphic displayInfo calls for patients:");
        for (Patient p : PatientService.patientList) {
            p.displayInfo();
            System.out.println("-----------------");
        }

        System.out.println("-- Doctor subclass methods (polymorphism):");
        for (Doctor d : DoctorService.doctorList) {
            d.displayInfo();
            if (d instanceof Surgeon) {
                ((Surgeon) d).performSurgery("Test Surgery");
            } else if (d instanceof GeneralPractitioner) {
                ((GeneralPractitioner) d).scheduleHomeVisit(PatientService.patientList.getFirst());
            } else if (d instanceof Consultant) {
                ((Consultant) d).provideSecondOpinion(PatientService.patientList.getFirst());
            }
            System.out.println("-----------------");
        }
        System.out.println();
    }
}