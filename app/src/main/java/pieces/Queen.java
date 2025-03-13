package pieces;

import chess.Board;
import chess.Position;
import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
    public Queen(Color color) {
        super(color, Type.QUEEN);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        int rowDiff = Math.abs(source.getRow() - target.getRow());
        int colDiff =  Math.abs(source.getCol() - target.getCol());

        if (rowDiff != 0 && colDiff != 0) {
            return false;
        }

        isSameColorPiece(target, board);
        return true;
    }
}
