package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.assertThat;
import chess.*;

public class BishopTest {
    private Board board;
    
    @BeforeEach
    public void setup() {
        board = new Board();
    }
    @Test
    @DisplayName("Bishop 움직임 확인 - 대각선")
    public void moveBishop_Straight() {
        board.initialize();
        board.removePiece("e7");

        Position source = new Position("f8");
        Position target = new Position("c5");
        Piece Bishop = board.getPiece(source.getRow(), source.getCol());


        assertThat(Bishop.canMove(source, target, board)).isTrue();

    }

    @Test
    @DisplayName("Bishop 움직임 예외처리 - 직선")
    public void moveBishop_Diagonal() {
        board.initialize();
        board.removePiece("f7");

        Position source = new Position("f8");
        Position target = new Position("f5");
        Piece Bishop = board.getPiece(source.getRow(), source.getCol());


        assertThat(Bishop.canMove(source, target, board)).isFalse();

    }
}
