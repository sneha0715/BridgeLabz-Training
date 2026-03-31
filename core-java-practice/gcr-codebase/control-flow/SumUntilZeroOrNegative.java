import java.util.Scanner;

public class SumUntilZeroOrNegative {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double total = 0.0;
    double userInput;
    
    System.out.println("Enter numbers to sum (enter 0 or negative to stop):");
    
    while (true) {
      System.out.print("Enter number: ");
      userInput = sc.nextDouble();
      
      if (userInput <= 0) {
        break;
      }
      
      total += userInput;
    }
    
    System.out.println("\nSum of all numbers: " + total);
    sc.close();
  }
}
