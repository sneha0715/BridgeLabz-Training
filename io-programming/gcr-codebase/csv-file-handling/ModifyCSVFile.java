import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ModifyCSVFile {

    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "employees_updated.csv";
        updateSalaryForDepartment(inputFile, outputFile, "IT", 10);
    }

    static void updateSalaryForDepartment(String inputFile, String outputFile, 
                                          String department, int percentageIncrease) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(inputFile));
            
            try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
                for (int i = 0; i < lines.size(); i++) {
                    String line = lines.get(i);
                    
                    if (i == 0) {
                        writer.println(line);
                    } else {
                        String[] fields = line.split(",");
                        
                        if (fields[2].trim().equalsIgnoreCase(department)) {
                            double salary = Double.parseDouble(fields[3].trim());
                            double newSalary = salary * (1 + percentageIncrease / 100.0);
                            fields[3] = String.format("%.2f", newSalary);
                        }
                        
                        writer.println(String.join(",", fields));
                    }
                }
            }
            
            System.out.println("Updated CSV file saved to: " + outputFile);
        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}
