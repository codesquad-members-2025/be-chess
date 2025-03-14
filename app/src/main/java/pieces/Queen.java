package pieces;

import chess.Board;
import chess.Direction;
import chess.Position;


public class Queen extends Piece {
    public Queen(Color color) {
        super(color, Type.ROOK);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        for (Direction direction : Direction.everyDirection()) { // 룩은 직선 이동만 가능
            if (canMoveRecursive(source, target, direction, board)) {
                return true;
            }
        }
        return false;
    }
}
