import java.util.Random;
import java.util.Scanner;
enum Cell{
    X,O,EMPTY
}
// with enum i set constant values for x,o,empty at cell. for readability.

public class TicTacToe {
    private Board board;
    private Player player1;
    private Player computerGamer;
    private Player currentPlayer;

   // constructor
    public TicTacToe(Player player1, Player player2) {
        this.board = new Board(); // creates a new board
        this.player1 = player1;
        this.computerGamer = player2;
        this.currentPlayer=player1;

    }

    // Function which gives allow to play the game.
    public void play() {
        while (true) {
            board.display();  // This code displays board
            int[] move = currentPlayer.makeMove(board);  // 2.Player makes move
            board.makeMove(move[0], move[1], currentPlayer.getSymbol());  // implements move to board.

            // Checks if there is winner or not.
            Cell winner = board.checkWinner();
            if (winner != null) {
                board.display();
                System.out.println("Player " + winner + " won!");
                break;
            }

            // Checks if there is draw situtation or not.
            if (board.isDraw()) {
                board.display();
                System.out.println("Game is draw!!");
                break;
            }

            // Cycle which allows to make move in order.
            currentPlayer = (currentPlayer == player1) ? computerGamer : player1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to go first? (yes/no): "); // Taking input for asking who wants to play first.
        String choice = scanner.nextLine();

        Player player1 = new Gamer(Cell.X);  // Player 1 with X symbol,
        Player computerPlayer = new computerGamer(Cell.O); // Computer with O symbol,

        TicTacToe game;
        if (choice.equalsIgnoreCase("yes")) {
            game = new TicTacToe(player1, computerPlayer); // Player plays first.
        } else {
            game = new TicTacToe(computerPlayer, player1); // If there is different answer than yes computer plays first.
        }

        game.play(); // Starting the game.
    }
}