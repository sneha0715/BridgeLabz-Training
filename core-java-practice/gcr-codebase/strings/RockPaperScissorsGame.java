import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsGame {
    
    public static String getComputerChoice() {
        Random random = new Random();
        int choice = random.nextInt(3);
        
        if (choice == 0) {
            return "Rock";
        } else if (choice == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }
    
    public static String findWinner(String playerChoice, String computerChoice) {
        playerChoice = playerChoice.toLowerCase();
        computerChoice = computerChoice.toLowerCase();
        
        if (playerChoice.equals(computerChoice)) {
            return "Tie";
        } else if (playerChoice.equals("rock") && computerChoice.equals("scissors")) {
            return "Player";
        } else if (playerChoice.equals("scissors") && computerChoice.equals("paper")) {
            return "Player";
        } else if (playerChoice.equals("paper") && computerChoice.equals("rock")) {
            return "Player";
        } else {
            return "Computer";
        }
    }
    
    public static String[] calculateStats(int playerWins, int computerWins, int totalGames) {
        String[] stats = new String[4];
        
        double playerPercentage = (totalGames > 0) ? (playerWins * 100.0) / totalGames : 0;
        double computerPercentage = (totalGames > 0) ? (computerWins * 100.0) / totalGames : 0;
        
        stats[0] = String.valueOf(playerWins);
        stats[1] = String.valueOf(computerWins);
        stats[2] = String.format("%.2f", playerPercentage);
        stats[3] = String.format("%.2f", computerPercentage);
        
        return stats;
    }
    
    public static void displayResults(String[][] results, String[] stats, int totalGames) {
        System.out.println("\n========== Game Results ==========");
        System.out.println("Game\tPlayer\tComputer\tWinner");
        System.out.println("=======================================");
        
        for (int i = 0; i < results.length; i++) {
            System.out.println((i + 1) + "\t" + results[i][0] + "\t" + results[i][1] + "\t\t" + results[i][2]);
        }
        
        System.out.println("\n========== Statistics ==========");
        System.out.println("Player Wins: " + stats[0]);
        System.out.println("Computer Wins: " + stats[1]);
        System.out.println("Player Win Percentage: " + stats[2] + "%");
        System.out.println("Computer Win Percentage: " + stats[3] + "%");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of games to play: ");
        int numberOfGames = sc.nextInt();
        sc.nextLine();
        
        String[][] gameResults = new String[numberOfGames][3];
        int playerWins = 0;
        int computerWins = 0;
        
        for (int i = 0; i < numberOfGames; i++) {
            System.out.print("\nGame " + (i + 1) + " - Enter your choice (Rock/Paper/Scissors): ");
            String playerChoice = sc.nextLine();
            
            String computerChoice = getComputerChoice();
            String winner = findWinner(playerChoice, computerChoice);
            
            gameResults[i][0] = playerChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;
            
            if (winner.equals("Player")) {
                playerWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            }
        }
        
        String[] stats = calculateStats(playerWins, computerWins, numberOfGames);
        displayResults(gameResults, stats, numberOfGames);
        
        sc.close();
    }
}
