package pieces;

import pieces.Piece.Type;
import static pieces.PieceFactory.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


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
        verifyPiece(createWhite(Type.PAWN), createBlack(Type.PAWN), Type.PAWN);
        verifyPiece(createWhite(Type.KNIGHT), createBlack(Type.KNIGHT), Type.KNIGHT);
        verifyPiece(createWhite(Type.ROOK), createBlack(Type.ROOK), Type.ROOK);
        verifyPiece(createWhite(Type.BISHOP), createBlack(Type.BISHOP), Type.BISHOP);
        verifyPiece(createWhite(Type.QUEEN), createBlack(Type.QUEEN), Type.QUEEN);
        verifyPiece(createWhite(Type.KING), createBlack(Type.KING), Type.KING);

        Piece blank = createBlank();
        assertFalse(blank.isWhite());
        assertFalse(blank.isBlack());
        assertThat(blank.getType()).isEqualTo(Type.NO_PIECE);

    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertTrue(whitePiece.isWhite());
        assertThat(whitePiece.getType()).isEqualTo(type);

        assertTrue(blackPiece.isBlack());
        assertThat(blackPiece.getType()).isEqualTo(type);
    }

}


