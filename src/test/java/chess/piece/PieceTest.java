package chess.piece;

import chess.piece.Piece.Type;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {

    @Test
    public void create_piece() {
        verifyPiece(Piece.createWhite(Type.PAWN), Piece.createBlack(Type.PAWN), Type.PAWN);
        verifyPiece(Piece.createWhite(Type.KNIGHT), Piece.createBlack(Type.KNIGHT), Type.KNIGHT);
        verifyPiece(Piece.createWhite(Type.ROOK), Piece.createBlack(Type.ROOK), Type.ROOK);
        verifyPiece(Piece.createWhite(Type.BISHOP), Piece.createBlack(Type.BISHOP), Type.BISHOP);
        verifyPiece(Piece.createWhite(Type.QUEEN), Piece.createBlack(Type.QUEEN), Type.QUEEN);
        verifyPiece(Piece.createWhite(Type.KING), Piece.createBlack(Type.KING), Type.KING);

        Piece blank = Piece.createBlank();
        assertFalse(blank.isWhite());
        assertFalse(blank.isBlack());
        assertEquals(Type.NO_PIECE, blank.getType());
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getType());
        assertEquals(type.getWhiteRepresentation(), whitePiece.getSymbol());

        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getType());
        assertEquals(type.getBlackRepresentation(), blackPiece.getSymbol());
    }
}
