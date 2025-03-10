package pieces;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PieceTest {

    @Test
    @DisplayName("흰색, 검은색 기물이 생성되어야 한다.")
    void create() {
        verifyPiece(Piece.createWhitePawn(), Piece.Color.WHITE, Piece.Type.WHITE_PAWN);
        verifyPiece(Piece.createBlackPawn(), Piece.Color.BLACK, Piece.Type.BLACK_PAWN);

        verifyPiece(Piece.createWhiteRook(), Piece.Color.WHITE, Piece.Type.WHITE_ROOK);
        verifyPiece(Piece.createBlackRook(), Piece.Color.BLACK, Piece.Type.BLACK_ROOK);

        verifyPiece(Piece.createWhiteKnight(), Piece.Color.WHITE, Piece.Type.WHITE_KNIGHT);
        verifyPiece(Piece.createBlackKnight(), Piece.Color.BLACK, Piece.Type.BLACK_KNIGHT);

        verifyPiece(Piece.createWhiteBishop(), Piece.Color.WHITE, Piece.Type.WHITE_BISHOP);
        verifyPiece(Piece.createBlackBishop(), Piece.Color.BLACK, Piece.Type.BLACK_BISHOP);

        verifyPiece(Piece.createWhiteQueen(), Piece.Color.WHITE, Piece.Type.WHITE_QUEEN);
        verifyPiece(Piece.createBlackQueen(), Piece.Color.BLACK, Piece.Type.BLACK_QUEEN);

        verifyPiece(Piece.createWhiteKing(), Piece.Color.WHITE, Piece.Type.WHITE_KING);
        verifyPiece(Piece.createBlackKing(), Piece.Color.BLACK, Piece.Type.BLACK_KING);
    }

    private void verifyPiece(final Piece piece, final Piece.Color color, final Piece.Type representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }

    @Test
    @DisplayName("기물의 색상이 흰색이거나 검은색이어야한다.")
    void isWhiteAndBlack() {
        assertThat(Piece.createWhitePawn().isWhite()).isTrue();
        assertThat(Piece.createBlackPawn().isBlack()).isTrue();
    }
}
