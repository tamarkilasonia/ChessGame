import java.awt.*;

public class Rook extends Piece {
    public Rook(boolean isWhite) {
        super(isWhite, "R");
    }

    @Override
    public boolean isValidMove(Point from, Point to, Piece[][] board) {
        return from.x == to.x || from.y == to.y;
    }
}

