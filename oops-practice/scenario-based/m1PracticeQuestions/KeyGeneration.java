import java.util.Scanner;

public class KeyGeneration {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < n; i++) {
      String input = sc.nextLine().toLowerCase();
      if (input == null || input.isEmpty()) {
        System.out.println("Invalid input (empty string)");
        continue;
      }
      if (input.length() < 6) {
        System.out.println("Invalid input (length<6)");
        continue;
      }
      boolean invalid =false;
      for (char ch : input.toCharArray()) {
        if (ch == ' ') {
          System.out.println("Invalid input (contains empty space)");
          invalid=true;
          break;
        }
         else if (Character.isDigit(ch)) {
          System.out.println("Invalid input (contain digits)");
          invalid=true;
          break;
        } else if (!Character.isLetter(ch) && !Character.isDigit(ch)) {
          System.out.println("Invalid input (contains special characters)");
          invalid=true;
          break;
        }
      }
      if(invalid){
        continue;
      }
      StringBuilder sb = new StringBuilder();
      for (char ch : input.toCharArray()) {
        if (ch % 2 != 0) {
          sb.append(ch);
        }
      }

      if (sb.length() == 0) {
        System.out.println("Invalid input(empty string)");
        continue;
      }
      sb.reverse();

      StringBuilder ans = new StringBuilder();
      int idx = 0;
      for (char ch : sb.toString().toCharArray()) {
        if (idx % 2 == 0) {
          ans.append(Character.toUpperCase(ch));
        } else {
          ans.append(ch);
        }
        idx++;
      }
      System.out.println("The generated key is - "+ans);
    }
  }
}
