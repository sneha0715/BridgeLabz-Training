import java.util.Scanner;

public class FactorialWhile {
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
    int counter = 1;
    
    while (counter <= n) {
      factorial *= counter;
      counter++;
    }
    
    System.out.println("Factorial of " + n + " is: " + factorial);
    
    sc.close();
  }
}
