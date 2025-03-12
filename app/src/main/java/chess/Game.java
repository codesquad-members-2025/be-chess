package chess;

import pieces.Piece;
import pieces.Piece.Type;

//move 관련 로직
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
        Position sourcePos = new Position(sourcePosition);
        Position targetPos = new Position(targetPosition);
        Piece piece = findPiece(sourcePosition);

        if (!piece.canMove(sourcePos, targetPos, board)) {
            return;
        }

        board.removePiece(sourcePosition);
        board.setPiece(targetPos.getRow(), targetPos.getCol(), piece);
    }
}
