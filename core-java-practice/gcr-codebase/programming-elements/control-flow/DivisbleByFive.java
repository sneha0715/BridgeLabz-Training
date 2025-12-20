import java.util.Scanner;
public class DivisbleByFive {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter a no:");
    int no=sc.nextInt();
    if(no%5==0){
      System.out.println("Number is divisible by 5");
    }else{
      System.out.println("Number not divisible by 5");
    }
  }
}
