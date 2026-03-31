import java.util.Scanner;

public class CollinearPointsChecker {

    public static boolean checkCollinearUsingSlope(double x1, double y1, double x2, double y2, double x3, double y3) {
        
        double slopeAB = (y2 - y1) / (x2 - x1);
       
        double slopeBC = (y3 - y2) / (x3 - x2);
        
        double slopeAC = (y3 - y1) / (x3 - x1);

        return (slopeAB == slopeBC) && (slopeBC == slopeAC);
    }

    public static boolean checkCollinearUsingArea(double x1, double y1, double x2, double y2, double x3, double y3) {

        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        
        return area == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter coordinates for Point A (x1 y1): ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        System.out.println("Enter coordinates for Point B (x2 y2): ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        System.out.println("Enter coordinates for Point C (x3 y3): ");
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();

        System.out.println("\n--- Results ---");
        
        boolean isCollinearSlope = checkCollinearUsingSlope(x1, y1, x2, y2, x3, y3);
        System.out.println("Collinear using Slope Formula: " + isCollinearSlope);

        boolean isCollinearArea = checkCollinearUsingArea(x1, y1, x2, y2, x3, y3);
        System.out.println("Collinear using Area Formula: " + isCollinearArea);

        if (isCollinearSlope && isCollinearArea) {
            System.out.println("\nConclusion: The points are Collinear.");
        } else {
            System.out.println("\nConclusion: The points are NOT Collinear.");
        }

        sc.close();
    }
}