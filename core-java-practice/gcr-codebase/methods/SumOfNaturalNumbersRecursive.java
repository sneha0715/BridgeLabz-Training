import java.util.Scanner;

public class SumOfNaturalNumbersRecursive {
    
    public static int sumRecursive(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumRecursive(n - 1);
    }
    
    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        if (number < 0) {
            System.out.println("Please enter a natural number (non-negative).");
            sc.close();
            return;
        }
        
        int resultRecursive = sumRecursive(number);
        int resultFormula = sumFormula(number);
        
        System.out.println("Sum using recursion: " + resultRecursive);
        System.out.println("Sum using formula n*(n+1)/2: " + resultFormula);
        System.out.println("Both results are equal: " + (resultRecursive == resultFormula));
        
        sc.close();
    }
}
