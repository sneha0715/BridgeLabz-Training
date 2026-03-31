import java.util.Scanner;

public class StudentVoteChecker {
    
    public static boolean canStudentVote(int age) {
        if (age < 0) {
            return false;
        }
        if (age >= 18) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] ages = new int[10];
        
        System.out.println("Enter ages of 10 students:");
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Student " + (i + 1) + " age: ");
            ages[i] = sc.nextInt();
        }
        
        System.out.println("\n========== Voting Eligibility ==========");
        for (int i = 0; i < ages.length; i++) {
            boolean canVote = canStudentVote(ages[i]);
            if (canVote) {
                System.out.println("Student " + (i + 1) + " (Age: " + ages[i] + ") can vote");
            } else {
                System.out.println("Student " + (i + 1) + " (Age: " + ages[i] + ") cannot vote");
            }
        }
        
        sc.close();
    }
}
