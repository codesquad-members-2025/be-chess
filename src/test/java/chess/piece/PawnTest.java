package chess.piece;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {
    @Test
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(Piece.Color.WHITE, pawn.getColor());
        assertEquals("p", pawn.getSymbol());
    }

    @Test
    public void create() {
        verifyPawn(Piece.Color.BLACK, 'P');
        verifyPawn(Piece.Color.WHITE, 'p');
    }

    void verifyPawn(Piece.Color color , final char representation) {
        Pawn pawn = new Pawn(color);
        assertEquals(color, pawn.getColor());
        assertEquals(representation, pawn.getSymbol());
    }
}
