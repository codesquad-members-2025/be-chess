package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.assertThat;
import chess.*;

public class KingTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
        board.initialize();
    }

    @Test
    @DisplayName("King움직임 확인 - 8방향으로 한 칸만 움직일 수 있음")
    public void moveKing() {
        board.removePiece("e7"); // 이동할 위치를 제거 -> 나중에 PAWN 구현하면 PAWN 이동시키기
        Position source = new Position("e8");
        Position target = new Position("e7");
        Piece king = board.getPiece(source.getRow(), source.getCol());

        //king이 이돌할 수 있는지만 검증 (실제 이동 x, canMove만 확인)
        assertThat(king.canMove(source, target, board)).isTrue();
    }

    @Test
    @DisplayName("King움직임 예외 처리 - 한 칸 이상 움지일 수 없음")
    public void invalidKingMove() {
        Position source = new Position("e8");
        Position target = new Position("e6"); // 두 칸 이동
        Piece king = board.getPiece(source.getRow(), source.getCol());

        assertThat(king.canMove(source, target, board)).isFalse();
    }

    //이 예외처리는 GameMove에서 해도 될 것 같음.
    @Test
    @DisplayName("King움직임 예외 처리 - 목적지에 같은 색 기물 있으면 이동 불가")
    public void kingCannotMoveToSameColorPiece() {
        Position source = new Position("e8");
        Position target = new Position("e7"); // 같은 색 기물
        Piece king = board.getPiece(source.getRow(), source.getCol());

        assertThat(king.canMove(source, target, board)).isFalse();
    }
}
