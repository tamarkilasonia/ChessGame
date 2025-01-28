import java.awt.*;

public class King extends Piece {
    public King(boolean isWhite) {
        super(isWhite, "K");
    }

    @Override
    public boolean isValidMove(Point from, Point to, Piece[][] board) {
        int dx = Math.abs(from.x - to.x);
        int dy = Math.abs(from.y - to.y);
        return dx <= 1 && dy <= 1;
    }
}
