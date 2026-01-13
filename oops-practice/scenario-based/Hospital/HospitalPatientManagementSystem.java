package Hospital;

import java.util.ArrayList;

interface IPayable {
    double calculateBill();
}

class Patient implements IPayable {
    protected String patientId;
    protected String name;
    protected int age;
    protected String disease;
    protected double consultationFee;
    
    public Patient(String patientId, String name, int age, String disease, double consultationFee) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.consultationFee = consultationFee;
    }
    
    @Override
    public double calculateBill() {
        return consultationFee;
    }
    
    public void displayInfo() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Age: " + age + 
                         ", Disease: " + disease + ", Consultation Fee: " + consultationFee);
    }
}

class InPatient extends Patient {
    private int daysAdmitted;
    private double roomChargePerDay;
    
    public InPatient(String patientId, String name, int age, String disease, 
                     double consultationFee, int daysAdmitted, double roomChargePerDay) {
        super(patientId, name, age, disease, consultationFee);
        this.daysAdmitted = daysAdmitted;
        this.roomChargePerDay = roomChargePerDay;
    }
    
    @Override
    public double calculateBill() {
        return consultationFee + (daysAdmitted * roomChargePerDay);
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: InPatient, Days Admitted: " + daysAdmitted + 
                         ", Room Charge/Day: " + roomChargePerDay + 
                         ", Total Bill: " + calculateBill());
    }
}

class OutPatient extends Patient {
    private double medicationCost;
    
    public OutPatient(String patientId, String name, int age, String disease, 
                      double consultationFee, double medicationCost) {
        super(patientId, name, age, disease, consultationFee);
        this.medicationCost = medicationCost;
    }
    
    @Override
    public double calculateBill() {
        return consultationFee + medicationCost;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: OutPatient, Medication Cost: " + medicationCost + 
                         ", Total Bill: " + calculateBill());
    }
}

class Doctor {
    String doctorId;
    String name;
    String specialty;
    
    public Doctor(String doctorId, String name, String specialty) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialty = specialty;
    }
    
    public void displayInfo() {
        System.out.println("Doctor ID: " + doctorId + ", Name: " + name + ", Specialty: " + specialty);
    }
}

class Bill {
    String billId;
    Patient patient;
    Doctor doctor;
    double billAmount;
    
    public Bill(String billId, Patient patient, Doctor doctor, double billAmount) {
        this.billId = billId;
        this.patient = patient;
        this.doctor = doctor;
        this.billAmount = billAmount;
    }
    
    public void displayBill() {
        System.out.println("\n========== Bill ==========");
        System.out.println("Bill ID: " + billId);
        System.out.println("Patient: " + patient.name + " (ID: " + patient.patientId + ")");
        System.out.println("Doctor: " + doctor.name + " (Specialty: " + doctor.specialty + ")");
        System.out.println("Amount: ₹" + billAmount);
        System.out.println("========================");
    }
}

public class HospitalPatientManagementSystem {
    static ArrayList<Patient> patients = new ArrayList<Patient>();
    static ArrayList<Doctor> doctors = new ArrayList<Doctor>();
    static ArrayList<Bill> bills = new ArrayList<Bill>();
    
    public static void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient added successfully!");
    }
    
    public static void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Doctor added successfully!");
    }
    
    public static void createBill(String billId, Patient patient, Doctor doctor) {
        double billAmount = patient.calculateBill();
        Bill bill = new Bill(billId, patient, doctor, billAmount);
        bills.add(bill);
        bill.displayBill();
    }
    
    public static void displayAllPatients() {
        System.out.println("\n========== All Patients ==========");
        for (Patient p : patients) {
            p.displayInfo();
            System.out.println();
        }
    }
    
    public static void displayAllDoctors() {
        System.out.println("\n========== All Doctors ==========");
        for (Doctor d : doctors) {
            d.displayInfo();
        }
        System.out.println();
    }
    
    public static void displayAllBills() {
        System.out.println("\n========== All Bills ==========");
        for (Bill b : bills) {
            b.displayBill();
        }
    }
    
    public static void main(String[] args) {
        addDoctor(new Doctor("D001", "Dr. Sharma", "Cardiology"));
        addDoctor(new Doctor("D002", "Dr. Patel", "Orthopedics"));
        
        Patient inPatient1 = new InPatient("P001", "Rajesh", 45, "Heart Disease", 5000, 5, 2000);
        Patient outPatient1 = new OutPatient("P002", "Priya", 35, "Flu", 1000, 500);
        Patient inPatient2 = new InPatient("P003", "Vikas", 55, "Fracture", 3000, 3, 1500);
        
        addPatient(inPatient1);
        addPatient(outPatient1);
        addPatient(inPatient2);
        
        createBill("B001", inPatient1, doctors.get(0));
        createBill("B002", outPatient1, doctors.get(0));
        createBill("B003", inPatient2, doctors.get(1));
        
        displayAllPatients();
        displayAllDoctors();
        displayAllBills();
    }
}
