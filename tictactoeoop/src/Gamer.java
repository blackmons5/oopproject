import java.util.Scanner;
class Gamer extends Player { // i extend gamer within player for using makeMove method.
    private Scanner scanner; // Scanner for user input.

    public Gamer(Cell symbol) { // Constructor for gamerClass
        super(symbol); // Calling symbol constructor from player class.
        scanner = new Scanner(System.in);
    }

    @Override
    public int[] makeMove(Board board) {
        int row, col;
        while (true) {
            System.out.print("Player " + getSymbol() + ", row (0-2): "); // Taking row input
            row = scanner.nextInt();
            System.out.print("Player " + getSymbol() + ", col (0-2): "); // Taking column input
            col = scanner.nextInt();
            if (row < 0 || row > 2 || col < 0 || col > 2) { // Check the inputs are valid with bounds.
                System.out.println("Unvalid row or column. Please pick the correct ones.");
            } else if (!board.isValidMove(row, col)) {
                System.out.println("The square is full,Please pick another square.");
            } else {
                break;  // If movement is valid break the code and continue.
            }
        }
        return new int[]{row, col}; // Return values as an array.
    }
}