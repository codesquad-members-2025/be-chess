package org.chess;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {
    @Test
    @DisplayName("흰색 폰이 생성되어야한다")
    public void create() {
        verifyPawn("white");
        verifyPawn("black");
    }

    void verifyPawn(final String color){
        Pawn pawn = new Pawn(color);
        assertEquals(color,pawn.getColor());
    }
}
