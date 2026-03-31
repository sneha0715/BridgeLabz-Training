import java.util.Scanner;
public class ValidateHexColorCode {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter Hex color code: ");
    String HexColorCode=sc.nextLine();

    if(HexColorCode.matches("^[#][0-9A-Za-z]{6}")){
      System.out.println("Valid Hex Color Code");
    }else{
      System.out.println("Not Valid Hex Color Code");
    }
  }
}
