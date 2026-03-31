import java.util.Scanner;

public class LeapYearChecker {
    
    public static boolean isLeapYear(int year) {
        if (year < 1582) {
            System.out.println("LeapYear program only works for year >= 1582");
            return false;
        }
        
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        if (year % 4 == 0) {
            return true;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a year: ");
        int year = sc.nextInt();
        
        if (isLeapYear(year)) {
            System.out.println(year + " is a Leap Year");
        } else {
            System.out.println(year + " is not a Leap Year");
        }
        
        sc.close();
    }
}
