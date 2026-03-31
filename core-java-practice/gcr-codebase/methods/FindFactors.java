import java.util.Scanner;

public class FindFactors {
    
    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }
        
        return factors;
    }
    
    public static int findSumOfFactors(int[] factors) {
        int sum = 0;
        for (int i = 0; i < factors.length; i++) {
            sum += factors[i];
        }
        return sum;
    }
    
    public static long findProductOfFactors(int[] factors) {
        long product = 1;
        for (int i = 0; i < factors.length; i++) {
            product *= factors[i];
        }
        return product;
    }
    
    public static long findSumOfSquareOfFactors(int[] factors) {
        long sumOfSquares = 0;
        for (int i = 0; i < factors.length; i++) {
            sumOfSquares += Math.pow(factors[i], 2);
        }
        return sumOfSquares;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        if (number <= 0) {
            System.out.println("Please enter a positive number.");
            sc.close();
            return;
        }
        
        int[] factors = findFactors(number);
        
        System.out.println("\nFactors of " + number + ": ");
        for (int i = 0; i < factors.length; i++) {
            System.out.print(factors[i] + " ");
        }
        System.out.println();
        
        int sumOfFactors = findSumOfFactors(factors);
        long productOfFactors = findProductOfFactors(factors);
        long sumOfSquares = findSumOfSquareOfFactors(factors);
        
        System.out.println("Sum of factors: " + sumOfFactors);
        System.out.println("Product of factors: " + productOfFactors);
        System.out.println("Sum of square of factors: " + sumOfSquares);
        
        sc.close();
    }
}
