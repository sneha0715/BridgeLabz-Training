import java.util.Arrays;

public class NumberChecker5 {

    public static int getDigitCount(int number) {
        if (number == 0) return 1;
        return String.valueOf(Math.abs(number)).length();
    }

    public static int[] getDigitsArray(int number) {
        int count = getDigitCount(number);
        int[] digits = new int[count];
        int temp = Math.abs(number);
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        return digits;
    }

    public static int getSumOfProperDivisors(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static long getFactorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static boolean isPerfectNumber(int number) {
        if (number <= 0) return false;
        return getSumOfProperDivisors(number) == number;
    }

    public static boolean isAbundantNumber(int number) {
        if (number <= 0) return false;
        return getSumOfProperDivisors(number) > number;
    }

    public static boolean isDeficientNumber(int number) {
        if (number <= 0) return false;
        return getSumOfProperDivisors(number) < number;
    }

    public static boolean isStrongNumber(int number) {
        int[] digits = getDigitsArray(number);
        long sum = 0;
        for (int digit : digits) {
            sum += getFactorial(digit);
        }
        return sum == number;
    }

    public static void main(String[] args) {
        int num1 = 6;    
        int num2 = 12;   
        int num3 = 145;  
        int num4 = 15;   

        System.out.println("Testing Number: " + num1 );
        System.out.println("Is Perfect: " + isPerfectNumber(num1));

        System.out.println(" Testing Number: " + num2 );
        System.out.println("Is Abundant: " + isAbundantNumber(num2));

        System.out.println(" Testing Number: " + num4 );
        System.out.println("Is Deficient: " + isDeficientNumber(num4));

        System.out.println(" Testing Number: " + num3 );
        System.out.println("Is Strong: " + isStrongNumber(num3));
    }
}