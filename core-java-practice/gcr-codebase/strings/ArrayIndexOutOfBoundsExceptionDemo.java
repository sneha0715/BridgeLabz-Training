import java.util.Scanner;

public class ArrayIndexOutOfBoundsExceptionDemo {
    
    public static void generateArrayIndexOutOfBoundsException() {
        String[] names = {"Alice", "Bob", "Charlie"};
        System.out.println(names[10]);
    }
    
    public static void handleArrayIndexOutOfBoundsException(String[] names) {
        try {
            System.out.println("Attempting to access index beyond array length:");
            System.out.println(names[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
            System.out.println("Index 10 is beyond array length of " + names.length);
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Demonstrating ArrayIndexOutOfBoundsException ===\n");
        
        System.out.print("Enter number of names: ");
        int count = sc.nextInt();
        sc.nextLine();
        
        String[] names = new String[count];
        
        System.out.println("Enter " + count + " names:");
        for (int i = 0; i < count; i++) {
            System.out.print("Name " + (i + 1) + ": ");
            names[i] = sc.nextLine();
        }
        
        System.out.println("\n1. Generating ArrayIndexOutOfBoundsException (Unhandled):");
        try {
            generateArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }
        
        System.out.println("\n2. Handling ArrayIndexOutOfBoundsException (With try-catch):");
        handleArrayIndexOutOfBoundsException(names);
        
        System.out.println("\nProgram completed successfully!");
    }
}
