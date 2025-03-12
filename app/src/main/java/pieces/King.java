package pieces;

import chess.Board;
import java.util.List;

public class King extends Piece {
    private King(Color color, Position position) {
        super(color, Type.KING, position);
    }

    public static King createKing(Color color, Position position) {
        return new King(color, position);
    }

    @Override
    public boolean canMove(Position target, Board board) {
        Position cur = getPosition();
        for (Direction direction : getDirections()) {
            Position next = cur.move(direction);
            if (!isValid(next)){
                continue;
            }

            if (next.equals(target)) {
                return isMatchPosition(target, board);
            }
        }
        return false;
    }

    private boolean isMatchPosition(Position target, Board board){
        Piece targetPiece = board.findPiece(target);
        return targetPiece.getType().equals(Type.NO_PIECE) || !targetPiece.getColor().equals(getColor());
    }

    private boolean isValid(Position position) {
        return position.getX() >= 0 && position.getX() < 8 &&
                position.getY() >= 0 && position.getY() < 8;
    }

    @Override
    public List<Direction> getDirections() {
        return Direction.everyDirection();
    }
}
