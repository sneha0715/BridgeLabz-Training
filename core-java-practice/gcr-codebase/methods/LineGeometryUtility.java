import java.util.Scanner;

public class LineGeometryUtility {

    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double[] calculateLineEquation(double x1, double y1, double x2, double y2) {
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;
        
        return new double[]{m, b};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter coordinates for Point 1 (x1 y1): ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        System.out.println("Enter coordinates for Point 2 (x2 y2): ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        double distance = calculateDistance(x1, y1, x2, y2);
        
        double[] lineParams = calculateLineEquation(x1, y1, x2, y2);
        double slope = lineParams[0];
        double yIntercept = lineParams[1];

        System.out.println("\n--- Geometry Results ---");
        System.out.printf("Euclidean Distance: %.4f\n", distance);
        System.out.printf("Slope (m): %.4f\n", slope);
        System.out.printf("Y-Intercept (b): %.4f\n", yIntercept);
        System.out.printf("Equation of the line: y = %.2fx + %.2f\n", slope, yIntercept);

        sc.close();
    }
}