package org.pieces;

import org.junit.jupiter.api.*;
import org.pieces.Pawn;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {
    @Test
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertThat(Pawn.WHITE_COLOR).isEqualTo(pawn.getColor());
        assertThat(Pawn.WHITE_REPRESENTATION).isEqualTo(pawn.getRepresentation());
    }

    @Test
    @DisplayName("두 가지 폰 생성")
    public void create() {
        verifyPawn(Pawn.WHITE_COLOR,Pawn.WHITE_REPRESENTATION);
        verifyPawn(Pawn.BLACK_COLOR,Pawn.BLACK_REPRESENTATION);
    }

    void verifyPawn(final String color, final char representation) {
        Pawn pawn = new Pawn(color);
        assertThat(color).isEqualTo(pawn.getColor());
        assertThat(representation).isEqualTo(pawn.getRepresentation());
    }
}

