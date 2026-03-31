import java.util.Scanner;

public class ElectionBooth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vote1 = 0, vote2 = 0, vote3 = 0;

        while (true) {
            System.out.print("Enter Age (or -1 to stop voting): ");
            int age = sc.nextInt();

            if (age == -1) {
                System.out.println("Voting Stopped.");
                break;
            }

            if (age < 18) {
                System.out.println("Not eligible to vote!");
                continue;
            }

            System.out.print("Enter your vote (1 / 2 / 3): ");
            int vote = sc.nextInt();

            if (vote == 1)
                vote1++;
            else if (vote == 2)
                vote2++;
            else if (vote == 3)
                vote3++;
            else
                System.out.println("Invalid Vote!");
        }

        System.out.println("--- Voting Result ---");
        System.out.println("Candidate 1 Votes: " + vote1);
        System.out.println("Candidate 2 Votes: " + vote2);
        System.out.println("Candidate 3 Votes: " + vote3);

        sc.close();
    }
}
