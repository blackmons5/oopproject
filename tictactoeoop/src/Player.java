abstract class Player {
    protected Cell symbol;  //  I used protected for using symbol at gamer and Computergamer.

    public Player(Cell symbol) {
        this.symbol = symbol;
    } // The player just play with symbols (X and O).

    // For symbol i used getter method.
    public Cell getSymbol() {
        return symbol;
    }

    // Each player plays their own move. thanks for abstract class.
    public abstract int[] makeMove(Board board);
}