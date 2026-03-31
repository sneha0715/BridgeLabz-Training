import java.util.Scanner;

public class NumberGuessinggame {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int low = 1;
        int high = 100;
        boolean guessedCorrectly = false;

        System.out.println("Think of a number between 1 and 100.");
        System.out.println("Respond with: high, low, or correct");

        while (!guessedCorrectly && low <= high) {

            int guess = generateGuess(low, high);
            System.out.println("Computer guesses: " + guess);

            String feedback = getUserFeedback();

            if (feedback.equalsIgnoreCase("correct")) {
                System.out.println("🎉 Computer guessed your number!");
                guessedCorrectly = true;
            } 
            else if (feedback.equalsIgnoreCase("high")) {
                high = guess - 1;
            } 
            else if (feedback.equalsIgnoreCase("low")) {
                low = guess + 1;
            } 
            else {
                System.out.println("Invalid input. Please enter high, low, or correct.");
            }
        }
    }

    static int generateGuess(int low, int high) {
        return (int) (Math.random() * (high - low + 1)) + low;
    }

    static String getUserFeedback() {
        System.out.print("Is the guess high, low, or correct? ");
        return sc.nextLine();
    }
}
