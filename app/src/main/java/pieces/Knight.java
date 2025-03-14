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
        List<Direction> allowedDirections = Direction.knightDirection();

        for (Direction direction : allowedDirections) {
            int rowDiff = target.getRow() - source.getRow();
            int colDiff = target.getCol() - source.getCol();

            if (rowDiff == direction.getYDegree() && colDiff == direction.getXDegree()) {
                return !isSameColorPiece(target, board);
            }
        }
        return false;
    }
}
