import java.util.Scanner;

public class MeanHeightFootballTeam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double[] heights = new double[11];
        
        System.out.println("Enter the heights of 11 football players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + " height: ");
            heights[i] = sc.nextDouble();
        }
        
        double sum = 0.0;
        for (int i = 0; i < heights.length; i++) {
            sum += heights[i];
        }
        
        double meanHeight = sum / 11;
        
        System.out.println("Mean height of the football team: " + meanHeight);
    }
}
