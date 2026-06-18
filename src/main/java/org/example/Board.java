
package org.example;

public class Board {

    private final char[][] board;

    public Board() {
        board = new char[3][3];
        reset();
    }

    public boolean placeSymbol(int row, int col, char symbol) {

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        if (board[row][col] != ' ') {
            return false;
        }

        board[row][col] = symbol;
        return true;
    }

    public boolean checkWinner() {


        for (int row = 0; row < 3; row++) {
            if (board[row][0] != ' '
                    && board[row][0] == board[row][1]
                    && board[row][1] == board[row][2]) {
                return true;
            }
        }


        for (int col = 0; col < 3; col++) {
            if (board[0][col] != ' '
                    && board[0][col] == board[1][col]
                    && board[1][col] == board[2][col]) {
                return true;
            }
        }


        if (board[0][0] != ' '
                && board[0][0] == board[1][1]
                && board[1][1] == board[2][2]) {
            return true;
        }

        if (board[0][2] != ' '
                && board[0][2] == board[1][1]
                && board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }

    public boolean isDraw() {

        if (checkWinner()) {
            return false;
        }

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    public void reset() {

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public void printBoard() {

        System.out.println("▁▁▁▁▁▁");

        for (int row = 0; row < 3; row++) {

            System.out.print("|");

            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + "|");
            }

            System.out.println();
        }

        System.out.println("▔▔▔▔▔▔");
    }

    public char[][] getBoard() {
        return board;
    }
}

