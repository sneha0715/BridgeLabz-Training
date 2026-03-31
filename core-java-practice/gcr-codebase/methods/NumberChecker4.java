import java.util.Arrays;

public class NumberChecker4 {

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

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static boolean isNeonNumber(int number) {
        int square = number * number;
        int[] digits = getDigitsArray(square);
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum == number;
    }

    public static boolean isSpyNumber(int number) {
        int[] digits = getDigitsArray(number);
        int sum = 0;
        int product = 1;
        for (int digit : digits) {
            sum += digit;
            product *= digit;
        }
        return sum == product;
    }

    public static boolean isAutomorphicNumber(int number) {
        int square = number * number;
        String s1 = Integer.toString(number);
        String s2 = Integer.toString(square);
        return s2.endsWith(s1);
    }

    public static boolean isBuzzNumber(int number) {
        return (number % 7 == 0) || (number % 10 == 7);
    }

    public static void main(String[] args) {
        int testNum = 9;
        
        System.out.println("Analysis for Number: " + testNum);
        System.out.println("Is Prime: " + isPrime(testNum));
        System.out.println("Is Neon: " + isNeonNumber(testNum));
        System.out.println("Is Spy: " + isSpyNumber(testNum));
        System.out.println("Is Automorphic: " + isAutomorphicNumber(testNum));
        System.out.println("Is Buzz: " + isBuzzNumber(testNum));

        System.out.println("Testing specific examples:");
        System.out.println("Is 1124 a Spy Number? " + isSpyNumber(1124));
        System.out.println("Is 25 Automorphic? " + isAutomorphicNumber(25));
        System.out.println("Is 49 a Buzz Number? " + isBuzzNumber(49));
    }
}