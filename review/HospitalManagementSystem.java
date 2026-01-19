class Doctor {
  String name;

  Doctor(String name) {
    this.name = name;
  }

  public double consultationFee() {
    return 0;
  }
}

// Specialist Doctor
class SpecialistDoctor extends Doctor {

  SpecialistDoctor(String name) {
    super(name);
  }

  @Override
  public double consultationFee() {
    return 500;
  }
}

// General Doctor
class GeneralDoctor extends Doctor {

  GeneralDoctor(String name) {
    super(name);
  }

  @Override
  public double consultationFee() {
    return 300;
  }

}

// Surgeon Doctor
class SurgeonDoctor extends Doctor {

  SurgeonDoctor(String name) {
    super(name);
  }

  @Override
  public double consultationFee() {
    return 700;
  }
}

// Patient
class Patient {
  String patientId;
  String name;
  int age;
  String address;
  String phoneNumber;
  String email;

  Patient(String patientId, String name, int age, String address, String phoneNumber, String email) {
    this.patientId = patientId;
    this.name = name;
    this.age = age;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.email = email;
  }

  public void displayPatientDetails() {
    System.out.println("Patient ID: " + patientId);
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Address: " + address);
    System.out.println("Phone Number: " + phoneNumber);
    System.out.println("Email: " + email);
  }
}

// Fee
class Fee extends Patient {
  double amount;
  String paymentMethod;

  Fee(String patientId, String name, int age, String address, String phoneNumber, String email, double amount,
      String paymentMethod) {
    super(patientId, name, age, address, phoneNumber, email);
    this.amount = amount;
    this.paymentMethod = paymentMethod;
  }

  public void displayFeeDetails() {
    System.out.println("Fee Amount: " + amount);
    System.out.println("Payment Method: " + paymentMethod);
  }

}

public class HospitalManagementSystem {
  public static void main(String[] args) {
    System.out.println("--------Hospital Management System--------");
    System.out.print("Specialization Doctor: ");
    SpecialistDoctor doc1 = new SpecialistDoctor("Dr. Smith");
    System.out.println(doc1.name + " Consultation Fee: $" + doc1.consultationFee());
    System.out.println();
    System.out.println("General Doctor: ");
    GeneralDoctor doc2 = new GeneralDoctor("Dr. Johnson");
    System.out.println(doc2.name + " Consultation Fee: $" + doc2.consultationFee());
    System.out.println();
    System.out.println("Surgeon Doctor: ");
    SurgeonDoctor doc3 = new SurgeonDoctor("Dr. Williams");
    System.out.println(doc3.name + " Consultation Fee: $" + doc3.consultationFee());
    System.out.println();

    System.out.println("--------Patient and Fee Details--------");
    Fee fee1 = new Fee("P001", "Alice", 30, "123 Main St", "555-1234", "alice@example.com", 500.0, "Credit Card");
    fee1.displayPatientDetails();
    fee1.displayFeeDetails();
  }
}
