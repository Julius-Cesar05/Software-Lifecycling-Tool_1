package org.example;

import java.util.Scanner;
public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver) {

            System.out.println("Current Player: " + currentPlayer.getMarker());
            printBoard();

            System.out.print("row (0-2): ");
            int row = scanner.nextInt();

            System.out.print("column (0-2): ");
            int column = scanner.nextInt();

            if (!board.isCellEmpty(row, column)) {
                System.out.println("Cell already taken!");
                continue;
            }

            board.place(row, column, currentPlayer.getMarker());

            if (hasWinner()) {
                printBoard();
                System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                gameOver = true;

            } else if (board.isFull()) {
                printBoard();
                System.out.println("Draw!");
                gameOver = true;

            } else {
                switchCurrentPlayer();
            }
        }
    }

    private void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    private boolean hasWinner() {

        char marker = currentPlayer.getMarker();
        char[][] cells = board.getCells();

        for (int i = 0; i < 3; i++) {

            if (cells[i][0] == marker &&
                    cells[i][1] == marker &&
                    cells[i][2] == marker) {
                return true;
            }

            if (cells[0][i] == marker &&
                    cells[1][i] == marker &&
                    cells[2][i] == marker) {
                return true;
            }
        }

        if (cells[0][0] == marker &&
                cells[1][1] == marker &&
                cells[2][2] == marker) {
            return true;
        }

        if (cells[0][2] == marker &&
                cells[1][1] == marker &&
                cells[2][0] == marker) {
            return true;
        }

        return false;
    }

    private void printBoard() {

        char[][] cells = board.getCells();

        System.out.println("▁▁▁▁▁▁");

        for (int i = 0; i < 3; i++) {
            System.out.println("|" +
                    cells[i][0] + "|" +
                    cells[i][1] + "|" +
                    cells[i][2] + "|");
        }

        System.out.println("▔▔▔▔▔▔");
    }
}