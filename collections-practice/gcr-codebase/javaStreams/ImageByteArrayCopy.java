import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ImageByteArrayCopy {
    public static void main(String[] args) {
        String sourceImage = "input.jpg";
        String outputImage = "output.jpg";

        try {
            byte[] originalBytes = Files.readAllBytes(Paths.get(sourceImage));

            ByteArrayInputStream bais = new ByteArrayInputStream(originalBytes);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = bais.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] newImageBytes = baos.toByteArray();

            FileOutputStream fos = new FileOutputStream(outputImage);
            fos.write(newImageBytes);
            fos.close();

            if (Arrays.equals(originalBytes, newImageBytes)) {
                System.out.println("The new image file is identical to the original.");
            } else {
                System.out.println("The files are different.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred while processing the image file.");
        }
    }
}
