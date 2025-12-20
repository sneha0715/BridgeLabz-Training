import java.util.Scanner;

public class MayaBMIFitnessTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Maya's BMI Fitness Tracker");
        System.out.print("Enter height (in meters): ");
        double height = sc.nextDouble();

        System.out.print("Enter weight (in kg): ");
        double weight = sc.nextDouble();

        double bmi = weight / (height * height);

        System.out.println("\nBMI: " + String.format("%.2f", bmi));

        if (bmi < 18.5) {
            System.out.println("Category: Underweight");
        } else if (bmi < 25.0) {
            System.out.println("Category: Normal");
        } else if (bmi < 30.0) {
            System.out.println("Category: Overweight");
        } else {
            System.out.println("Category: Obese");
        }
    }
}
