import java.util.Scanner;

public class BMICalculator {
    
    public static double[][] calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightInCm = data[i][1];
            double heightInMeters = heightInCm / 100.0;
            double bmi = weight / (heightInMeters * heightInMeters);
            data[i][2] = bmi;
        }
        return data;
    }
    
    public static String[] getBMIStatus(double[][] data) {
        String[] status = new String[data.length];
        
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            
            if (bmi <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                status[i] = "Normal";
            } else if (bmi >= 25.0 && bmi <= 39.9) {
                status[i] = "Overweight";
            } else if (bmi >= 40.0) {
                status[i] = "Obese";
            }
        }
        
        return status;
    }
    
    public static void displayResults(double[][] data, String[] status) {
        System.out.println(" BMI Analysis of 10 Team Members");
        System.out.printf("%-10s%-15s%-15s%-15s%-15s%n", "Member", "Weight(kg)", "Height(cm)", "BMI", "Status");
        
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-10d%-15.2f%-15.2f%-15.2f%-15s%n", 
                (i + 1), data[i][0], data[i][1], data[i][2], status[i]);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double[][] teamData = new double[10][3];
        
        System.out.println("Enter weight (kg) and height (cm) for 10 team members:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Member " + (i + 1) + " - Enter weight (kg): ");
            teamData[i][0] = sc.nextDouble();
            
            System.out.print("Member " + (i + 1) + " - Enter height (cm): ");
            teamData[i][1] = sc.nextDouble();
        }
        
        teamData = calculateBMI(teamData);
        String[] bmiStatus = getBMIStatus(teamData);
        
        displayResults(teamData, bmiStatus);
        
        sc.close();
    }
}
