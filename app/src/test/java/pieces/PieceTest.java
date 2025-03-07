package pieces;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {

    @Test
    @DisplayName("흰색 또는 검은색 폰이 생성되어야 한다")
    public void create_piece() {
        verifyPawn(Piece.createWhitePawn(), Piece.WHITE_COLOR, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPawn(Piece.createBlackPawn(), Piece.BLACK_COLOR, Piece.BLACK_PAWN_REPRESENTATION);
    }

    @Test
    @DisplayName("흰색, 검은색 룩이 생성되어야 한다")
    public void create_piece() {
        verifyPawn(Piece.createWhiteRook(), Piece.WHITE_COLOR, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPawn(Piece.createBlackRook(), Piece.BLACK_COLOR, Piece.BLACK_PAWN_REPRESENTATION);
    }

    private void verifyPawn(final Piece piece, final String color, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
    }
}
