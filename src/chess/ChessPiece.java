package chess;

public abstract class ChessPiece {

    private boolean killed = false;
    private boolean white = false;

    public ChessPiece(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }

    public abstract boolean isValidMove(int newX, int newY);
    public abstract boolean canMove(ChessBoard board, SquareSpot start, SquareSpot end);

}
