import java.util.Random;

public class SnakeAndLadderGame {

    static final int WINNING_POSITION = 100;
    static final int NO_PLAY = 0;
    static final int LADDER = 1;
    static final int SNAKE = 2;

    static Random random = new Random();

    public static int rollDice() {
        return random.nextInt(6) + 1;
    }

    public static int checkOption() {
        return random.nextInt(3); // 0-No Play, 1-Ladder, 2-Snake
    }

    public static void main(String[] args) {

        int player1Position = 0;
        int player2Position = 0;
        int diceCount = 0;
        boolean isPlayer1Turn = true;

        System.out.println(" Snake and Ladder Game Started ");

        while (player1Position < WINNING_POSITION && player2Position < WINNING_POSITION) {

            int dice = rollDice();
            int option = checkOption();
            diceCount++;

            if (isPlayer1Turn) {
                System.out.println("Player 1 rolled: " + dice);

                switch (option) {
                    case NO_PLAY:
                        System.out.println("Player 1: No Play");
                        break;

                    case LADDER:
                        System.out.println("Player 1: Ladder");
                        if (player1Position + dice <= WINNING_POSITION) {
                            player1Position += dice;
                        }
                        System.out.println("Player 1 plays again");
                        break;

                    case SNAKE:
                        System.out.println("Player 1: Snake");
                        player1Position -= dice;
                        break;
                }

                if (player1Position < 0) {
                    player1Position = 0;
                }

                System.out.println("Player 1 Position: " + player1Position);

                if (option != LADDER) {
                    isPlayer1Turn = false;
                }

            } else {
                System.out.println("Player 2 rolled: " + dice);

                switch (option) {
                    case NO_PLAY:
                        System.out.println("Player 2: No Play");
                        break;

                    case LADDER:
                        System.out.println("Player 2: Ladder");
                        if (player2Position + dice <= WINNING_POSITION) {
                            player2Position += dice;
                        }
                        System.out.println("Player 2 plays again");
                        break;

                    case SNAKE:
                        System.out.println("Player 2: Snake");
                        player2Position -= dice;
                        break;
                }

                if (player2Position < 0) {
                    player2Position = 0;
                }

                System.out.println("Player 2 Position: " + player2Position);

                if (option != LADDER) {
                    isPlayer1Turn = true;
                }
            }
        }

        System.out.println(" GAME OVER");
        System.out.println("Total Dice Rolls: " + diceCount);

        if (player1Position == WINNING_POSITION) {
            System.out.println("Player 1 WON the game!");
        } else {
            System.out.println("Player 2 WON the game!");
        }
    }
}
