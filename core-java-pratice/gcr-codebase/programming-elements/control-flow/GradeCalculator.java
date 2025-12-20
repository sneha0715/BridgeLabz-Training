import java.util.Scanner;

public class GradeCalculator {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Enter marks for Physics: ");
    int physics = sc.nextInt();
    System.out.println("Enter marks for Chemistry: ");
    int chemistry = sc.nextInt();
    System.out.println("Enter marks for Maths: ");
    int maths = sc.nextInt();
    int totalMarks = physics + chemistry + maths;
    double percentage = (totalMarks / 300.0) * 100;
    double averageMark = totalMarks / 3.0;
    System.out.println("Physics: " + physics);
    System.out.println("Chemistry: " + chemistry);
    System.out.println("Maths: " + maths);
    System.out.println("Total Marks: " + totalMarks + "/300");
    System.out.println("Percentage: " + String.format("%.2f", percentage) + "%");
    System.out.println("Average Mark: " + String.format("%.2f", averageMark));
    
    String grade;
    String remarks;
    
    if (percentage >= 80) {
      grade = "A";
      remarks = "(Level 4, above agency-normalized standards)";
    } else if (percentage >= 70) {
      grade = "B";
      remarks = "(Level 3, at agency-normalized standards)";
    } else if (percentage >= 60) {
      grade = "C";
      remarks = "(Level 2, below, but approaching agency-normalized standards)";
    } else if (percentage >= 50) {
      grade = "D";
      remarks = "(Level 1, well below agency-normalized standards)";
    } else if (percentage >= 40) {
      grade = "E";
      remarks = "(Level 1-, too below agency-normalized standards)";
    } else {
      grade = "R";
      remarks = "(Remedial standards)";
    }
    
    System.out.println("\nGrade: " + grade);
    System.out.println("Remarks: " + remarks);
    sc.close();
  }
}
