package pieces;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import pieces.Piece.*;

public class PieceTest {
    @Test
    @DisplayName("각 Refresentation당 모양이 일치해야한다.")
    public void getRepresentationPerPiece() throws Exception {
        assertThat(Piece.Type.PAWN.getWhiteRepresentation()).isEqualTo('p');
        assertThat(Piece.Type.PAWN.getBlackRepresentation()).isEqualTo('P');
    }

    @Test
    @DisplayName("기물의 색이 달라도 타입은 일치해야한다.")
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), Type.PAWN);
        verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), Type.KNIGHT);
        verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), Type.ROOK);
        verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), Type.BISHOP);
        verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), Type.QUEEN);
        verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), Type.KING);

        Piece blank = Piece.createBlank();
        assertFalse(blank.isWhite());
        assertFalse(blank.isBlack());
        assertThat(blank.getType()).isEqualTo(Type.NO_PIECE);
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertTrue(whitePiece.isWhite());
        assertThat(type).isEqualTo(whitePiece.getType());

        assertTrue(blackPiece.isBlack());
        assertThat(type).isEqualTo(blackPiece.getType());
    }
}
