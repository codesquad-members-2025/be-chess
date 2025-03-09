package chess.pieces;

import chess.Direction;
import java.util.List;

public class Pawn extends Piece{
    private boolean hasMoved;  // 폰이 이미 움직였는지 여부
    public Pawn(Type type, Color color) {
        super(type, color, getDirectionByColor(color));
        this.hasMoved = false;
    }

    private static List<Direction> getDirectionByColor(Color color) {
        if (color.equals(Color.WHITE)) return Direction.whitePawnDirection();
        return Direction.blackPawnDirection();
    }
    @Override
    public void verifyMovePosition(int startX, int startY, int endX, int endY) {
        int dx = endX - startX;
        int dy = endY - startY;

        Direction moveDirection = findDirection(dx, dy);
        checkPieceCanMove(moveDirection);

        if (!hasMoved) {
            if (Math.abs(dy) == 2 && dx == 0) {
                // 2칸 전진 이동 (첫 번째만 가능)
                hasMoved = true;
                return;
            }
        }

        // 이후 이동은 한 칸씩만 가능
        if (Math.abs(dy) == 1 && dx == 0) {
            return;
        }

        // 대각선 이동은 적을 잡을 때만 가능
        if (Math.abs(dx) == 1 && Math.abs(dy) == 1) {
            return;
        }

        throw new IllegalArgumentException("폰의 이동 규칙을 위반했습니다.");
    }
    @Override
    protected Direction findDirection(int dx, int dy) {
        if (dx == 0 && dy == 0) return null; // 자기 위치 유지

        return getDirectionByCurrentExactly(dx, dy);
    }


}


