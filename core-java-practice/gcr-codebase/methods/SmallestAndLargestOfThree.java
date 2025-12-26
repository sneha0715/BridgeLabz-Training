import java.util.Scanner;

public class SmallestAndLargestOfThree {
    
    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int[] result = new int[2];
        
        int max = number1;
        int min = number1;
        
        if (number2 > max) {
            max = number2;
        }
        if (number3 > max) {
            max = number3;
        }
        
        if (number2 < min) {
            min = number2;
        }
        if (number3 < min) {
            min = number3;
        }
        
        result[0] = min;
        result[1] = max;
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        
        System.out.print("Enter third number: ");
        int num3 = sc.nextInt();
        
        int[] result = findSmallestAndLargest(num1, num2, num3);
        
        System.out.println("Smallest number: " + result[0]);
        System.out.println("Largest number: " + result[1]);
        
        sc.close();
    }
}
