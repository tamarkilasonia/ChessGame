import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChessBoard extends JPanel {
    private final int TILE_SIZE = 100;
    private final int BOARD_SIZE = 8;
    private final Color LIGHT_TILE = new Color(240, 217, 181);
    private final Color DARK_TILE = new Color(181, 136, 99);

    private final Piece[][] board = new Piece[BOARD_SIZE][BOARD_SIZE];
    private Point selectedTile = null;
    private boolean isWhiteTurn = true;

    public ChessBoard() {
        setPreferredSize(new Dimension(BOARD_SIZE * TILE_SIZE, BOARD_SIZE * TILE_SIZE));
        initializeBoard();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int col = e.getX() / TILE_SIZE;
                int row = e.getY() / TILE_SIZE;

                if (selectedTile == null) {
                    if (board[row][col] != null && board[row][col].isWhite() == isWhiteTurn) {
                        selectedTile = new Point(row, col);
                        repaint();
                    }
                } else {
                    movePiece(selectedTile, new Point(row, col));
                    selectedTile = null;
                    repaint();
                }
            }
        });
    }

    private void initializeBoard() {
        // Place pawns
        for (int col = 0; col < BOARD_SIZE; col++) {
            board[1][col] = new Pawn(false);
            board[6][col] = new Pawn(true);
        }

        // Place rooks
        board[0][0] = new Rook(false);
        board[0][7] = new Rook(false);
        board[7][0] = new Rook(true);
        board[7][7] = new Rook(true);

        // Place knights
        board[0][1] = new Knight(false);
        board[0][6] = new Knight(false);
        board[7][1] = new Knight(true);
        board[7][6] = new Knight(true);

        // Place bishops
        board[0][2] = new Bishop(false);
        board[0][5] = new Bishop(false);
        board[7][2] = new Bishop(true);
        board[7][5] = new Bishop(true);

        // Place queens
        board[0][3] = new Queen(false);
        board[7][3] = new Queen(true);

        // Place kings
        board[0][4] = new King(false);
        board[7][4] = new King(true);
    }

    private void movePiece(Point from, Point to) {
        if (from.equals(to)) return;

        Piece piece = board[from.x][from.y];

        if (piece != null && piece.isWhite() == isWhiteTurn && piece.isValidMove(from, to, board)) {
            board[to.x][to.y] = piece;
            board[from.x][from.y] = null;
            isWhiteTurn = !isWhiteTurn; // Switch turns
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the board
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                g.setColor((row + col) % 2 == 0 ? LIGHT_TILE : DARK_TILE);
                g.fillRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);

                // Highlight selected tile
                if (selectedTile != null && selectedTile.x == row && selectedTile.y == col) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                }

                // Draw pieces
                if (board[row][col] != null) {
                    g.setColor(board[row][col].isWhite() ? Color.WHITE : Color.BLACK);
                    g.drawString(board[row][col].getType(), col * TILE_SIZE + TILE_SIZE / 2 - 5, row * TILE_SIZE + TILE_SIZE / 2 + 5);
                }
            }
        }
    }
}
