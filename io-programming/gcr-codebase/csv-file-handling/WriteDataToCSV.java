import java.io.*;
import java.nio.file.*;
import java.util.*;

public class WriteDataToCSV {

    public static void main(String[] args) {
        String filePath = "employees.csv";
        writeEmployeeData(filePath);
    }

    static void writeEmployeeData(String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("ID,Name,Department,Salary");
            writer.println("101,Alice Johnson,HR,50000");
            writer.println("102,Bob Smith,IT,75000");
            writer.println("103,Carol White,Finance,65000");
            writer.println("104,David Brown,IT,80000");
            writer.println("105,Emma Davis,Marketing,55000");
            
            System.out.println("Employee data written successfully to " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
