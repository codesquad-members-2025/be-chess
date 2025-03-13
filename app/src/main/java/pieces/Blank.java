package pieces;

import chess.Board;
import chess.Position;

public class Blank extends Piece {
    public Blank() {
        super(Color.NOCOLOR, Type.NO_PIECE);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        return false; // 빈 칸은 이동할 수 없음
    }
}
