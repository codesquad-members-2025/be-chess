package pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import chess.*;

public class PawnTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();

    }

    @Test
    @DisplayName("Pawn 움직임 확인 - 첫 이동 2칸 전진")
    public void movePawn_TwoStepsFirstMove() {
        board.initialize();
        Position source = new Position("d2");
        Position target = new Position("d4"); // 첫 이동, 두 칸 이동 가능
        Piece pawn = board.getPiece(source.getRow(), source.getCol());

        assertThat(pawn.canMove(source, target, board)).isTrue();
    }

    @Test
    @DisplayName("Pawn 움직임 확인 - 한 칸 전진")
    public void movePawn_OneStepForward() {
        board.initialize();
        Position source = new Position("d2");
        Position target = new Position("d3"); // 한 칸 이동
        Piece pawn = board.getPiece(source.getRow(), source.getCol());

        assertThat(pawn.canMove(source, target, board)).isTrue();
    }

    @Test
    @DisplayName("Pawn 움직임 확인 - 첫 이동 아니면(행으로 판별) 두 칸 이동 불가")
    public void movePawn_CannotMoveTwoStepsAfterFirstMove() {
        board.initialize();
        board.addPiece("d3", new Pawn(Piece.Color.BLACK));
        Position source = new Position("d3");
        Position target = new Position("d5"); // 한 칸 이동
        Piece pawn = board.getPiece(source.getRow(), source.getCol());

        assertThat(pawn.canMove(source, target, board)).isFalse();
    }

    @Test
    @DisplayName("Pawn 공격 확인 - 대각선 이동 가능")
    public void movePawn_DiagonalCapture() {
        board.initialize();
        board.addPiece("e3", new Pawn(Piece.Color.BLACK)); // 상대 기물 배치
        Position source = new Position("d2");
        Position target = new Position("e3"); // 대각선 이동(공격)
        Piece pawn = board.getPiece(source.getRow(), source.getCol());

        assertThat(pawn.canMove(source, target, board)).isTrue();
    }

    @Test
    @DisplayName("Pawn 공격 불가 - 같은 색 기물이 있으면 대각선 이동 불가")
    public void movePawn_CannotCaptureSameColor() {
        board.initialize();
        board.addPiece("e3", new Pawn(Piece.Color.WHITE)); // 같은 색 기물 배치
        Position source = new Position("d2");
        Position target = new Position("e3"); // 대각선 이동(같은 색 기물 공격 불가)
        Piece pawn = board.getPiece(source.getRow(), source.getCol());

        assertThat(pawn.canMove(source, target, board)).isFalse();
    }
}

