import java.util.Scanner;
public class EligibleToVote {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the age of a person: ");
    int age=sc.nextInt();
    if(age>=18){
      System.out.println("The person can Vote");
    }else{
      System.out.println(("The person can not vote"));
    }
  }
}
