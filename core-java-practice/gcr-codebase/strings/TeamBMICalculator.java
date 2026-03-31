import java.util.Scanner;

public class TeamBMICalculator {
    
    public static String[][] calculateBMIAndStatus(double weight, double heightCm) {
        String[][] result = new String[1][4];
        
        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);
        
        String status;
        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            status = "Normal";
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            status = "Overweight";
        } else if (bmi >= 40.0) {
            status = "Obese";
        } else {
            status = "Unknown";
        }
        
        result[0][0] = String.valueOf(heightCm);
        result[0][1] = String.valueOf(weight);
        result[0][2] = String.format("%.2f", bmi);
        result[0][3] = status;
        
        return result;
    }
    
    public static String[][] processBMIData(double[][] heightWeightData) {
        String[][] bmiData = new String[heightWeightData.length][4];
        
        for (int i = 0; i < heightWeightData.length; i++) {
            double weight = heightWeightData[i][0];
            double heightCm = heightWeightData[i][1];
            
            String[][] result = calculateBMIAndStatus(weight, heightCm);
            
            bmiData[i][0] = result[0][0];
            bmiData[i][1] = result[0][1];
            bmiData[i][2] = result[0][2];
            bmiData[i][3] = result[0][3];
        }
        
        return bmiData;
    }
    
    public static void displayBMITable(String[][] bmiData) {
        System.out.println("\n==================== BMI ANALYSIS REPORT ====================");
        System.out.println("Person\tHeight(cm)\tWeight(kg)\tBMI\t\tStatus");
        System.out.println("===========================================================");
        
        for (int i = 0; i < bmiData.length; i++) {
            System.out.printf("%d\t%s\t\t%s\t\t%s\t\t%s%n",
                (i + 1),
                bmiData[i][0],
                bmiData[i][1],
                bmiData[i][2],
                bmiData[i][3]);
        }
        
        System.out.println("===========================================================");
        
        System.out.println("\n========== BMI STATUS CRITERIA ==========");
        System.out.println("BMI <= 18.4: Underweight");
        System.out.println("BMI 18.5 - 24.9: Normal");
        System.out.println("BMI 25.0 - 39.9: Overweight");
        System.out.println("BMI >= 40.0: Obese");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        final int TEAM_SIZE = 10;
        double[][] heightWeightData = new double[TEAM_SIZE][2];
        
        System.out.println("========== BMI Calculation for Team Members ==========");
        System.out.println("Enter weight (kg) and height (cm) for 10 team members:\n");
        
        for (int i = 0; i < TEAM_SIZE; i++) {
            System.out.print("Person " + (i + 1) + " - Weight (kg): ");
            double weight = sc.nextDouble();
            
            if (weight <= 0) {
                System.out.println("Invalid weight. Please enter a positive value.");
                i--;
                continue;
            }
            
            System.out.print("Person " + (i + 1) + " - Height (cm): ");
            double height = sc.nextDouble();
            
            if (height <= 0) {
                System.out.println("Invalid height. Please enter a positive value.");
                i--;
                continue;
            }
            
            heightWeightData[i][0] = weight;
            heightWeightData[i][1] = height;
        }
        
        String[][] bmiData = processBMIData(heightWeightData);
        displayBMITable(bmiData);
        
        sc.close();
    }
}
