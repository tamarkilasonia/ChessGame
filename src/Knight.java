import java.awt.*;

public class Knight extends Piece {
    public Knight(boolean isWhite) {
        super(isWhite, "N");
    }

    @Override
    public boolean isValidMove(Point from, Point to, Piece[][] board) {
        int dx = Math.abs(from.x - to.x);
        int dy = Math.abs(from.y - to.y);
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }
}
