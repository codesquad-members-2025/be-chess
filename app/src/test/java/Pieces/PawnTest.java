package Pieces;

import org.junit.jupiter.api.*;
import pieces.Pawn;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    @Test
    @DisplayName("흰색 또는 검은색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn("white");
        verifyPawn("black");
    }

    @Test
    @DisplayName("색상을 지정하지 않으면 흰색 폰이 생성되어야 한다")
    public void create_default_constructor() {
        Pawn pawn = new Pawn();
        assertEquals("white", pawn.getColor());
    }

    void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor().equals(color));
    }
}
