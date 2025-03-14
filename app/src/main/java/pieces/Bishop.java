package pieces;

import chess.Board;
import chess.Direction;
import chess.Position;
import java.util.List;

public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color, Type.BISHOP);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        for (Direction direction : Direction.diagonalDirection()) {
            if (canMoveRecursive(source, target, direction, board)) {
                return true;
            }
        }
        return false;
    }
}
