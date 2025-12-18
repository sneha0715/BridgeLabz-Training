import java.util.Scanner;
public class CourseDiscount {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter fee of student: ");
    int fee=sc.nextInt();
    System.out.println("Enter discount percent: ");
    int discountPercent=sc.nextInt();
    double discount=(fee*discountPercent)/100.0;
    double feePaid=fee-discount;
    System.out.println("The discount amount is INR "+discount+"and final discounted fee is INR " +feePaid);
    sc.close();
  }
}
