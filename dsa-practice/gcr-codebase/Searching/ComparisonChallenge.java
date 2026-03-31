import java.io.*;

public class ComparisonChallenge {
    
    public static void testStringOperations() {
        System.out.println("=== Testing StringBuilder and StringBuffer ===");
        
        StringBuilder sb = new StringBuilder();
        long sbStart = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            sb.append("hello");
        }
        long sbEnd = System.nanoTime();
        
        StringBuffer sbf = new StringBuffer();
        long sbfStart = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            sbf.append("hello");
        }
        long sbfEnd = System.nanoTime();
        
        System.out.println("StringBuilder Time: " + (sbEnd - sbStart) / 1000000 + " ms");
        System.out.println("StringBuffer Time: " + (sbfEnd - sbfStart) / 1000000 + " ms");
    }
    
    public static void testFileReading(String filename) {
        System.out.println("\n=== Testing FileReader and InputStreamReader ===");
        
        int fileReaderWords = 0;
        long frStart = System.nanoTime();
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                fileReaderWords += line.split("\\s+").length;
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error with FileReader: " + e.getMessage());
        }
        long frEnd = System.nanoTime();
        
        int isrWords = 0;
        long isrStart = System.nanoTime();
        try {
            FileInputStream fis = new FileInputStream(filename);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                isrWords += line.split("\\s+").length;
            }
            br.close();
            isr.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("Error with InputStreamReader: " + e.getMessage());
        }
        long isrEnd = System.nanoTime();
        
        System.out.println("FileReader - Words: " + fileReaderWords + ", Time: " + (frEnd - frStart) / 1000000 + " ms");
        System.out.println("InputStreamReader - Words: " + isrWords + ", Time: " + (isrEnd - isrStart) / 1000000 + " ms");
    }

    public static void main(String[] args) {
        System.out.println("=== Challenge Problem: Comparison of All Components ===\n");
        
        testStringOperations();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter the filename to test FileReader and InputStreamReader:");
        try {
            String filename = br.readLine();
            testFileReading(filename);
            br.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
