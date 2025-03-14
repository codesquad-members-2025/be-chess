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
    @DisplayName("King이 한 칸씩 이동할 수 있어야 한다")
    public void moveKingOneStep() {
        board.removePiece("e7"); // 이동할 위치를 비움
        Position source = new Position("e8");
        Position target = new Position("e7");
        Piece king = board.getPiece(source.getRow(), source.getCol());

        //king이 이돌할 수 있는지만 검증 (실제 이동 x)
        assertThat(king.canMove(source, target, board)).isTrue();
    }

    @Test
    @DisplayName("King은 한 칸 이상 이동할 수 없다")
    public void invalidKingMove() {
        Position source = new Position("e8");
        Position target = new Position("e6"); // 두 칸 이동 (잘못된 이동)
        Piece king = board.getPiece(source.getRow(), source.getCol());

        assertThat(king.canMove(source, target, board)).isFalse();
    }

    @Test
    @DisplayName("King이 같은 색 기물이 있는 곳으로 이동할 수 없다")
    public void kingCannotMoveToSameColorPiece() {
        Position source = new Position("e8");
        Position target = new Position("e7"); // 이미 같은 색 기물이 있음
        Piece king = board.getPiece(source.getRow(), source.getCol());

        assertThat(king.canMove(source, target, board)).isFalse();
    }
}
