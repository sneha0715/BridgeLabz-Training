import java.util.Scanner;

public class StringLengthWithoutMethod {
    
    public static int findStringLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = sc.next();
        
        int customLength = findStringLength(text);
        int builtInLength = text.length();
        
        System.out.println("\nOriginal string: " + text);
        System.out.println("Length using custom method: " + customLength);
        System.out.println("Length using length() method: " + builtInLength);
        
        if (customLength == builtInLength) {
            System.out.println("Both methods gave the same result!");
        } else {
            System.out.println("Results differ!");
        }
        
        sc.close();
    }
}
