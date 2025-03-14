package pieces;

import chess.Board;
import chess.Direction;
import chess.Position;

import java.util.List;

public class King extends Piece {
    public King(Color color) {
        super(color, Type.KING);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        int rowDiff = Math.abs(target.getRow() - source.getRow());
        int colDiff = Math.abs(target.getCol() - source.getCol());

        if (rowDiff <= 1 && colDiff <= 1) {
            return isPathClear(target, board) && !isSameColorPiece(target, board);
        }

        return false;
    }
}