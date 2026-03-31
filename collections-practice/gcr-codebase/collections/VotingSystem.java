import java.util.*;

public class VotingSystem {
    private HashMap<String, Integer> voteCount;
    
    public VotingSystem() {
        this.voteCount = new HashMap<>();
    }
    
    public void castVote(String candidate) {
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
    }
    
    public void displayResultsSorted() {
        System.out.println("=== Voting Results (Sorted by Candidate Name) ===");
        TreeMap<String, Integer> sortedResults = new TreeMap<>(voteCount);
        for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }
    
    public void displayResultsInOrder() {
        System.out.println("=== Voting Results (In Order of First Vote) ===");
        LinkedHashMap<String, Integer> orderedResults = new LinkedHashMap<>(voteCount);
        for (Map.Entry<String, Integer> entry : orderedResults.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }
    
    public void displayAllResults() {
        System.out.println("=== All Voting Results ===");
        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }
    
    public String getWinner() {
        if (voteCount.isEmpty()) return null;
        return voteCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
    
    public int getTotalVotes() {
        return voteCount.values().stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VotingSystem voting = new VotingSystem();
        
        boolean running = true;
        while (running) {
            System.out.println("=== Voting System ===");
            System.out.println("1. Cast a vote");
            System.out.println("2. Display results (sorted)");
            System.out.println("3. Display results (order of voting)");
            System.out.println("4. Display all results");
            System.out.println("5. Show winner");
            System.out.println("6. Show total votes");
            System.out.println("7. Exit");
            System.out.println("Enter choice:");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.println("Enter candidate name:");
                    String candidate = sc.nextLine();
                    voting.castVote(candidate);
                    System.out.println("Vote cast for " + candidate);
                    break;
                case 2:
                    voting.displayResultsSorted();
                    break;
                case 3:
                    voting.displayResultsInOrder();
                    break;
                case 4:
                    voting.displayAllResults();
                    break;
                case 5:
                    String winner = voting.getWinner();
                    if (winner != null) {
                        System.out.println("Winner: " + winner + " with " + voting.voteCount.get(winner) + " votes");
                    } else {
                        System.out.println("No votes cast yet");
                    }
                    break;
                case 6:
                    System.out.println("Total votes: " + voting.getTotalVotes());
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        
        sc.close();
    }
}
