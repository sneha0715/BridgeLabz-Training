import java.util.Scanner;

public class CardDeckGame {
    
    public static String[] initializeDeck(String[] suits, String[] ranks) {
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int index = 0;
        
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index] = ranks[j] + " of " + suits[i];
                index++;
            }
        }
        
        return deck;
    }
    
    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        
        return deck;
    }
    
    public static String[][] distributeCards(String[] deck, int numPlayers, int cardsPerPlayer) {
        int totalCardsNeeded = numPlayers * cardsPerPlayer;
        
        if (totalCardsNeeded > deck.length) {
            System.out.println("Error: Not enough cards to distribute!");
            System.out.println("Total cards in deck: " + deck.length);
            System.out.println("Total cards needed: " + totalCardsNeeded);
            return null;
        }
        
        String[][] players = new String[numPlayers][cardsPerPlayer];
        int cardIndex = 0;
        
        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[cardIndex];
                cardIndex++;
            }
        }
        
        return players;
    }
    
    public static void displayPlayerCards(String[][] players) {
        System.out.println("\n========== Player Cards ==========");
        
        for (int i = 0; i < players.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + " cards:");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println("  " + (j + 1) + ". " + players[i][j]);
            }
        }
        
        System.out.println("\n==================================");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        
        int numOfCards = suits.length * ranks.length;
        
        System.out.println("========== Card Deck Game ==========");
        System.out.println("Total cards in deck: " + numOfCards);
        System.out.println("Suits: " + String.join(", ", suits));
        System.out.println("Ranks: " + String.join(", ", ranks));
        
        System.out.print("\nEnter number of players: ");
        int numPlayers = sc.nextInt();
        
        System.out.print("Enter number of cards per player: ");
        int cardsPerPlayer = sc.nextInt();
        
        if (numPlayers <= 0 || cardsPerPlayer <= 0) {
            System.out.println("Invalid input. Please enter positive numbers.");
            sc.close();
            return;
        }
        
        String[] deck = initializeDeck(suits, ranks);
        System.out.println("\nDeck initialized with " + deck.length + " cards.");
        
        deck = shuffleDeck(deck);
        System.out.println("Deck shuffled successfully.");
        
        String[][] players = distributeCards(deck, numPlayers, cardsPerPlayer);
        
        if (players != null) {
            displayPlayerCards(players);
        }
        
        sc.close();
    }
}
