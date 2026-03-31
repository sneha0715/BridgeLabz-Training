import java.util.Scanner;

public class NumberFormatExceptionDemo {
    
    public static void generateNumberFormatException() {
        String text = "abc123";
        System.out.println(Integer.parseInt(text));
    }
    
    public static void handleNumberFormatException(String text) {
        try {
            System.out.println("Attempting to parse non-numeric string:");
            int number = Integer.parseInt(text);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
            System.out.println("String '" + text + "' cannot be converted to integer");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Demonstrating NumberFormatException ===\n");
        
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        
        System.out.println("\n1. Generating NumberFormatException (Unhandled):");
        try {
            generateNumberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }
        
        System.out.println("\n2. Handling NumberFormatException (With try-catch):");
        handleNumberFormatException(text);
        
        System.out.println("\nProgram completed successfully!");
        
        sc.close();
    }
}
