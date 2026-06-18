
package org.example;



import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();

        boolean playAgain = true;

        while (playAgain) {

            boolean gameOver = false;

            while (!gameOver) {

                System.out.println("\nCurrent Player: "
                        + game.getCurrentPlayer().getMarker());

                game.getBoard().printBoard();

                System.out.print("Row (0-2): ");
                int row = scanner.nextInt();

                System.out.print("Column (0-2): ");
                int col = scanner.nextInt();

                if (!game.makeMove(row, col)) {
                    System.out.println("Invalid move! Try again.");
                    continue;
                }

                if (game.getBoard().checkWinner()) {

                    game.getBoard().printBoard();

                    System.out.println(
                            "Player "
                                    + game.getCurrentPlayer().getMarker()
                                    + " wins!"
                    );

                    gameOver = true;

                } else if (game.getBoard().isDraw()) {

                    game.getBoard().printBoard();

                    System.out.println("Draw!");

                    gameOver = true;

                } else {

                    game.switchPlayer();
                }
            }

            System.out.print("Start a new game? (y/n): ");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("y")) {
                game.resetGame();
            } else {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}


