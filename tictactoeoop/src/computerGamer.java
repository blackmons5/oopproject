import java.util.Random;
class computerGamer extends Player {
    public computerGamer(Cell symbol) { // Constructor for computerGamer class
        super(symbol); // Calling symbol constructor from player class.
    }

    @Override
    public int[] makeMove(Board board) {
        int row, col;
        Random random = new Random();
        while (true) {
            row = random.nextInt(3);
            col = random.nextInt(3);
            if (board.isValidMove(row, col)) {
                System.out.println("Computer plays at: " + row + ", " + col);
                break;  // Exit loop if a valid move is found
            }
        }
        return new int[]{row, col}; // Return the row and column of the move
    }
}