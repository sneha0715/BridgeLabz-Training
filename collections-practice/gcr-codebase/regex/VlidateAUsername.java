import java.util.Scanner;
public class VlidateAUsername {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter username: ");
    String username=sc.nextLine();
    if(username.matches("^[A-Za-z][A-Za-z0-9_]{4,14}$")){
      System.out.println("Valid user name");
    }else{
      System.out.println("User name not valid");
    }
  }
}
