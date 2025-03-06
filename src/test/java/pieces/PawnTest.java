package pieces;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    @Test
    public void createDefaultConstructor() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.COLOR_WHITE, pawn.getColor());
        assertEquals(Pawn.REPRESENTATION_WHITE, pawn.getRepresentation());
    }

    @Test
    public void create() {
        verifyPawn(Pawn.COLOR_WHITE, Pawn.REPRESENTATION_WHITE);
        verifyPawn(Pawn.COLOR_BLACK, Pawn.REPRESENTATION_BLACK);
    }

    void verifyPawn(final String color, final char representation) {
        Pawn pawn = new Pawn(color, representation);
        assertEquals(color, pawn.getColor());
        assertEquals(representation, pawn.getRepresentation());
    }
}