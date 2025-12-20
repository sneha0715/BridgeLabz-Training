import java.util.Scanner;

public class SumOfNaturalNo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a positive integer: ");
    int n = sc.nextInt();
    if (n > 1) {
      System.out.println("Number is a natural no");
    } else {  
      System.out.println("Number is not a natural no");
    }
    int sum=n*(n+1)/2;
    System.out.println("Sum of first " + n + " natural numbers is: " + sum);
  }
}
