import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int numberOfPersons = sc.nextInt();
        
        double[] weights = new double[numberOfPersons];
        double[] heights = new double[numberOfPersons];
        double[] bmis = new double[numberOfPersons];
        String[] statuses = new String[numberOfPersons];
        
        System.out.println("\nEnter weight (in kg) and height (in meters) for each person:");
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.print("Person " + (i + 1) + " weight (kg): ");
            weights[i] = sc.nextDouble();
            
            System.out.print("Person " + (i + 1) + " height (m): ");
            heights[i] = sc.nextDouble();
        }
        
        for (int i = 0; i < numberOfPersons; i++) {
            bmis[i] = weights[i] / (heights[i] * heights[i]);
            
            if (bmis[i] <= 18.4) {
                statuses[i] = "Underweight";
            } else if (bmis[i] >= 18.5 && bmis[i] <= 24.9) {
                statuses[i] = "Normal";
            } else if (bmis[i] >= 25.0 && bmis[i] <= 39.9) {
                statuses[i] = "Overweight";
            } else if (bmis[i] >= 40.0) {
                statuses[i] = "Obese";
            }
        }
        
        System.out.println("\n========== BMI Report ==========");
        System.out.println("Person\tWeight(kg)\tHeight(m)\tBMI\t\tStatus");
        System.out.println("======================================================================");
        
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.println((i + 1) + "\t" + weights[i] + "\t\t" + heights[i] + "\t\t" + 
                             String.format("%.2f", bmis[i]) + "\t\t" + statuses[i]);
        }
        
        sc.close();
    }
}
