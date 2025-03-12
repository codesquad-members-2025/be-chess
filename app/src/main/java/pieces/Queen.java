package pieces;

import chess.Board;
import java.util.List;

public class Queen extends Piece {
    private Queen(Color color, Position position) {
        super(color, Type.QUEEN, position);
    }

    public static Queen createQueen(Color color, Position position) {
        return new Queen(color, position);
    }

    @Override
    public boolean canMove(Position target, Board board) {
        for (Direction direction : getDirections()) {
            Position cur = getPosition();

            while(true) {
                Position next = cur.move(direction);

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

    private boolean isMatchPosition(Position target, Board board){
        Piece targetPiece = board.findPiece(target);
        return targetPiece.getType().equals(Type.NO_PIECE) || !targetPiece.getColor().equals(this.getColor());
    }

    @Override
    public List<Direction> getDirections() {
        return Direction.everyDirection();
    }
}