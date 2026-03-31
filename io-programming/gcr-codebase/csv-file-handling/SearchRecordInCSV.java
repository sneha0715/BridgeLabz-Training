import java.io.*;
import java.nio.file.*;
import java.util.*;

public class SearchRecordInCSV {

    public static void main(String[] args) {
        String filePath = "employees.csv";
        searchEmployeeByName(filePath, "Alice Johnson");
    }

    static void searchEmployeeByName(String filePath, String searchName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            
            boolean found = false;
            for (int i = 1; i < lines.size(); i++) {
                String[] fields = lines.get(i).split(",");
                
                if (fields[1].trim().equalsIgnoreCase(searchName)) {
                    System.out.println("Employee Found:");
                    System.out.println("ID: " + fields[0]);
                    System.out.println("Name: " + fields[1]);
                    System.out.println("Department: " + fields[2]);
                    System.out.println("Salary: " + fields[3]);
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                System.out.println("Employee '" + searchName + "' not found in the CSV file.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
