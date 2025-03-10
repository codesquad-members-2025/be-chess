package pieces;

import chess.Color;
import chess.Piece;
import chess.Type;
import org.junit.Test; //  No matching tests found in any candidate test task. 에러 해결

import static org.junit.Assert.assertEquals;
public class PawnTest {
    @Test
    public void create_기본생성자() throws Exception {
        Piece pawn = new Piece(Color.WHITE, Type.PAWN);
        assertEquals(Color.WHITE, pawn.getColor());
        assertEquals(Color.WHITE.getRepresentation(), pawn.getColor().getRepresentation());
    }
    @Test
    public void create() {
        verifyPawn(Color.WHITE, Piece.WHITE_REPRESENTATION);
        verifyPawn(Color.BLACK, Piece.BLACK_REPRESENTATION);
    }

    void verifyPawn(final Color color, final char representation) {
        Piece pawn = new Piece(color, Type.PAWN);
        assertEquals(color, pawn.getColor());
        assertEquals(representation, pawn.getColor().getRepresentation());
    }
}
