
import java.util.Arrays;

public class NumberChecker3 {

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

    public static int[] reverseArray(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    public static boolean areArraysEqual(int[] array1, int[] array2) {
        if (array1.length != array2.length) return false;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) return false;
        }
        return true;
    }

    public static boolean isPalindrome(int[] digits) {
        int[] reversed = reverseArray(digits);
        return areArraysEqual(digits, reversed);
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int input = 12021;

        int[] digits = getDigitsArray(input);
        int[] reversedDigits = reverseArray(digits);
        boolean palindromeStatus = isPalindrome(digits);
        boolean duckStatus = isDuckNumber(digits);

        System.out.println("Original Number: " + input);
        System.out.println("Digit Count: " + getDigitCount(input));
        System.out.println("Digits Array: " + Arrays.toString(digits));
        System.out.println("Reversed Array: " + Arrays.toString(reversedDigits));
        System.out.println("Arrays are Equal: " + areArraysEqual(digits, reversedDigits));
        System.out.println("Is Palindrome: " + palindromeStatus);
        System.out.println("Is Duck Number: " + duckStatus);
    }
}