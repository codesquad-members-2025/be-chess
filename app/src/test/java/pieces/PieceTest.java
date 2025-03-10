package pieces;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PieceTest {

    @Test
    @DisplayName("흰색, 검은색 기물이 생성되어야 한다.")
    void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.Color.WHITE, Piece.Type.PAWN);
        verifyPiece(Piece.createBlackPawn(), Piece.Color.BLACK, Piece.Type.PAWN);

        verifyPiece(Piece.createWhiteRook(), Piece.Color.WHITE, Piece.Type.ROOK);
        verifyPiece(Piece.createBlackRook(), Piece.Color.BLACK, Piece.Type.ROOK);

        verifyPiece(Piece.createWhiteKnight(), Piece.Color.WHITE, Piece.Type.KNIGHT);
        verifyPiece(Piece.createBlackKnight(), Piece.Color.BLACK, Piece.Type.KNIGHT);

        verifyPiece(Piece.createWhiteBishop(), Piece.Color.WHITE, Piece.Type.BISHOP);
        verifyPiece(Piece.createBlackBishop(), Piece.Color.BLACK, Piece.Type.BISHOP);

        verifyPiece(Piece.createWhiteQueen(), Piece.Color.WHITE, Piece.Type.QUEEN);
        verifyPiece(Piece.createBlackQueen(), Piece.Color.BLACK, Piece.Type.QUEEN);

        verifyPiece(Piece.createWhiteKing(), Piece.Color.WHITE, Piece.Type.KING);
        verifyPiece(Piece.createBlackKing(), Piece.Color.BLACK, Piece.Type.KING);
    }

    private void verifyPiece(final Piece piece, final Piece.Color color, final Piece.Type representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getType()).isEqualTo(representation);
    }

    @Test
    @DisplayName("기물의 색상이 흰색이거나 검은색이어야한다.")
    void isWhiteAndBlack() {
        assertThat(Piece.createWhitePawn().isWhite()).isTrue();
        assertThat(Piece.createBlackPawn().isBlack()).isTrue();
    }
}
