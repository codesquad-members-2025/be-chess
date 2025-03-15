package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.assertThat;
import chess.*;

public class QueenTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("Queen 움직임 확인 - 직선")
    public void moveQueen_Straight() {
        board.initialize();
        board.removePiece("d7"); //직선에 있는 PAWN 제거

        Position source = new Position("d8");
        Position target = new Position("d5");
        Piece Queen = board.getPiece(source.getRow(), source.getCol());


        assertThat(Queen.canMove(source, target, board)).isTrue();

    }

    @Test
    @DisplayName("Queen 움직임 확인 - 대각선")
    public void moveQueen_diagonal() {
        board.initialize();
        board.removePiece("c7"); //직선에 있는 PAWN 제거

        Position source = new Position("d8");
        Position target = new Position("b6");
        Piece Queen = board.getPiece(source.getRow(), source.getCol());


        assertThat(Queen.canMove(source, target, board)).isTrue();

    }
    @Test
    @DisplayName("Queen 움직임 예외처리 - 대각과 직선 아닌 곳")
    public void moveQueen_exception() {
        board.initialize();
        board.removePiece("d7"); //직선에 있는 PAWN 제거

        Position source = new Position("d8");
        Position target = new Position("b5");
        Piece Queen = board.getPiece(source.getRow(), source.getCol());


        assertThat(Queen.canMove(source, target, board)).isFalse();

    }
}

