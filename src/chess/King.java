package chess;

public class King extends ChessPiece {
    private boolean castlingDone = false;

    public King(boolean white) {
        super(white);
    }

    public boolean isCastlingDone() {
        return this.castlingDone;
    }

    public void setCastlingDone(boolean castlingDone) {
        this.castlingDone = castlingDone;
    }


    @Override
    public boolean isValidMove(int newX, int newY) {
        return false;
    }

    @Override
    public boolean canMove(ChessBoard board, SquareSpot start, SquareSpot end) {
        // we can't move the piece to a Spot that
        // has a piece of the same color
        if (end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        if (x + y == 1) {
            // check if this move will not result in the king
            // being attacked if so return true
            return true;
        }

        return this.isValidCastling(board, start, end);
    }

    private boolean isValidCastling(ChessBoard board, SquareSpot start, SquareSpot end) {
        if (this.isCastlingDone()) {
            return false;
        }

        // Logic for returning true or false
        return false;
    }

    public boolean isCastlingMove(SquareSpot start, SquareSpot end) {
        // check if the starting and
        // ending position are correct
        return true;
    }
}
