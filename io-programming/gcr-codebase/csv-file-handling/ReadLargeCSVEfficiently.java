import java.io.*;
import java.nio.file.*;

public class ReadLargeCSVEfficiently {

    public static void main(String[] args) {
        String filePath = "io-programming\\gcr-codebase\\csv-file-handling\\large_dataset.csv";
        readCSVInChunks(filePath, 100);
    }

    static void readCSVInChunks(String filePath, int chunkSize) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int recordCount = 0;
            int totalRecords = 0;
            int chunkNumber = 1;

            line = reader.readLine();
            if (line != null) {
                recordCount = 1;
            }

            while ((line = reader.readLine()) != null) {
                recordCount++;
                totalRecords++;

                if (recordCount == chunkSize) {
                    System.out.println("Chunk " + chunkNumber + ": Processed " + recordCount + " records");
                    recordCount = 0;
                    chunkNumber++;
                }
            }

            if (recordCount > 0) {
                System.out.println("Chunk " + chunkNumber + ": Processed " + recordCount + " records");
            }

            System.out.println("Total records processed: " + totalRecords);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
