import java.util.Scanner;

public class KmToMile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter distance in kilometers: ");
        double kilometers = scanner.nextDouble();
        double miles = kilometers * 0.621371; // Conversion factor
        System.out.println(kilometers + " kilometers is equal to " + miles + " miles.");
    }
}
