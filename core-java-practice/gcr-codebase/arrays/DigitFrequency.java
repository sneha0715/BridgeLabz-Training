import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        long number = sc.nextLong();
        
        String numberStr = String.valueOf(Math.abs(number));
        int digitCount = numberStr.length();
        
        int[] digits = new int[digitCount];
        int index = 0;
        
        long temp = Math.abs(number);
        while (temp != 0) {
            digits[index] = (int)(temp % 10);
            index++;
            temp = temp / 10;
        }
        
        int[] frequency = new int[10];
        
        for (int i = 0; i < digitCount; i++) {
            frequency[digits[i]]++;
        }
        
        System.out.println("\nDigit Frequency:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " appears " + frequency[i] + " time(s)");
            }
        }
        
        sc.close();
    }
}
