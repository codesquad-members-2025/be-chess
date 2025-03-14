package pieces;

import java.util.List;
import chess.Board;

public class Rook extends Piece {
    private Rook(Color color, Position position) {
        super(color, Type.ROOK, position);
    }

    public static Rook createRook(Color color, Position position) {
        return new Rook(color, position);
    }

    @Override
    public boolean canMove(Position target, Board board) {
        for (Direction dir : getDirections()) {
            Position cur = getPosition();
            while (true) {
                Position next = cur.move(dir);
                if (!isValid(next)) {
                    break;
                }

                if (next.equals(target)) {
                    return isMatchPosition(target, board);
                }

                if (board.findPiece(next).getType() != Type.NO_PIECE) {
                    break;
                }

                cur = next;
            }
        }
        return false;
    }

    private boolean isValid(Position position) {
        return position.getX() >= 0 && position.getX() < 8 &&
                position.getY() >= 0 && position.getY() < 8;
    }

    private boolean isMatchPosition(Position target, Board board) {
        Piece targetPiece = board.findPiece(target);
        return !targetPiece.getColor().equals(this.getColor());
    }

    @Override
    public List<Direction> getDirections() {
        return Direction.linearDirection();
    }
}