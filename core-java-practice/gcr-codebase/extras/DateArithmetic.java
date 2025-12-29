
import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter date (YYYY-MM-DD): ");
        String inputDate = sc.nextLine();

        LocalDate date = LocalDate.parse(inputDate);
        System.out.println("Original Date: " + date);

        date = date.plusDays(7);
        System.out.println("After adding 7 days: " + date);

        date = date.plusMonths(1);
        System.out.println("After adding 1 month: " + date);

        date = date.plusYears(2);
        System.out.println("After adding 2 years: " + date);

        date = date.minusWeeks(3);
        System.out.println("After subtracting 3 weeks: " + date);

        sc.close();
    }
}

