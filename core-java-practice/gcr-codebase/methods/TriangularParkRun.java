import java.util.Scanner;

public class TriangularParkRun {
    
    public static int calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        int distance = 5000;
        return (int) (distance / perimeter);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter side 1 of triangle (in meters): ");
        double side1 = sc.nextDouble();
        
        System.out.print("Enter side 2 of triangle (in meters): ");
        double side2 = sc.nextDouble();
        
        System.out.print("Enter side 3 of triangle (in meters): ");
        double side3 = sc.nextDouble();
        
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            System.out.println("Invalid input. All sides must be positive.");
            sc.close();
            return;
        }
        
        int rounds = calculateRounds(side1, side2, side3);
        System.out.println("Number of rounds required to complete 5 km run: " + rounds);
        
        sc.close();
    }
}
