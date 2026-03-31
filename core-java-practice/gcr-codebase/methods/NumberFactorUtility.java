import java.util.Arrays;
import java.util.Scanner;

public class NumberFactorUtility {

    public static int[] getFactorsArray(int number) {
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
                factors[index++] = i;
            }
        }
        return factors;
    }

    public static int getGreatestFactor(int[] factors) {
        if (factors.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for (int factor : factors) {
            if (factor > max) {
                max = factor;
            }
        }
        return max;
    }

    public static int getSumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    public static long getProductOfFactors(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    public static double getProductOfCubesOfFactors(int[] factors) {
        double productOfCubes = 1;
        for (int factor : factors) {
            productOfCubes *= Math.pow(factor, 3);
        }
        return productOfCubes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number to find its factors: ");
        int num = sc.nextInt();

        int[] factors = getFactorsArray(num);

        System.out.println("\n--- Results for " + num + " ---");
        System.out.println("Factors Array: " + Arrays.toString(factors));
        System.out.println("Greatest Factor: " + getGreatestFactor(factors));
        System.out.println("Sum of Factors: " + getSumOfFactors(factors));
        System.out.println("Product of Factors: " + getProductOfFactors(factors));
        System.out.println("Product of Cubes of Factors: " + getProductOfCubesOfFactors(factors));

        sc.close();
    }
}