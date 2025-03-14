package pieces;

import chess.Board;
import chess.Direction;
import chess.Position;
import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
    public Queen(Color color) {
        super(color, Type.QUEEN);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        List<Direction> allowedDirections = new ArrayList<>();
        allowedDirections.addAll(Direction.linearDirection());
        allowedDirections.addAll(Direction.diagonalDirection());

        for (Direction direction : allowedDirections) {
            int rowDiff = target.getRow() - source.getRow();
            int colDiff = target.getCol() - source.getCol();


            if (rowDiff % direction.getYDegree() == 0 && colDiff % direction.getXDegree() == 0) {
                return isPathClear(source, target, board) && !isSameColorPiece(target, board);
            }
        }
        return false;
    }
}

