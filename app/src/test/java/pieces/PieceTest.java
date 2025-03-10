package pieces;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PieceTest {

    @Test
    @DisplayName("흰색, 검은색 기물이 생성되어야 한다.")
    void create() {
        verifyPiece(Piece.createWhitePawn(), Piece.Color.WHITE, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPiece(Piece.createBlackPawn(), Piece.Color.BLACK, Piece.BLACK_PAWN_REPRESENTATION);

        verifyPiece(Piece.createWhiteRook(), Piece.Color.WHITE, Piece.WHITE_ROOK_REPRESENTATION);
        verifyPiece(Piece.createBlackRook(), Piece.Color.BLACK, Piece.BLACK_ROOK_REPRESENTATION);

        verifyPiece(Piece.createWhiteKnight(), Piece.Color.WHITE, Piece.WHITE_KNIGHT_REPRESENTATION);
        verifyPiece(Piece.createBlackKnight(), Piece.Color.BLACK, Piece.BLACK_KNIGHT_REPRESENTATION);

        verifyPiece(Piece.createWhiteBishop(), Piece.Color.WHITE, Piece.WHITE_BISHOP_REPRESENTATION);
        verifyPiece(Piece.createBlackBishop(), Piece.Color.BLACK, Piece.BLACK_BISHOP_REPRESENTATION);

        verifyPiece(Piece.createWhiteQueen(), Piece.Color.WHITE, Piece.WHITE_QUEEN_REPRESENTATION);
        verifyPiece(Piece.createBlackQueen(), Piece.Color.BLACK, Piece.BLACK_QUEEN_REPRESENTATION);

        verifyPiece(Piece.createWhiteKing(), Piece.Color.WHITE, Piece.WHITE_KING_REPRESENTATION);
        verifyPiece(Piece.createBlackKing(), Piece.Color.BLACK, Piece.BLACK_KING_REPRESENTATION);
    }

    private void verifyPiece(final Piece piece, final Piece.Color color, final char representation) {
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
