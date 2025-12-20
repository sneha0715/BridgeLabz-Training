import java.util.Scanner;

public class FactorialFor {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a positive integer: ");
    int n = sc.nextInt();
    
    if (n < 0) {
      System.out.println("Please enter a positive integer!");
      sc.close();
      return;
    }
    
    long factorial = 1;
    
    for (int i = 1; i <= n; i++) {
      factorial *= i;
    }
    
    System.out.println("Factorial of " + n + " is: " + factorial);
    
    sc.close();
  }
}
