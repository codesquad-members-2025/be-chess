package org.chess.domain.piece;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    private static final String WHITE = "white";
    private static final String BLACK = "black";

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(WHITE);
        verifyPawn(BLACK);
    }

    private void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

    @Test
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertThat(WHITE).isEqualTo(pawn.getColor());
    }

}
