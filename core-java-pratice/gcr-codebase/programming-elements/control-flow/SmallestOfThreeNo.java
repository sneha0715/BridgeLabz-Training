import java.util.Scanner;

public class SmallestOfThreeNo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter first Number: ");
    int firstNo = sc.nextInt();
    System.out.println("Enter second Number: ");
    int secondNo = sc.nextInt();
    System.out.println("Enter third Number: ");
    int thirdNo = sc.nextInt();
    if (firstNo < secondNo && firstNo < thirdNo) {
      System.out.println("First no is the smallest of three numbers");
    } else {
      System.out.println("First no is not the smallest of three numbers");
    }
  }
}
