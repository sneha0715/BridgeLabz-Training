import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int numberOfStudents = sc.nextInt();
        
        double[][] marks = new double[numberOfStudents][3];
        double[] percentages = new double[numberOfStudents];
        char[] grades = new char[numberOfStudents];
        
        System.out.println("\nEnter marks for Physics, Chemistry, and Maths (out of 100):");
        for (int i = 0; i < numberOfStudents; i++) {
            boolean validInput = false;
            
            while (!validInput) {
                System.out.print("Student " + (i + 1) + " Physics marks: ");
                double physics = sc.nextDouble();
                
                if (physics < 0 || physics > 100) {
                    System.out.println("Invalid marks. Please enter a value between 0 and 100.");
                    continue;
                }
                
                System.out.print("Student " + (i + 1) + " Chemistry marks: ");
                double chemistry = sc.nextDouble();
                
                if (chemistry < 0 || chemistry > 100) {
                    System.out.println("Invalid marks. Please enter a value between 0 and 100.");
                    continue;
                }
                
                System.out.print("Student " + (i + 1) + " Maths marks: ");
                double maths = sc.nextDouble();
                
                if (maths < 0 || maths > 100) {
                    System.out.println("Invalid marks. Please enter a value between 0 and 100.");
                    continue;
                }
                
                marks[i][0] = physics;
                marks[i][1] = chemistry;
                marks[i][2] = maths;
                validInput = true;
            }
        }
        
        for (int i = 0; i < numberOfStudents; i++) {
            double totalMarks = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = (totalMarks / 300) * 100;
            
            if (percentages[i] >= 80) {
                grades[i] = 'A';
            } else if (percentages[i] >= 70) {
                grades[i] = 'B';
            } else if (percentages[i] >= 60) {
                grades[i] = 'C';
            } else if (percentages[i] >= 50) {
                grades[i] = 'D';
            } else if (percentages[i] >= 40) {
                grades[i] = 'E';
            } else {
                grades[i] = 'R';
            }
        }
        
        System.out.println("\n========== Student Grade Report ==========");
        System.out.println("Student\tPhysics\tChemistry\tMaths\tPercentage\tGrade\tRemarks");
        System.out.println("====================================================================================");
        
        for (int i = 0; i < numberOfStudents; i++) {
            String remarks = "";
            if (grades[i] == 'A') {
                remarks = "Level 4, above agency-normalized standards";
            } else if (grades[i] == 'B') {
                remarks = "Level 3, at agency-normalized standards";
            } else if (grades[i] == 'C') {
                remarks = "Level 2, below, but approaching agency-normalized standards";
            } else if (grades[i] == 'D') {
                remarks = "Level 1, well below agency-normalized standards";
            } else if (grades[i] == 'E') {
                remarks = "Level 1-, too below agency-normalized standards";
            } else if (grades[i] == 'R') {
                remarks = "Remedial standards";
            }
            
            System.out.println((i + 1) + "\t" + marks[i][0] + "\t" + marks[i][1] + "\t\t" + 
                             marks[i][2] + "\t" + String.format("%.2f", percentages[i]) + "%\t\t" + 
                             grades[i] + "\t" + remarks);
        }
        
        sc.close();
    }
}
