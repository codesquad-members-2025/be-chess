package pieces;

import chess.Board;
import chess.Position;

public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color, Type.PAWN);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        int rowDiff = target.getRow() - source.getRow();
        int colDiff = target.getCol() - source.getCol();

        // 흰색(White)은 위로 이동해야 하고, 검은색(Black)은 아래로 이동해야 함
//        int direction = (this.color == Color.WHITE) ? 1 : -1;
        return true;
    }

}
