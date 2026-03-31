import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double[] salaries = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];
        
        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;
        
        System.out.println("Enter salary and years of service for 10 employees:");
        for (int i = 0; i < 10; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Employee " + (i + 1) + " salary: ");
                double salary = sc.nextDouble();
                
                if (salary <= 0) {
                    System.out.println("Invalid salary. Please enter a positive number.");
                    continue;
                }
                
                System.out.print("Employee " + (i + 1) + " years of service: ");
                double years = sc.nextDouble();
                
                if (years < 0) {
                    System.out.println("Invalid years of service. Please enter a non-negative number.");
                    continue;
                }
                
                salaries[i] = salary;
                yearsOfService[i] = years;
                validInput = true;
            }
        }
        
        for (int i = 0; i < 10; i++) {
            double bonus;
            if (yearsOfService[i] > 5) {
                bonus = salaries[i] * 0.05;
            } else {
                bonus = salaries[i] * 0.02;
            }
            
            bonuses[i] = bonus;
            newSalaries[i] = salaries[i] + bonus;
            
            totalBonus += bonus;
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }
        
        System.out.println("\n========== Employee Bonus Report ==========");
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total Bonus Payout: " + totalBonus);
        System.out.println("Total New Salary: " + totalNewSalary);
        
        sc.close();
    }
}
