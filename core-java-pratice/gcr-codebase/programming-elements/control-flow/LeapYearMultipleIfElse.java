import java.util.Scanner;

public class LeapYearMultipleIfElse {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a year: ");
    int year = sc.nextInt();
    if (year < 1582) {
      System.out.println("The LeapYear program only works for year >= 1582");
    } else {
      if (year % 400 == 0) {
        System.out.println(year + " is a Leap Year");
      } else {
        if (year % 100 == 0) {
          System.out.println(year + " is not a Leap Year");
        } else {
          if (year % 4 == 0) {
            System.out.println(year + " is a Leap Year");
          } else {
            System.out.println(year + " is not a Leap Year");
          }
        }
      }
    }
  }
}
