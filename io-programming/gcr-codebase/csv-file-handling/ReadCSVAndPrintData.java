import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ReadCSVAndPrintData {

    public static void main(String[] args) {
        String filePath = "io-programming\\gcr-codebase\\csv-file-handling\\student_details.csv";
        readAndPrintStudentData(filePath);
    }

    static void readAndPrintStudentData(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            
            if (lines.isEmpty()) {
                System.out.println("File is empty");
                return;
            }

            System.out.println("Student Details:");
            System.out.println("================================================");
            
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] fields = line.split(",");
                
                if (i == 0) {
                    System.out.printf("%-8s %-20s %-8s %-10s%n", 
                        fields[0], fields[1], fields[2], fields[3]);
                    System.out.println("================================================");
                } else {
                    System.out.printf("%-8s %-20s %-8s %-10s%n", 
                        fields[0], fields[1], fields[2], fields[3]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
