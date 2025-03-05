package org.chess;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {
    @Test
    @DisplayName("두 가지 폰 생성")
    public void create() {
        verifyPawn("white");
        verifyPawn("black");
    }

    void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertThat(color).isEqualTo(pawn.getColor());
    }
}

