import java.util.Scanner;

public class CheckNumberSign {
    
    public static int checkNumber(int number) {
        if (number < 0) {
            return -1;
        } else if (number > 0) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        int result = checkNumber(number);
        
        if (result == -1) {
            System.out.println("The number " + number + " is negative");
        } else if (result == 1) {
            System.out.println("The number " + number + " is positive");
        } else {
            System.out.println("The number is zero");
        }
        
        sc.close();
    }
}
