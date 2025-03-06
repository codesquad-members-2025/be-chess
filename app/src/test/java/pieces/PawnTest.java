package pieces;

import chess.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;

public class PawnTest {
    private Pawn pawn;

    @BeforeEach
    public void setUp() {
        pawn = new Pawn(Pawn.BLACK);
    }

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() throws Exception {
        Pawn pawn = new Pawn();
        Assertions.assertEquals("white", pawn.getColor());
    }

    public void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}