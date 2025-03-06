package chess.pieces;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class PieceTest {
    @Test
    @DisplayName("모든 체스말의 색과 출력문자를 검증한다.")
    void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Color.WHITE, Type.PAWN.getRepresentation(Color.WHITE));
        verifyPiece(Piece.createBlackPawn(), Color.BLACK, Type.PAWN.getRepresentation(Color.BLACK));

        verifyPiece(Piece.createWhiteKnight(), Color.WHITE, Type.KNIGHT.getRepresentation(Color.WHITE));
        verifyPiece(Piece.createBlackKnight(), Color.BLACK, Type.KNIGHT.getRepresentation(Color.BLACK));

        verifyPiece(Piece.createWhiteRook(), Color.WHITE, Type.ROOK.getRepresentation(Color.WHITE));
        verifyPiece(Piece.createBlackRook(), Color.BLACK, Type.ROOK.getRepresentation(Color.BLACK));

        verifyPiece(Piece.createWhiteBishop(), Color.WHITE, Type.BISHOP.getRepresentation(Color.WHITE));
        verifyPiece(Piece.createBlackBishop(), Color.BLACK, Type.BISHOP.getRepresentation(Color.BLACK));

        verifyPiece(Piece.createWhiteQueen(), Color.WHITE, Type.QUEEN.getRepresentation(Color.WHITE));
        verifyPiece(Piece.createBlackQueen(), Color.BLACK, Type.QUEEN.getRepresentation(Color.BLACK));

        verifyPiece(Piece.createWhiteKing(), Color.WHITE, Type.KING.getRepresentation(Color.WHITE));
        verifyPiece(Piece.createBlackKing(), Color.BLACK, Type.KING.getRepresentation(Color.BLACK));

    }

    @Test
    @DisplayName("말이 검은색인지 흰색인지 확인한다.")
    void checkColor() {
        Piece whitePawn = Piece.createWhitePawn();
        Piece blackPawn = Piece.createBlackPawn();

        assertThat(whitePawn.isWhite()).isTrue();
        assertThat(whitePawn.isBlack()).isFalse();

        assertThat(blackPawn.isBlack()).isTrue();
        assertThat(blackPawn.isWhite()).isFalse();
    }

    void verifyPiece(final Piece piece, final Color color, final char representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getName().getRepresentation(color)).isEqualTo(representation);
    }
}
