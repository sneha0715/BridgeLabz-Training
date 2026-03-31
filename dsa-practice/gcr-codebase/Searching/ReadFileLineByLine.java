import java.io.*;

public class ReadFileLineByLine {
    public static void readFile(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line;
            int lineNumber = 1;
            
            while ((line = br.readLine()) != null) {
                System.out.println("Line " + lineNumber + ": " + line);
                lineNumber++;
            }
            
            br.close();
            fr.close();
            System.out.println("\nFile read successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== FileReader: Read File Line by Line ===");
        System.out.println("Enter the filename to read:");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String filename = br.readLine();
            readFile(filename);
            br.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
