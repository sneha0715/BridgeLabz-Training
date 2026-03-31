import java.io.*;
import java.nio.charset.StandardCharsets;

public class LowercaseFileCopy {
    public static void main(String[] args) {
        String sourceFile = "input.txt";
        String destinationFile = "output.txt";

        try (
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(sourceFile), StandardCharsets.UTF_8)
            );
            BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(destinationFile), StandardCharsets.UTF_8)
            )
        ) {
            int ch;
            while ((ch = reader.read()) != -1) {
                writer.write(Character.toLowerCase(ch));
            }
            System.out.println("File converted to lowercase successfully.");
        } catch (IOException e) {
            System.out.println("Error processing file.");
        }
    }
}
