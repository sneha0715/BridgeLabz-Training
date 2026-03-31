import java.util.Scanner;

public class RocketCountdownFor {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter countdown value: ");
    int counter = sc.nextInt();
    
    System.out.println("\n--- Countdown Started ---");
    for (int i = counter; i >= 1; i--) {
      System.out.println(i);
    }
    System.out.println("🚀 Blast Off!");
    sc.close();
  }
}
