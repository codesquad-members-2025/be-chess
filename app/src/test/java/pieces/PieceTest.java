package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PieceTest {
    @Test
    @DisplayName("Type의 문자 표현을 검증한다.")
    public void getRepresentation() throws Exception {
        assertThat(Piece.Type.PAWN.getWhiteRepresentation()).isEqualTo('p');
        assertThat(Piece.Type.PAWN.getBlackRepresentation()).isEqualTo('P');
    }

    @Test
    @DisplayName("모든 기물의 색과 출력문자를 검증한다")
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
        assertEquals(Type.NO_PIECE, blank.getType());

    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertTure(whitePiece.isWhite());
        assertThat(whitePiece.getType()).isEqualTo(type);

        assertTure(blackPiece.isBlack());
        assertTure(blackPiece.getTtpe()).isEqualsTo(type);
    }

    @Test
    @DisplayName("기물의 색을 검증한다(흰/검)")
    public void verifyColor() {
        Piece WhitePawn = Piece.createWhitePawn();
        Piece BlackPawn = Piece.createBlackPawn();

        assertThat(WhitePawn.isWhite()).isTrue();
        assertThat(BlackPawn.isBlack()).isTrue();
        assertThat(WhitePawn.isBlack()).isFalse();
        assertThat(BlackPawn.isWhite()).isFalse();

    }
}
