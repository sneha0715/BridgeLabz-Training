import java.util.Scanner;
public class LineComparisonProblem {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter 4 points of 1st line(x1 , y1 , x2 , y2): ");
    int x1=sc.nextInt();
    int x2=sc.nextInt();
    int y1=sc.nextInt();
    int y2=sc.nextInt();  
    System.out.println("Enter 4 points of 2nd line(x3 , y3 , x4, y4): ");
    int x3=sc.nextInt();
    int x4=sc.nextInt();
    int y3=sc.nextInt();
    int y4=sc.nextInt();
    double length1= findLength(x1, y1, x2, y2);
    double length2=findLength(x3, y3, x4, y4);
    System.out.println("Length1 is equal to length2 : "+checkEquality(length1, length2));
    compareLength(length1, length2);
  }
  static double findLength(int x1,int y1,int x2,int y2){
    double sum=(x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
    double length=Math.sqrt(sum);
    return length;
  }
  static boolean checkEquality(Double length1, Double length2){//Double is now treated as object while double is treated as normal datatype
    return length1.equals(length2);

  }
  static void compareLength(double length1, double length2){
    if(length1 >length2){
      System.out.println("Length1 is greater than Length2");
    }else if(length1<length2){
      System.out.println("Length1 is smaller than length2");
    }else{
      System.out.println("Length1 is equals to Length2");
    }
  }
}
