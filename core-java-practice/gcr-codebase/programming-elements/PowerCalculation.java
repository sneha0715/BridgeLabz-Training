import java.util.Scanner;

public class PowerCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the base: "); 
        double base = scanner.nextDouble();
        System.out.print("Enter the exponent: ");

        double exponent = scanner.nextDouble();
        // Calculate power
        double result = Math.pow(base, exponent);
        System.out.println("The result of power is: " + result);
    }
}
