package Unit_Testing.example;

public class TicTacToeTest {


    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();


        if (game.makeMove(1, 1)) {
            System.out.println("✓ Test 1 bestanden");
        } else {
            System.out.println("✗ Test 1 fehlgeschlagen");
        }


        if (!game.makeMove(1, 1)) {
            System.out.println("✓ Test 2 bestanden");
        } else {
            System.out.println("✗ Test 2 fehlgeschlagen");
        }


        game.switchPlayer();

        if (game.getCurrentPlayer().getMarker() == 'O') {
            System.out.println("✓ Test 3 bestanden");
        } else {
            System.out.println("✗ Test 3 fehlgeschlagen");
        }


        game.resetGame();

        if (game.getCurrentPlayer().getMarker() == 'X') {
            System.out.println("✓ Test 4 bestanden");
        } else {
            System.out.println("✗ Test 4 fehlgeschlagen");
        }

        System.out.println("Tests abgeschlossen.");
    }


}

