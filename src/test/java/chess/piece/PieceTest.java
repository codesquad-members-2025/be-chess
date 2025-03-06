package chess.piece;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {
    @Test
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.Color.WHITE, 'p');
        verifyPiece(Piece.createBlackPawn(), Piece.Color.BLACK, 'P');


    }

    private void verifyPiece(final Piece piece, Piece.Color color , final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getSymbol());
    }
}
