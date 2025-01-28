import java.awt.*;

public class Bishop extends Piece {
    public Bishop(boolean isWhite) {
        super(isWhite, "B");
    }

    @Override
    public boolean isValidMove(Point from, Point to, Piece[][] board) {
        return Math.abs(from.x - to.x) == Math.abs(from.y - to.y);
    }
}
