package pieces;

import chess.Board;
import java.util.List;

public class Knight extends Piece {
    private Knight(Color color, Position position) {
        super(color, Type.KNIGHT, position);
    }

    public static Knight createKnight(Color color, Position position) {
        return new Knight(color, position);
    }

    @Override
    public boolean canMove(Position target, Board board) {
        Position cur = getPosition();
        for(Direction direction : Direction.values()) {
            Position next  = cur.move(direction);
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
        return Direction.knightDirection();
    }
}
