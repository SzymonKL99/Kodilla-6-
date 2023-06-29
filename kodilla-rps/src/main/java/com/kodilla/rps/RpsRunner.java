import java.util.Random;
import java.util.Scanner;

class RockPaperScissorsGame {
    private String playerName;
    private int roundsToWin;
    private int playerWins;
    private int computerWins;
    private final Scanner scanner;
    private final Random random;

    public RockPaperScissorsGame() {
        scanner = new Scanner(System.in);
        random = new Random();
    }

    public static void main(String[] args) {
        RockPaperScissorsGame game = new RockPaperScissorsGame();
        game.start();
    }

    public void start() {
        System.out.println("Welcome to the game: ROCK-PAPER-SCISSORS");

        getPlayerName();
        getRoundsToWin();
        displayGameInstructions();

        boolean end = false;
        while (!end) {
            playRound();
            if (playerWins == roundsToWin || computerWins == roundsToWin) {
                displayGameSummary();
                end = askForNewGame();
            }
        }

        System.out.println("Thank you for game!");
        scanner.close();
    }

    private void getPlayerName() {
        System.out.print("Please get your name: ");
        playerName = scanner.nextLine();
    }

    private void getRoundsToWin() {
        System.out.print("Please give number of round to play: ");
        roundsToWin = scanner.nextInt();
        scanner.nextLine();
    }

    private void displayGameInstructions() {
        System.out.println("\nRules of game:");
        System.out.println("Key/1 - you will choose rock");
        System.out.println("Key/2 - you will choose paper");
        System.out.println("Key/3 - you will choose scissors");
        System.out.println("Key/x - press to end of the game  ");
        System.out.println("Key/n - start a new game\n");
    }

    private void playRound() {
        System.out.println("\nRound " + (playerWins + computerWins + 1));
        System.out.print(playerName + ", choose your move: ");
        int playerMove = getPlayerMove();
        int computerMove = generateComputerMove();
        displayMoves(playerMove, computerMove);
        determineRoundResult(playerMove, computerMove);
        displayScore();
    }

    private int getPlayerMove() {
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("1") || input.equalsIgnoreCase("2") || input.equalsIgnoreCase("3")) {
                return Integer.parseInt(input);
            } else if (input.equalsIgnoreCase("x")) {
                confirmGameExit();
            } else if (input.equalsIgnoreCase("n")) {
                confirmNewGame();
            } else {
                System.out.print("Wrong pick let's try again: ");
            }
        }
    }

    private int generateComputerMove() {
        return random.nextInt(3) + 1;
    }

    private void displayMoves(int playerMove, int computerMove) {
        System.out.println(playerName + " played: " + moveToString(playerMove));
        System.out.println("Computer played: " + moveToString(computerMove));
    }

    private String moveToString(int move) {
        if (move == 1) {
            return "rock";
        } else if (move == 2) {
            return "paper";
        } else if (move == 3) {
            return "scissors";
        }
        return "unknown movement";
    }

    private void determineRoundResult(int playerMove, int computerMove) {
        if (playerMove == computerMove) {
            System.out.println("Tie in this round!");
        } else if ((playerMove == 1 && computerMove == 3) ||
                (playerMove == 2 && computerMove == 1) ||
                (playerMove == 3 && computerMove == 2)) {
            System.out.println(playerName + " won this round!");
            playerWins++;
        } else {
            System.out.println("Computer won this round!");
            computerWins++;
        }
    }

    private void displayScore() {
        System.out.println("Actual score:");
        System.out.println(playerName + ": " + playerWins);
        System.out.println("Computer: " + computerWins);
    }

    private void displayGameSummary() {
        System.out.println("\n<SUMMARY OF THE GAME>");
        System.out.println("number of rounds won by " + playerName + ": " + playerWins);
        System.out.println("number of rounds won by computer: " + computerWins);

        if (playerWins > computerWins) {
            System.out.println(playerName + " won this game!!");
        } else if (playerWins < computerWins) {
            System.out.println("Computer won this game!");
        } else {
            System.out.println("Tie !!!");
        }
    }

    private boolean askForNewGame() {
        System.out.print("\nDo you want play again? (yes/no): ");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("no");
    }

    private void confirmGameExit() {
        System.out.print("Do you want end the game? (yes/no): ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("yes")) {
            System.out.println("Thank you for a game !");
            System.exit(0);
        }
    }

    private void confirmNewGame() {
        System.out.print("Do you definitively end the current game and start a new one?? (yes/no): ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("yes")) {
            resetGame();
        }
    }

    private void resetGame() {
        playerWins = 0;
        computerWins = 0;
        System.out.println("\nNew game started!");
    }
}
