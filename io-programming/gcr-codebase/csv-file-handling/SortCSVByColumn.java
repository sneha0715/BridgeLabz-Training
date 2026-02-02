import java.io.*;
import java.nio.file.*;
import java.util.*;

public class SortCSVByColumn {

    public static void main(String[] args) {
        String filePath = "employees.csv";
        sortAndPrintTopPaidEmployees(filePath, 5);
    }

    static void sortAndPrintTopPaidEmployees(String filePath, int limit) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            
            if (lines.size() <= 1) {
                System.out.println("No data to display");
                return;
            }

            List<EmployeeRecord> employees = new ArrayList<>();
            
            for (int i = 1; i < lines.size(); i++) {
                String[] fields = lines.get(i).split(",");
                employees.add(new EmployeeRecord(
                    fields[0].trim(),
                    fields[1].trim(),
                    fields[2].trim(),
                    Double.parseDouble(fields[3].trim())
                ));
            }

            employees.sort((a, b) -> Double.compare(b.salary, a.salary));

            System.out.println("Top " + limit + " Highest-Paid Employees:");
            System.out.println("================================================");
            System.out.printf("%-8s %-20s %-15s %-12s%n", "ID", "Name", "Department", "Salary");
            System.out.println("================================================");

            for (int i = 0; i < Math.min(limit, employees.size()); i++) {
                EmployeeRecord emp = employees.get(i);
                System.out.printf("%-8s %-20s %-15s %-12.2f%n", 
                    emp.id, emp.name, emp.department, emp.salary);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    static class EmployeeRecord {
        String id, name, department;
        double salary;

        EmployeeRecord(String id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
    }
}
