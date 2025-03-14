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
        List<Direction> allowedDirections = Direction.linearDirection(); // 룩은 직선 이동만 가능

        for (Direction direction : allowedDirections) {
            int rowDiff = target.getRow() - source.getRow();
            int colDiff = target.getCol() - source.getCol();

            if (rowDiff % direction.getYDegree() == 0 && colDiff % direction.getXDegree() == 0) {
                return isPathClear(source, target, board) && !isSameColorPiece(target, board);
            }
        }
        return false; // 이동 불가능한 경우
    }
}
