import java.util.Random;

public class StudentScorecard {
    
    public static double[][] generateRandomScores(int numberOfStudents) {
        double[][] scores = new double[numberOfStudents][3];
        Random random = new Random();
        
        for (int i = 0; i < numberOfStudents; i++) {
            scores[i][0] = random.nextDouble() * 100;
            scores[i][1] = random.nextDouble() * 100;
            scores[i][2] = random.nextDouble() * 100;
        }
        
        return scores;
    }
    
    public static double[][] calculateAverageAndPercentage(double[][] scores) {
        double[][] results = new double[scores.length][3];
        
        for (int i = 0; i < scores.length; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3;
            double percentage = (total / 300) * 100;
            
            results[i][0] = Math.round(total * 100.0) / 100.0;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        
        return results;
    }
    
    public static String[] calculateGrade(double[][] results) {
        String[] grades = new String[results.length];
        
        for (int i = 0; i < results.length; i++) {
            double percentage = results[i][2];
            
            if (percentage >= 80) {
                grades[i] = "A";
            } else if (percentage >= 70) {
                grades[i] = "B";
            } else if (percentage >= 60) {
                grades[i] = "C";
            } else if (percentage >= 50) {
                grades[i] = "D";
            } else if (percentage >= 40) {
                grades[i] = "E";
            } else {
                grades[i] = "R";
            }
        }
        
        return grades;
    }
    
    public static void displayScorecard(double[][] scores, double[][] results, String[] grades) {
        System.out.println("\n==================== STUDENT SCORECARD ====================");
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");
        System.out.println("=============================================================================");
        
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%.2f\t%.2f\t\t%.2f\t%.2f\t%.2f\t%.2f%%\t\t%s%n",
                (i + 1),
                scores[i][0],
                scores[i][1],
                scores[i][2],
                results[i][0],
                results[i][1],
                results[i][2],
                grades[i]);
        }
        
        System.out.println("=============================================================================");
        
        System.out.println("\n========== GRADE CRITERIA ==========");
        System.out.println("Grade A: 80% and above (Level 4, above agency-normalized standards)");
        System.out.println("Grade B: 70-79% (Level 3, at agency-normalized standards)");
        System.out.println("Grade C: 60-69% (Level 2, below, but approaching agency-normalized standards)");
        System.out.println("Grade D: 50-59% (Level 1, well below agency-normalized standards)");
        System.out.println("Grade E: 40-49% (Level 1-, too below agency-normalized standards)");
        System.out.println("Grade R: 39% and below (Remedial standards)");
    }
    
    public static void main(String[] args) {
        int numberOfStudents = 5;
        
        double[][] scores = generateRandomScores(numberOfStudents);
        double[][] results = calculateAverageAndPercentage(scores);
        String[] grades = calculateGrade(results);
        
        displayScorecard(scores, results, grades);
    }
}
