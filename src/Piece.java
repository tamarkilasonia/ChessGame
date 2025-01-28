import java.awt.*;

public abstract class Piece {
    private final boolean isWhite;
    private final String type;

    public Piece(boolean isWhite, String type) {
        this.isWhite = isWhite;
        this.type = type;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public String getType() {
        return type;
    }

    public abstract boolean isValidMove(Point from, Point to, Piece[][] board);
}
