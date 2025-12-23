import java.util.Scanner;

public class StringIndexOutOfBoundsExceptionDemo {
    
    public static void generateStringIndexOutOfBoundsException() {
        String text = "hello";
        System.out.println(text.charAt(10));
    }
    
    public static void handleStringIndexOutOfBoundsException(String text) {
        try {
            System.out.println("Accessing index beyond string length:");
            System.out.println(text.charAt(10));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
            System.out.println("Index 10 is beyond string length of " + text.length());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Demonstrating StringIndexOutOfBoundsException ===\n");
        
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        
        System.out.println("\n1. Generating StringIndexOutOfBoundsException (Unhandled):");
        try {
            generateStringIndexOutOfBoundsException();
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }
        
        System.out.println("\n2. Handling StringIndexOutOfBoundsException (With try-catch):");
        handleStringIndexOutOfBoundsException(text);
        
        System.out.println("\nProgram completed successfully!");
        
        sc.close();
    }
}
