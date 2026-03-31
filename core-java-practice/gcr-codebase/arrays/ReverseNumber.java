import java.util.Scanner;

public class ReverseNumber {
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
        
        int[] reversedDigits = new int[digitCount];
        for (int i = 0; i < digitCount; i++) {
            reversedDigits[i] = digits[digitCount - 1 - i];
        }
        
        System.out.print("Reversed number: ");
        for (int i = 0; i < digitCount; i++) {
            System.out.print(reversedDigits[i]);
        }
        System.out.println();
        
        sc.close();
    }
}
