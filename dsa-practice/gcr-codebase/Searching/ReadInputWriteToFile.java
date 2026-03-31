import java.io.*;

public class ReadInputWriteToFile {
    public static void readFromConsoleWriteToFile(String outputFilename) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            FileWriter fw = new FileWriter(outputFilename);
            
            System.out.println("Enter text (type 'exit' to stop):");
            String input;
            
            while ((input = br.readLine()) != null) {
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                fw.write(input + "\n");
            }
            
            fw.close();
            br.close();
            isr.close();
            System.out.println("Data written to file successfully!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== InputStreamReader: Read Console Input and Write to File ===");
        System.out.println("Enter the output filename:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            String filename = br.readLine();
            readFromConsoleWriteToFile(filename);
            br.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
