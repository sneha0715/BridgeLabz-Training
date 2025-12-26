import java.util.Arrays;

public class NumberChecker {

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

    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) return true;
        }
        return false;
    }

    public static boolean isArmstrong(int originalNumber, int[] digits) {
        int power = digits.length;
        long sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, power);
        }
        return sum == Math.abs(originalNumber);
    }

    public static void findLargestAndSecond(int[] digits) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int digit : digits) {
            if (digit > first) {
                second = first;
                first = digit;
            } else if (digit > second && digit != first) {
                second = digit;
            }
        }
        
        System.out.println("Largest element: " + first);
        System.out.println("Second largest element: " + (second == Integer.MIN_VALUE ? "N/A" : second));
    }

    public static void findSmallestAndSecond(int[] digits) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int digit : digits) {
            if (digit < first) {
                second = first;
                first = digit;
            } else if (digit < second && digit != first) {
                second = digit;
            }
        }

        System.out.println("Smallest element: " + first);
        System.out.println("Second smallest element: " + (second == Integer.MAX_VALUE ? "N/A" : second));
    }

    public static void main(String[] args) {
        int input = 153; 
        
        int count = getDigitCount(input);
        int[] digits = getDigitsArray(input);
        
        System.out.println("Number: " + input);
        System.out.println("Digit Count: " + count);
        System.out.println("Digits Array: " + Arrays.toString(digits));
        System.out.println("Is Duck Number: " + isDuckNumber(digits));
        System.out.println("Is Armstrong Number: " + isArmstrong(input, digits));
        
        findLargestAndSecond(digits);
        findSmallestAndSecond(digits);
    }
}