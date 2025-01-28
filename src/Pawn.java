import java.awt.*;

public class Pawn extends Piece {
    public Pawn(boolean isWhite) {
        super(isWhite, "P");
    }

    @Override
    public boolean isValidMove(Point from, Point to, Piece[][] board) {
        int direction = isWhite() ? -1 : 1;

        if (from.y == to.y && board[to.x][to.y] == null) {
            return to.x == from.x + direction;
        }

        if (Math.abs(from.y - to.y) == 1 && to.x == from.x + direction) {
            return board[to.x][to.y] != null && board[to.x][to.y].isWhite() != isWhite();
        }

        return false;
    }
}
