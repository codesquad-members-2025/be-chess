package chess.pieces;
import org.junit.jupiter.api.*;

import static chess.pieces.Piece.*;
import static chess.pieces.Piece.Type.*;
import static org.assertj.core.api.Assertions.*;

public class PieceTest {
    @Test
    @DisplayName("각 기물의 생성 테스트")
    public void create_piece() {
        verifyPiece(Piece.createWhite(PAWN), Piece.createBlack(PAWN), PAWN);
        verifyPiece(Piece.createWhite(KNIGHT), Piece.createBlack(KNIGHT), KNIGHT);
        verifyPiece(Piece.createWhite(ROOK), Piece.createBlack(ROOK), ROOK);
        verifyPiece(Piece.createWhite(BISHOP), Piece.createBlack(BISHOP), BISHOP);
        verifyPiece(Piece.createWhite(QUEEN), Piece.createBlack(QUEEN), QUEEN);
        verifyPiece(Piece.createWhite(KING), Piece.createBlack(KING), KING);

        Piece blank = Piece.createBlank();
        assertThat(blank.isWhite()).isFalse();
        assertThat(blank.isBlack()).isFalse();
        assertThat(blank.getType()).isEqualTo(NO_PIECE);
    }

    @Test
    @DisplayName("흰색 말 테스트")
    public void whiteColor() throws Exception{

        Piece whiteBishop = createWhite(BISHOP);
        Piece whitePawn = createWhite(PAWN);

        assertThat(whiteBishop.isWhite()).isTrue();
        assertThat(whitePawn.isWhite()).isTrue();
        assertThat(whiteBishop.isBlack()).isFalse();
        assertThat(whitePawn.isBlack()).isFalse();
    }

    @Test
    @DisplayName("검은 말 테스트")
    public void blackColor() throws Exception{
        Piece blackBishop = createBlack(BISHOP);
        Piece blackPawn = createBlack(PAWN);

        assertThat(blackBishop.isBlack()).isTrue();
        assertThat(blackPawn.isBlack()).isTrue();
        assertThat(blackBishop.isWhite()).isFalse();
        assertThat(blackPawn.isWhite()).isFalse();
    }

    @Test
    @DisplayName("기물의 representation이 잘 할당 되었는지 테스트")
    public void getRepresentationPerPiece() throws Exception {
        assertThat(PAWN.getWhiteRepresentation()).isEqualTo('p');
        assertThat(PAWN.getBlackRepresentation()).isEqualTo('P');
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertThat(whitePiece.isWhite()).isTrue();
        assertThat(whitePiece.getType()).isEqualTo(type);

        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(blackPiece.getType()).isEqualTo(type);
    }
}

