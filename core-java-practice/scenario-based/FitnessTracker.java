import java.util.Scanner;

public class FitnessTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int days = sc.nextInt();

        int[] pushUps = new int[days];
        int total = 0;
        int activeDays = 0;

        System.out.println("Enter push-ups for each day (0 for rest day):");

        for (int i = 0; i < days; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            pushUps[i] = sc.nextInt();
        }

        for (int count : pushUps) {

            if (count == 0) {
                continue; 
            }

            total += count;
            activeDays++;
        }

        double average = (activeDays > 0) ? (double) total / activeDays : 0;

        System.out.println("Total Push-ups: " + total);
        System.out.println("Average Push-ups per active day: " + average);

    }
}
