import java.io.*;

public class ConvertByteToCharStream {
    public static void readBinaryFile(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            
            System.out.println("File contents (UTF-8 encoded):");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            
            br.close();
            isr.close();
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== InputStreamReader: Convert Byte Stream to Character Stream ===");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            System.out.println("Enter the filename to read:");
            String filename = br.readLine();
            readBinaryFile(filename);
            br.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
