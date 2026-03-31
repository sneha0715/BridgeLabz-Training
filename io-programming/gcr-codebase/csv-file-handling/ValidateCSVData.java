import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class ValidateCSVData {

    static class ValidationResult {
        int rowNumber;
        String errorMessage;

        ValidationResult(int rowNumber, String errorMessage) {
            this.rowNumber = rowNumber;
            this.errorMessage = errorMessage;
        }
    }

    public static void main(String[] args) {
        String filePath = "contacts.csv";
        validateCSVData(filePath);
    }

    static void validateCSVData(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            List<ValidationResult> errors = new ArrayList<>();

            Pattern emailPattern = Pattern.compile(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
            );
            Pattern phonePattern = Pattern.compile("^\\d{10}$");

            for (int i = 1; i < lines.size(); i++) {
                String[] fields = lines.get(i).split(",");

                if (fields.length < 3) {
                    errors.add(new ValidationResult(i + 1, "Insufficient fields"));
                    continue;
                }

                String email = fields[1].trim();
                String phone = fields[2].trim();

                if (!emailPattern.matcher(email).matches()) {
                    errors.add(new ValidationResult(i + 1, 
                        "Invalid email format: " + email));
                }

                if (!phonePattern.matcher(phone).matches()) {
                    errors.add(new ValidationResult(i + 1, 
                        "Invalid phone number: " + phone));
                }
            }

            if (errors.isEmpty()) {
                System.out.println("All records are valid.");
            } else {
                System.out.println("Validation Errors:");
                System.out.println("================================================");
                for (ValidationResult error : errors) {
                    System.out.println("Row " + error.rowNumber + ": " + error.errorMessage);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
