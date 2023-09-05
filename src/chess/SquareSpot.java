package chess;

public class SquareSpot {
    private ChessPiece piece;
    private int x;
    private int y;

    public SquareSpot(int x, int y, ChessPiece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public ChessPiece getPiece() {
        return piece;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
