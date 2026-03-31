import java.util.Scanner;

public class IllegalArgumentExceptionDemo {
    
    public static void generateIllegalArgumentException() {
        String text = "hello";
        System.out.println(text.substring(5, 2));
    }
    
    public static void handleIllegalArgumentException(String text) {
        try {
            System.out.println("Attempting substring with start > end:");
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
            System.out.println("Start index cannot be greater than end index");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Demonstrating IllegalArgumentException ===\n");
        
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        
        System.out.println("\n1. Generating IllegalArgumentException (Unhandled):");
        try {
            generateIllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }
        
        System.out.println("\n2. Handling IllegalArgumentException (With try-catch):");
        handleIllegalArgumentException(text);
        
        System.out.println("\nProgram completed successfully!");
        
        sc.close();
    }
}
