import java.util.*;

class Patient implements Comparable<Patient> {
    private String name;
    private int severity;
    
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
    
    public int getSeverity() {
        return severity;
    }
    
    public String getName() {
        return name;
    }
    
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity);
    }
    
    public String toString() {
        return name + " (severity: " + severity + ")";
    }
}

public class HospitalTriageSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Hospital Triage System ===");
        System.out.println("Enter number of patients:");
        int n = sc.nextInt();
        sc.nextLine();
        
        PriorityQueue<Patient> patientQueue = new PriorityQueue<>();
        
        System.out.println("Enter patient details (name severity):");
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int severity = sc.nextInt();
            patientQueue.add(new Patient(name, severity));
        }
        
        System.out.println("\nTreatment Order (highest severity first):");
        while (!patientQueue.isEmpty()) {
            System.out.println(patientQueue.poll());
        }
        
        sc.close();
    }
}
