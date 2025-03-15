package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.assertThat;
import chess.*;

public class RookTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("Rook 움직임 확인 - 직선")
    public void moveRook_Straight() {
        board.initialize();
        board.removePiece("a7"); //직선에 있는 PAWN 제거

        Position source = new Position("a8");
        Position target = new Position("a2");
        Piece Rook = board.getPiece(source.getRow(), source.getCol());


        assertThat(Rook.canMove(source, target, board)).isTrue();

    }

    @Test
    @DisplayName("Rook 움직임 예외처리 - 대각선")
    public void moveRook_Diagonal_exception() {
        board.initialize();
        board.removePiece("a7"); //직선에 있는 PAWN 제거
        board.removePiece("b7");

        Position source = new Position("a8");
        Position target = new Position("c6");
        Piece Rook = board.getPiece(source.getRow(), source.getCol());


        assertThat(Rook.canMove(source, target, board)).isFalse();

    }

    @Test
    @DisplayName("Rook 움직임 예외처리 - 중간에 장애물 있는 경우")
    public void moveRook_obstacle_exception() {
        board.initialize();
        board.removePiece("a7"); //직선에 있는 PAWN 제거

        Position source = new Position("a8");
        Position target = new Position("a1");
        Piece Rook = board.getPiece(source.getRow(), source.getCol());


        assertThat(Rook.canMove(source, target, board)).isFalse();

    }

}
