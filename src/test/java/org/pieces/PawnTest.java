package org.pieces;

import org.junit.jupiter.api.*;
import org.pieces.Pawn;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {
    @Test
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(Pawn.WHITE_COLOR);
        assertThat(pawn.getRepresentation()).isEqualTo(Pawn.WHITE_REPRESENTATION);
    }

    @Test
    @DisplayName("두 가지 폰 생성")
    public void create() {
        verifyPawn(Pawn.WHITE_COLOR,Pawn.WHITE_REPRESENTATION);
        verifyPawn(Pawn.BLACK_COLOR,Pawn.BLACK_REPRESENTATION);
    }

    void verifyPawn(final String color, final char representation) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
        assertThat(pawn.getRepresentation()).isEqualTo(representation);
    }
}

