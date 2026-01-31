import java.util.Scanner;
class ValidateLicensePlateNo{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter License Nnumber");
    String LicenseNumber=sc.nextLine();
    if(LicenseNumber.matches("^[A-Z]{2}[0-9]{4}$")){
      System.out.println("License Number is valid");
    }else{
      System.out.println("License Number is not valid");
    }
  }
}