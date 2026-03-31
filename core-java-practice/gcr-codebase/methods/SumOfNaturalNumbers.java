import java.util.Scanner;

public class SumOfNaturalNumbers {
    
    public static int sumNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        
        if (n < 0) {
            System.out.println("Invalid input. Please enter a non-negative number.");
            sc.close();
            return;
        }
        
        int sum = sumNaturalNumbers(n);
        System.out.println("Sum of first " + n + " natural numbers: " + sum);
        
        sc.close();
    }
}
