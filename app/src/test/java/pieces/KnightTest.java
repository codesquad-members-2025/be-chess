package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.assertThat;
import chess.*;

public class KnightTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("Knight 움직임 확인")
    public void moveKnight_Straight() {
        board.initialize();
        board.removePiece("b7");
        board.removePiece("c7");

        Position source = new Position("b8");
        Position target = new Position("c6");
        Piece Knight = board.getPiece(source.getRow(), source.getCol());


        assertThat(Knight.canMove(source, target, board)).isTrue();

    }
}