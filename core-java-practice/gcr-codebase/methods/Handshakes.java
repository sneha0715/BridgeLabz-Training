import java.util.Scanner;

public class Handshakes {
    
    public static int calculateHandshakes(int numberOfStudents) {
        return (numberOfStudents * (numberOfStudents - 1)) / 2;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int numberOfStudents = sc.nextInt();
        
        if (numberOfStudents < 0) {
            System.out.println("Invalid input. Please enter a non-negative number.");
            sc.close();
            return;
        }
        
        int handshakes = calculateHandshakes(numberOfStudents);
        System.out.println("Maximum number of handshakes: " + handshakes);
        
        sc.close();
    }
}
