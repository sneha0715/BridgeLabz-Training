import java.util.*;

public class BinaryNumberGenerator {
    
    public static List<String> generateBinaryNumbers(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        
        for (int i = 0; i < n; i++) {
            String current = queue.remove();
            result.add(current);
            queue.add(current + "0");
            queue.add(current + "1");
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Generate Binary Numbers Using Queue ===");
        System.out.println("Enter N (number of binary numbers to generate):");
        int n = sc.nextInt();
        
        List<String> binaryNumbers = generateBinaryNumbers(n);
        System.out.println("First " + n + " binary numbers: " + binaryNumbers);
        
        sc.close();
    }
}
