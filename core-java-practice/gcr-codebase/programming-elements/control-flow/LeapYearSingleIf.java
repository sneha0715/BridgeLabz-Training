import java.util.Scanner;

public class LeapYearSingleIf {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a year: ");
    int year = sc.nextInt();

    if (year < 1582) {
      System.out.println("The LeapYear program only works for year >= 1582");
    } else {
      if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
        System.out.println(year + " is a Leap Year");
      } else {
        System.out.println(year + " is not a Leap Year");
      }
    }
  }
}
