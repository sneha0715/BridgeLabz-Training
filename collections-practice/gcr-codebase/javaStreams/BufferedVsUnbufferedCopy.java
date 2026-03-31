import java.io.*;

public class BufferedVsUnbufferedCopy {
    public static void main(String[] args) {
        String source = "largefile.dat";
        String destBuffered = "bufferedCopy.dat";
        String destUnbuffered = "unbufferedCopy.dat";

        copyWithBuffer(source, destBuffered);
        copyWithoutBuffer(source, destUnbuffered);
    }

    static void copyWithBuffer(String source, String dest) {
        long start = System.nanoTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Buffered copy failed: " + e.getMessage());
            return;
        }

        long end = System.nanoTime();
        System.out.println("Buffered Stream Time: " + (end - start) + " ns");
    }

    static void copyWithoutBuffer(String source, String dest) {
        long start = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Unbuffered copy failed: " + e.getMessage());
            return;
        }

        long end = System.nanoTime();
        System.out.println("Unbuffered Stream Time: " + (end - start) + " ns");
    }
}
