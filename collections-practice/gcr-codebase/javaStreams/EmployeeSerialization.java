import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return id + " " + name + " " + department + " " + salary;
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {
        String fileName = "employees.ser";

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Amit", "IT", 60000));
        employees.add(new Employee(2, "Sneha", "HR", 50000));
        employees.add(new Employee(3, "Rahul", "Finance", 55000));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employees);
            System.out.println("Employees saved.");
        } catch (IOException e) {
            System.out.println("Error during serialization.");
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Employee> retrieved = (List<Employee>) ois.readObject();
            System.out.println("Employees retrieved:");
            for (Employee emp : retrieved) {
                System.out.println(emp);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization.");
        }
    }
}
