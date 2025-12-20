import java.util.Scanner;

public class SumOfNaturalNumbersWhile {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a natural number: ");
    int n = sc.nextInt();
    
    if (n <= 0) {
      System.out.println("Please enter a positive natural number!");
      sc.close();
      return;
    }
    
    // Using formula: n*(n+1)/2
    long sumFormula = (long) n * (n + 1) / 2;
    
    // Using while loop
    long sumLoop = 0;
    int counter = 1;
    while (counter <= n) {
      sumLoop += counter;
      counter++;
    }
    
    System.out.println("\n--- Sum of Natural Numbers from 1 to " + n + " ---");
    System.out.println("Using Formula n*(n+1)/2: " + sumFormula);
    System.out.println("Using While Loop: " + sumLoop);
    System.out.println("Results Match: " + (sumFormula == sumLoop));
    
    sc.close();
  }
}
