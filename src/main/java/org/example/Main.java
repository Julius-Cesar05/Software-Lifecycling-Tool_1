package org.example;

public class Main {
    public static void main(String[] args) {

        Board board = new Board();

        board.place(1, 1, 'X');
        board.place(0, 2, 'O');

        board.print();
    }
}
