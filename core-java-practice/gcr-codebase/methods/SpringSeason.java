import java.util.Scanner;

public class SpringSeason {
    
    public static boolean isSpringSeason(int month, int day) {
        if (month == 3 && day >= 20) {
            return true;
        }
        if (month > 3 && month < 6) {
            return true;
        }
        if (month == 6 && day <= 20) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        
        System.out.print("Enter day (1-31): ");
        int day = sc.nextInt();
        
        if (month < 1 || month > 12 || day < 1 || day > 31) {
            System.out.println("Invalid input. Please enter valid month and day.");
            sc.close();
            return;
        }
        
        if (isSpringSeason(month, day)) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
        
        sc.close();
    }
}
