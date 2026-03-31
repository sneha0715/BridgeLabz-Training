import java.io.*;
import java.nio.file.*;
import java.util.*;

public class MergeTwoCSVFiles {

    static class StudentMerged {
        int id;
        String name;
        int age;
        int marks;
        String grade;

        StudentMerged(int id, String name, int age, int marks, String grade) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.marks = marks;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return String.format("%d,%s,%d,%d,%s", id, name, age, marks, grade);
        }
    }

    public static void main(String[] args) {
        String file1 = "io-programming\\gcr-codebase\\csv-file-handling\\students1.csv";
        String file2 = "io-programming\\gcr-codebase\\csv-file-handling\\students2.csv";
        String outputFile = "io-programming\\gcr-codebase\\csv-file-handling\\students_merged.csv";
        
        mergeCSVFiles(file1, file2, outputFile);
    }

    static void mergeCSVFiles(String file1, String file2, String outputFile) {
        try {
            Map<Integer, Map<String, String>> mergedData = new HashMap<>();

            List<String> lines1 = Files.readAllLines(Paths.get(file1));
            for (int i = 1; i < lines1.size(); i++) {
                String[] fields = lines1.get(i).split(",");
                int id = Integer.parseInt(fields[0].trim());
                Map<String, String> record = new HashMap<>();
                record.put("id", fields[0].trim());
                record.put("name", fields[1].trim());
                record.put("age", fields[2].trim());
                mergedData.put(id, record);
            }

            List<String> lines2 = Files.readAllLines(Paths.get(file2));
            for (int i = 1; i < lines2.size(); i++) {
                String[] fields = lines2.get(i).split(",");
                int id = Integer.parseInt(fields[0].trim());
                
                if (mergedData.containsKey(id)) {
                    mergedData.get(id).put("marks", fields[1].trim());
                    mergedData.get(id).put("grade", fields[2].trim());
                }
            }

            try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
                writer.println("ID,Name,Age,Marks,Grade");
                
                for (int id : mergedData.keySet()) {
                    Map<String, String> record = mergedData.get(id);
                    if (record.containsKey("marks")) {
                        String line = String.format("%s,%s,%s,%s,%s",
                            record.get("id"), record.get("name"), 
                            record.get("age"), record.get("marks"), record.get("grade"));
                        writer.println(line);
                    }
                }
            }

            System.out.println("Files merged successfully. Output: " + outputFile);
        } catch (IOException e) {
            System.out.println("Error processing files: " + e.getMessage());
        }
    }
}
