package pieces;

import chess.Board;
import chess.Direction;
import chess.Position;
import java.util.List;

public class Rook extends Piece {
    public Rook(Color color) {
        super(color, Type.ROOK);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        for (Direction direction : Direction.linearDirection()) { // 룩은 직선 이동만 가능
            if (canMoveRecursive(source, target, direction, board)) {
                return true;
            }
        }
        return false;
    }
}
