import java.awt.*;

public class Queen extends Piece {
    public Queen(boolean isWhite) {
        super(isWhite, "Q");
    }

    @Override
    public boolean isValidMove(Point from, Point to, Piece[][] board) {
        return new Rook(isWhite()).isValidMove(from, to, board) ||
                new Bishop(isWhite()).isValidMove(from, to, board);
    }
}
