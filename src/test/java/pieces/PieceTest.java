package pieces;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {

    @Test
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.COLOR_WHITE, Piece.PAWN_WHITE);
        verifyPiece(Piece.createBlackPawn(), Piece.COLOR_BLACK, Piece.PAWN_BLACK);
        verifyPiece(Piece.createWhiteKnight(), Piece.COLOR_WHITE, Piece.KNIGHT_WHITE);
        verifyPiece(Piece.createBlackKnight(), Piece.COLOR_BLACK, Piece.KNIGHT_BLACK);
        verifyPiece(Piece.createWhiteRook(), Piece.COLOR_WHITE, Piece.ROOK_WHITE);
        verifyPiece(Piece.createBlackRook(), Piece.COLOR_BLACK, Piece.ROOK_BLACK);
        verifyPiece(Piece.createWhiteBishop(), Piece.COLOR_WHITE, Piece.BISHOP_WHITE);
        verifyPiece(Piece.createBlackBishop(), Piece.COLOR_BLACK, Piece.BISHOP_BLACK);
        verifyPiece(Piece.createWhiteQueen(), Piece.COLOR_WHITE, Piece.QUEEN_WHITE);
        verifyPiece(Piece.createBlackQueen(), Piece.COLOR_BLACK, Piece.QUEEN_BLACK);
        verifyPiece(Piece.createWhiteKing(), Piece.COLOR_WHITE, Piece.KING_WHITE);
        verifyPiece(Piece.createBlackKing(), Piece.COLOR_BLACK, Piece.KING_BLACK);
    }

    void verifyPiece(final Piece piece, final String color, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
    }
}