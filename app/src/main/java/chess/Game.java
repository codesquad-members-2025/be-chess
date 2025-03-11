package chess;

import pieces.Piece;
import pieces.Piece.Type;

public class Game {
    private final Board board;

    public Game(Board board) {
        this.board = board;
    }

    public Piece findPiece(String position) {
        Position pos = new Position(position);
        return board.getRank(pos.getRow()).getPiece(pos.getCol());
    }

    public void move(String sourcePosition, String targetPosition) {
        Position targetPos = new Position(targetPosition);
        Piece piece = findPiece(sourcePosition);
        board.removePiece(sourcePosition);
        board.setPiece(targetPos.getRow(), targetPos.getCol(), piece);
    }
}
