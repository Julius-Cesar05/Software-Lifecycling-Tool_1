package org.example;

public class TicTacToe {

    private final Board board;
    private final Player playerX;
    private final Player playerO;
    private Player currentPlayer;

    public TicTacToe() {
        board = new Board();
        playerX = new Player('X');
        playerO = new Player('O');
        currentPlayer = playerX;
    }

    public boolean makeMove(int row, int col) {
        return board.placeSymbol(row, col, currentPlayer.getMarker());
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == playerX)
                ? playerO
                : playerX;
    }

    public void resetGame() {
        board.reset();
        currentPlayer = playerX;
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}