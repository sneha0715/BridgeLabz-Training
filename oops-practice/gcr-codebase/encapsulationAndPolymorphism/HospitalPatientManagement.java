import java.util.*;

public class HospitalPatientManagement {

    public static void main(String[] args) {

        List<Patient> patients = new ArrayList<>();

        patients.add(new InPatient("P101", "Amit", 35, 5, 2000));
        patients.add(new OutPatient("P202", "Neha", 28, 800));

        for (Patient p : patients) {

            p.getPatientDetails();
            System.out.println("Total Bill: " + p.calculateBill());

            MedicalRecord m = (MedicalRecord) p;
            m.addRecord("Routine checkup");
            m.viewRecords();

        }
    }
}

abstract class Patient {

    private String patientId;
    private String name;
    private int age;

    private String diagnosis;
    private List<String> medicalHistory = new ArrayList<>();

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    protected void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    protected String getDiagnosis() {
        return diagnosis;
    }

    protected List<String> getMedicalHistory() {
        return medicalHistory;
    }
}

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

class InPatient extends Patient implements MedicalRecord {

    private int daysAdmitted;
    private double dailyCharge;

    public InPatient(String id, String name, int age, int days, double charge) {
        super(id, name, age);
        this.daysAdmitted = days;
        this.dailyCharge = charge;
    }

    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    public void addRecord(String record) {
        getMedicalHistory().add(record);
    }

    public void viewRecords() {
        System.out.println("Medical Records: " + getMedicalHistory());
    }
}

class OutPatient extends Patient implements MedicalRecord {

    private double consultationFee;

    public OutPatient(String id, String name, int age, double fee) {
        super(id, name, age);
        this.consultationFee = fee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String record) {
        getMedicalHistory().add(record);
    }

    public void viewRecords() {
        System.out.println("Medical Records: " + getMedicalHistory());
    }
}
