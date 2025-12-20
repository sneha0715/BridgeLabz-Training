import java.util.Scanner;

public class CheckArmstrong {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a number: ");

    int number = sc.nextInt();
    
    int sum = 0;
    
    int originalNumber = number;
    
    while (originalNumber != 0) {
      int digit = originalNumber % 10;
      
      int cube = digit * digit * digit;
      sum = sum + cube;
    
      originalNumber = originalNumber / 10;
    }
    if (number == sum) {
      System.out.println(number + " is an Armstrong Number");
      System.out.println("Sum of cubes of digits: " + sum);
    } else {
      System.out.println(number + " is not an Armstrong Number");
      System.out.println("Sum of cubes of digits: " + sum);
    }
    sc.close();
  }
}
