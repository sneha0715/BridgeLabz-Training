import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyProgram {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destinationFile);

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("Source file not found or error occurred while handling files.");
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error while closing files.");
            }
        }
    }
}
