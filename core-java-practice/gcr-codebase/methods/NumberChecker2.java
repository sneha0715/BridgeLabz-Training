import java.util.Arrays;

public class NumberChecker2 {

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

    public static int getSumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int getSumOfSquares(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += (int) Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int originalNumber, int[] digits) {
        int sum = getSumOfDigits(digits);
        if (sum == 0) return false;
        return originalNumber % sum == 0;
    }

    public static int[][] getDigitFrequency(int[] digits) {
        int[][] freqMap = new int[10][2];
        for (int i = 0; i < 10; i++) {
            freqMap[i][0] = i;
            freqMap[i][1] = 0;
        }

        for (int digit : digits) {
            freqMap[digit][1]++;
        }

        int uniqueCount = 0;
        for (int i = 0; i < 10; i++) {
            if (freqMap[i][1] > 0) uniqueCount++;
        }

        int[][] result = new int[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (freqMap[i][1] > 0) {
                result[index][0] = freqMap[i][0];
                result[index][1] = freqMap[i][1];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int input = 211;

        int[] digits = getDigitsArray(input);
        int sum = getSumOfDigits(digits);
        int sumSquares = getSumOfSquares(digits);
        boolean harshad = isHarshadNumber(input, digits);
        int[][] frequencies = getDigitFrequency(digits);

        System.out.println("Input Number: " + input);
        System.out.println("Digit Count: " + getDigitCount(input));
        System.out.println("Digits Array: " + Arrays.toString(digits));
        System.out.println("Sum of Digits: " + sum);
        System.out.println("Sum of Squares: " + sumSquares);
        System.out.println("Is Harshad Number: " + harshad);
        
        System.out.println("Digit Frequencies:");
        for (int[] row : frequencies) {
            System.out.println("Digit " + row[0] + " appears " + row[1] + " time(s)");
        }
    }
}