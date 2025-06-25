//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            String moveA = getValidMove(scanner, "Player A");
            String moveB = getValidMove(scanner, "Player B");

            System.out.println("\nPlayer A chose: " + moveA.toUpperCase());
            System.out.println("Player B chose: " + moveB.toUpperCase());

            printResult(moveA.toUpperCase(), moveB.toUpperCase());

            System.out.print("\nPlay again? [Y/N]: ");
            String choice = scanner.nextLine().trim();
            playAgain = choice.equalsIgnoreCase("Y");

        } while (playAgain);

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static String getValidMove(Scanner scanner, String player) {
        String move;
        while (true) {
            System.out.print(player + ", enter your move (R, P, S): ");
            move = scanner.nextLine().trim();
            if (move.equalsIgnoreCase("R") || move.equalsIgnoreCase("P") || move.equalsIgnoreCase("S")) {
                break;
            }
            System.out.println("Invalid move. Please enter R, P, or S.");
        }
        return move;
    }

    private static void printResult(String moveA, String moveB) {
        if (moveA.equals(moveB)) {
            System.out.println("It's a Tie! " + moveA + " vs " + moveB);
        } else if ((moveA.equals("R") && moveB.equals("S")) ||
                (moveA.equals("P") && moveB.equals("R")) ||
                (moveA.equals("S") && moveB.equals("P"))) {
            System.out.println(getPhrase(moveA, moveB));
            System.out.println("Player A wins!");
        } else {
            System.out.println(getPhrase(moveB, moveA));
            System.out.println("Player B wins!");
        }
    }

    private static String getPhrase(String winner, String loser) {
        if (winner.equals("R") && loser.equals("S")) return "Rock breaks Scissors.";
        if (winner.equals("P") && loser.equals("R")) return "Paper covers Rock.";
        if (winner.equals("S") && loser.equals("P")) return "Scissors cuts Paper.";
        return "";
    }
}