import java.util.Scanner;

public class NullPointerExceptionDemo {
    
    public static void generateNullPointerException() {
        String text = null;
        System.out.println(text.length());
    }
    
    public static void handleNullPointerException() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
            System.out.println("Cannot call method on null object");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Demonstrating NullPointerException ===\n");
        
        System.out.println("1. Generating NullPointerException (Unhandled):");
        try {
            generateNullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }
        
        System.out.println("\n2. Handling NullPointerException (With try-catch):");
        handleNullPointerException();
        
        System.out.println("\nProgram completed successfully!");
    }
}
