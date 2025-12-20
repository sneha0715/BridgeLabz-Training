import java.util.Scanner;

public class BMICalculatorMultiDimensional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();
        
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];
        
        System.out.println("\nEnter weight (in kg) and height (in meters) for each person:");
        for (int i = 0; i < number; i++) {
            boolean validInput = false;
            
            while (!validInput) {
                System.out.print("Person " + (i + 1) + " weight (kg): ");
                double weight = sc.nextDouble();
                
                if (weight <= 0) {
                    System.out.println("Invalid weight. Please enter a positive value.");
                    continue;
                }
                
                System.out.print("Person " + (i + 1) + " height (m): ");
                double height = sc.nextDouble();
                
                if (height <= 0) {
                    System.out.println("Invalid height. Please enter a positive value.");
                    continue;
                }
                
                personData[i][0] = height;
                personData[i][1] = weight;
                validInput = true;
            }
        }
        
        for (int i = 0; i < number; i++) {
            double bmi = personData[i][1] / (personData[i][0] * personData[i][0]);
            personData[i][2] = bmi;
            
            if (bmi <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmi >= 25.0 && bmi <= 39.9) {
                weightStatus[i] = "Overweight";
            } else if (bmi >= 40.0) {
                weightStatus[i] = "Obese";
            }
        }
        
        System.out.println("\n========== BMI Report ==========");
        System.out.println("Person\tHeight(m)\tWeight(kg)\tBMI\t\tStatus");
        System.out.println("======================================================================");
        
        for (int i = 0; i < number; i++) {
            System.out.println((i + 1) + "\t" + personData[i][0] + "\t\t" + 
                             personData[i][1] + "\t\t" + 
                             String.format("%.2f", personData[i][2]) + "\t\t" + 
                             weightStatus[i]);
        }
        
        sc.close();
    }
}
