package chess.pieces;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PieceTest {
    @Test
    @DisplayName("각 기물의 생성 테스트")
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.WHITE_COLOR, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPiece(Piece.createBlackPawn(), Piece.BLACK_COLOR, Piece.BLACK_PAWN_REPRESENTATION);

        verifyPiece(Piece.createWhiteKing(), Piece.WHITE_COLOR, Piece.WHITE_KING_REPRESENTATION);
        verifyPiece(Piece.createBlackKing(), Piece.BLACK_COLOR, Piece.BLACK_KING_REPRESENTATION);

        verifyPiece(Piece.createWhiteQueen(), Piece.WHITE_COLOR, Piece.WHITE_QUEEN_REPRESENTATION);
        verifyPiece(Piece.createBlackQueen(), Piece.BLACK_COLOR, Piece.BLACK_QUEEN_REPRESENTATION);

        verifyPiece(Piece.createWhiteRook(), Piece.WHITE_COLOR, Piece.WHITE_ROOK_REPRESENTATION);
        verifyPiece(Piece.createBlackRook(), Piece.BLACK_COLOR, Piece.BLACK_ROOK_REPRESENTATION);

        verifyPiece(Piece.createWhiteBishop(), Piece.WHITE_COLOR, Piece.WHITE_BISHOP_REPRESENTATION);
        verifyPiece(Piece.createBlackBishop(), Piece.BLACK_COLOR, Piece.BLACK_BISHOP_REPRESENTATION);

        verifyPiece(Piece.createWhiteKnight(), Piece.WHITE_COLOR, Piece.WHITE_KNIGHT_REPRESENTATION);
        verifyPiece(Piece.createBlackKnight(), Piece.BLACK_COLOR, Piece.BLACK_KNIGHT_REPRESENTATION);
    }

    @Test
    @DisplayName("흰색 말 테스트")
    public void whiteColor() throws Exception{
        Piece whiteBishop = Piece.createWhiteBishop();
        Piece whitePawn = Piece.createWhitePawn();

        assertThat(whiteBishop.isWhite()).isTrue();
        assertThat(whitePawn.isWhite()).isTrue();
        assertThat(whiteBishop.isBlack()).isFalse();
        assertThat(whitePawn.isBlack()).isFalse();
    }

    @Test
    @DisplayName("검은 말 테스트")
    public void blackColor() throws Exception{
        Piece blackBishop = Piece.createBlackBishop();
        Piece blackPawn = Piece.createBlackPawn();

        assertThat(blackBishop.isBlack()).isTrue();
        assertThat(blackPawn.isBlack()).isTrue();
        assertThat(blackBishop.isWhite()).isFalse();
        assertThat(blackPawn.isWhite()).isFalse();
    }

    private void verifyPiece(final Piece piece, final String color, final char representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }
}

