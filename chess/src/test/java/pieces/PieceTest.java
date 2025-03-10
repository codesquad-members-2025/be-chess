package pieces;

import chess.Piece;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class PieceTest {
    @Test
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.WHITE_COLOR, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPiece(Piece.createBlackPawn(), Piece.BLACK_COLOR, Piece.BLACK_PAWN_REPRESENTATION);


    }

    private void verifyPiece(final Piece piece, final String color, final char representation) {
        assertEquals(color, piece.getColor().getColorName());
        assertEquals(representation, piece.getColor().getRepresentation());
    }
}
