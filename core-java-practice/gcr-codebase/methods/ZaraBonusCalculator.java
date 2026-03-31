import java.util.Scanner;

public class ZaraBonusCalculator {

    public static double[][] generateEmployeeData() {
        double[][] data = new double[10][2];
        for (int i = 0; i < 10; i++) {
            
            data[i][0] = 10000 + (Math.random() * 90000);
           
            data[i][1] = 1 + (int)(Math.random() * 10);
        }
        return data;
    }

    public static double[][] calculateBonusAndNewSalary(double[][] employeeData) {
        double[][] results = new double[10][2];
        for (int i = 0; i < 10; i++) {
            double oldSalary = employeeData[i][0];
            double years = employeeData[i][1];
            double bonusPercent = (years > 5) ? 0.05 : 0.02;

            double bonusAmount = oldSalary * bonusPercent;
            double newSalary = oldSalary + bonusAmount;

            results[i][0] = bonusAmount;
            results[i][1] = newSalary;
        }
        return results;
    }

    public static void displaySummaryTable(double[][] oldData, double[][] results) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.printf("%-10s | %-12s | %-10s | %-12s | %-12s\n", 
                          "Emp ID", "Old Salary", "Service", "Bonus", "New Salary");

        for (int i = 0; i < 10; i++) {
            double oldSalary = oldData[i][0];
            double service = oldData[i][1];
            double bonus = results[i][0];
            double newSalary = results[i][1];

            totalOldSalary += oldSalary;
            totalBonus += bonus;
            totalNewSalary += newSalary;

            System.out.printf("%-10d | %-12.2f | %-10.0f | %-12.2f | %-12.2f\n", 
                              (i + 1), oldSalary, service, bonus, newSalary);
        }

        System.out.printf("%-25s | %-12.2f | %-12.2f | %-12.2f\n", 
                          "TOTALS", totalOldSalary, totalBonus, totalNewSalary);
    }

    public static void main(String[] args) {
        double[][] employeeBaseData = generateEmployeeData();

        double[][] calculationResults = calculateBonusAndNewSalary(employeeBaseData);

        displaySummaryTable(employeeBaseData, calculationResults);
    }
}