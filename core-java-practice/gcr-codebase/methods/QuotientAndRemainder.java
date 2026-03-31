import java.util.Scanner;

public class QuotientAndRemainder {
    
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int[] result = new int[2];
        
        result[0] = number % divisor;
        result[1] = number / divisor;
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        System.out.print("Enter divisor: ");
        int divisor = sc.nextInt();
        
        if (divisor == 0) {
            System.out.println("Error: Divisor cannot be zero.");
            sc.close();
            return;
        }
        
        int[] result = findRemainderAndQuotient(number, divisor);
        
        System.out.println("Quotient: " + result[1]);
        System.out.println("Remainder: " + result[0]);
        
        sc.close();
    }
}
