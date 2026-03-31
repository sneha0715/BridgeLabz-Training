import java.util.Scanner;

public class SumUntilZero {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double total = 0.0;
    double userInput;
    
    System.out.println("Enter numbers to sum (enter 0 to stop):");
    
    userInput = sc.nextDouble();
    while (userInput != 0) {
      total += userInput;
      System.out.print("Enter next number (0 to stop): ");
      userInput = sc.nextDouble();
    }
    
    System.out.println("\nSum of all numbers: " + total);
    sc.close();
  }
}
