package pieces;

import chess.Board;
import chess.Direction;
import chess.Position;

import java.util.List;

public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color, Type.PAWN);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        int rowDiff = target.getRow() - source.getRow();
        int colDiff = target.getCol() - source.getCol();
        int moveDirection = (getColor() == Color.WHITE) ? 1 : -1; // 흰색은 위로(1), 검은색은 아래로(-1)


        // 직선 이동 (앞으로 한 칸 또는 두 칸 이동 가능)
        if (colDiff == 0) { // 가로 이동 X (직진만)
            int maxMove = isFirstMove(source) ? 2 : 1; // 첫 이동이면 2칸 가능
            if (rowDiff == moveDirection * 1 || (rowDiff == moveDirection * 2 && isFirstMove(source))) {
                return isPathClear(target, board);
            }
        }
        //  대각선 이동 (공격만 가능)
        if (Math.abs(colDiff) == 1 && rowDiff == moveDirection) { // 한 칸 대각선 이동
            if (board.getPiece(target.getRow(), target.getCol()).getType() != Type.NO_PIECE) {
                return !isSameColorPiece(target, board); // 상대 기물이 있으면 가능
            }
        }

        return false;
    }

    //  첫 이동인지 확인
    private boolean isFirstMove(Position source) {
        return (getColor() == Color.WHITE && source.getRow() == 1) ||
                (getColor() == Color.BLACK && source.getRow() == 6);
    }
}
