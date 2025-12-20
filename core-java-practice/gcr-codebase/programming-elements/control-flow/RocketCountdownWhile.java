import java.util.Scanner;

public class RocketCountdownWhile {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter countdown value: ");
    int counter = sc.nextInt();
    
    System.out.println("\n--- Countdown Started ---");
    while (counter >= 1) {
      System.out.println(counter);
      counter--;
    }
    System.out.println("🚀 Blast Off!");
    sc.close();
  }
}
