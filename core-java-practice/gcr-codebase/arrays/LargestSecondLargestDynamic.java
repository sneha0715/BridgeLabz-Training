import java.util.Scanner;

public class LargestSecondLargestDynamic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
        
        int temp = number;
        while (temp != 0) {
            if (index == maxDigit) {
                maxDigit += 10;
                int[] tempArray = new int[maxDigit];
                for (int j = 0; j < index; j++) {
                    tempArray[j] = digits[j];
                }
                digits = tempArray;
            }
            
            digits[index] = temp % 10;
            index++;
            temp = temp / 10;
        }
        
        int largest = 0;
        int secondLargest = 0;
        
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }
        
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
        
        sc.close();
    }
}
