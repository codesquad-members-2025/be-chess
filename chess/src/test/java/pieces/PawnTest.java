package pieces;


import chess.Piece;
import org.junit.Test; //  No matching tests found in any candidate test task. 에러 해결

import static org.junit.Assert.assertEquals;
public class PawnTest {
    @Test
    public void create_기본생성자() throws Exception {
        Piece pawn = new Piece(Piece.Color.WHITE, Piece.Type.PAWN);
        assertEquals(Piece.Color.WHITE, pawn.getColor());
        assertEquals(Piece.Color.WHITE, pawn.getColor());
    }
    @Test
    public void create() {
        verifyPawn(Piece.Color.WHITE, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPawn(Piece.Color.BLACK, Piece.BLACK_PAWN_REPRESENTATION);
    }

    void verifyPawn(final Piece.Color color, final char representation) {
        Piece pawn = new Piece(color, Piece.Type.PAWN);
        assertEquals(color, pawn.getColor());
        assertEquals(representation, pawn.getRepresentation());
    }
}
