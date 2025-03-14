package pieces;

import chess.Board;
import chess.Position;

import java.util.List;

public class King extends Piece {
    public King(Color color) {
        super(color, Type.KING);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        int rowDiff = Math.abs(source.getRow() - target.getRow());
        int colDiff = Math.abs(source.getCol() - target.getCol());

        if (rowDiff > 1 || colDiff > 1) {
            return false;
        }

        if (isSameColorPiece(target, board)) {
            return false;

        }
        return true;
    }
}
