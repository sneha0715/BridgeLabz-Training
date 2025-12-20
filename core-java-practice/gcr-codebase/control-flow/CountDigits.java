import java.util.Scanner;

public class CountDigits {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a number: ");
    
    int number = sc.nextInt();
    
    int count = 0;
    
    int originalNumber = number;
    while (number != 0) {
      number = number / 10;
      count = count + 1;
    }
    System.out.println("The number of digits in " + originalNumber + " is: " + count);
    sc.close();
  }
}
