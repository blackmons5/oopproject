public class Board {
    private Cell[][] board;  // Encapsullation for limit the reaching.

    public Board() {
        board = new Cell[3][3]; // initialize 3 x 3 board
        // All cells should be empty at the start of the game.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Cell.EMPTY; //set empty at first.
            }
        }
    }

    // This code block displays board with x and o's.
    public void display() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] == Cell.EMPTY ? " " : board[i][j]); // Print the symbol in the cell empty or (x , O).
                if (j < 2) System.out.print("|");
            }
            System.out.println(); // Move the next line
            if (i < 2) System.out.println("-----");
        }
    }

    // this code block placing x and o's to board.
    public boolean makeMove(int row, int col, Cell symbol) {
        // checking valid mofe after placing symbol.
        if (isValidMove(row, col)) {
            board[row][col] = symbol;
            return true; // Move was right.
        }
        return false; // Return false if move is invalid.
    }

    // This code block controls is it valid move or not.
    public boolean isValidMove(int row, int col) {
        return board[row][col] == Cell.EMPTY;
    }

    // This code block controls if there is winner or loser.
    public Cell checkWinner() {
        //  This code block controls rows,columns and crosses.
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != Cell.EMPTY) {
                return board[i][0];
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != Cell.EMPTY) {
                return board[0][i];
            }
        }

        // Crosses.
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != Cell.EMPTY) {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != Cell.EMPTY) {
            return board[0][2];
        }

        return null;  // If there is no winner returns null.
    }

    // its controlling any draw situtation on code
    public boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Cell.EMPTY) {
                    return false;  // if still has empty square it continues.
                }
            }
        }
        return true;  // if there is no space in board it returns draw.
    }
}