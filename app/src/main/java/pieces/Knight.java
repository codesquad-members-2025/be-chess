package pieces;

import chess.Board;
import chess.Direction;
import chess.Position;
import java.util.List;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color, Type.KNIGHT);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        for (Direction direction : Direction.knightDirection()) {
            if (canMoveRecursive(source, target, direction, board)) {
                return true;
            }
        }
        return false;
    }
}
