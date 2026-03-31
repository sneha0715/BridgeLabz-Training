import java.util.Scanner;
import java.util.Random;

public class StudentVotingEligibility2D {
    
    public static int[] generateRandomAges(int numberOfStudents) {
        int[] ages = new int[numberOfStudents];
        Random random = new Random();
        
        for (int i = 0; i < numberOfStudents; i++) {
            ages[i] = random.nextInt(90) + 10;
        }
        
        return ages;
    }
    
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            
            if (ages[i] < 0) {
                result[i][1] = "Cannot Vote (Invalid Age)";
            } else if (ages[i] >= 18) {
                result[i][1] = "Can Vote";
            } else {
                result[i][1] = "Cannot Vote";
            }
        }
        
        return result;
    }
    
    public static void displayVotingStatus(String[][] votingData) {
        System.out.println("\n========== Voting Eligibility Status ==========");
        System.out.println("Student\tAge\tEligibility Status");
        System.out.println("===============================================");
        
        for (int i = 0; i < votingData.length; i++) {
            System.out.println((i + 1) + "\t" + votingData[i][0] + "\t" + votingData[i][1]);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int numberOfStudents = sc.nextInt();
        
        int[] ages = generateRandomAges(numberOfStudents);
        String[][] votingStatus = checkVotingEligibility(ages);
        
        displayVotingStatus(votingStatus);
        
        sc.close();
    }
}
