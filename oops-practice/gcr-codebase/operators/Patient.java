public class Patient {


    static String hospitalName = "City Hospital";
    static int patientCount = 0;
    String name;
    int age;
    String ailment;
    final String patientID;

    public Patient(String patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        patientCount++;
    }

    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + patientCount);
        System.out.println("Hospital Name: " + hospitalName);
    }

    public static void displayPatientDetails(Object obj) {
        if (obj instanceof Patient) {
            Patient p = (Patient) obj;
            System.out.println("Patient ID: " + p.patientID);
            System.out.println("Name: " + p.name);
            System.out.println("Age: " + p.age);
            System.out.println("Ailment: " + p.ailment);
        }
    }

    public static void main(String[] args) {

        Patient patient1 = new Patient(
                "P001",
                "Lathika",
                30,
                "Flu"
        );

        Patient patient2 = new Patient(
                "P002",
                "Lidiya",
                45,
                "Fracture"
        );

        getTotalPatients();

        displayPatientDetails(patient1);
        System.out.println("Hospital Name: " + hospitalName);

        displayPatientDetails(patient2);
    }
}
