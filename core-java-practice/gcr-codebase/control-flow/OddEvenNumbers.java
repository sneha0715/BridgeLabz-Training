import java.util.Scanner;

public class OddEvenNumbers {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a natural number: ");
    int n = sc.nextInt();
    
    if (n <= 0) {
      System.out.println("Please enter a positive natural number!");
      sc.close();
      return;
    }
    
    System.out.println("\n--- Numbers from 1 to " + n + " ---");
    System.out.println("Odd Numbers:");
    for (int i = 1; i <= n; i++) {
      if (i % 2 != 0) {
        System.out.print(i + " ");
      }
    }
    
    System.out.println("\n\nEven Numbers:");
    for (int i = 1; i <= n; i++) {
      if (i % 2 == 0) {
        System.out.print(i + " ");
      }
    }
    System.out.println();
    
    sc.close();
  }
}
