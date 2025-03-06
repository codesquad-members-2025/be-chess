package org.pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PieceTest {
    @Test
    public void getRepresentationPerPiece() throws Exception {
        assertThat(Piece.Type.PAWN.getWhiteRepresentation()).isEqualTo('p');
        assertThat(Piece.Type.PAWN.getBlackRepresentation()).isEqualTo('P');
    }


    @Test
    @DisplayName("모든 기물 생성 테스트")
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.Color.WHITE, Piece.Type.PAWN.getWhiteRepresentation());
        verifyPiece(Piece.createBlackPawn(), Piece.Color.BLACK, Piece.Type.PAWN.getBlackRepresentation());
        verifyPiece(Piece.createWhiteRook(), Piece.Color.WHITE, Piece.Type.ROOK.getWhiteRepresentation());
        verifyPiece(Piece.createBlackRook(), Piece.Color.BLACK, Piece.Type.ROOK.getBlackRepresentation());
        verifyPiece(Piece.createWhiteKnight(), Piece.Color.WHITE, Piece.Type.KNIGHT.getWhiteRepresentation());
        verifyPiece(Piece.createBlackKnight(), Piece.Color.BLACK, Piece.Type.KNIGHT.getBlackRepresentation());
        verifyPiece(Piece.createWhiteBishop(), Piece.Color.WHITE, Piece.Type.BISHOP.getWhiteRepresentation());
        verifyPiece(Piece.createBlackBishop(), Piece.Color.BLACK, Piece.Type.BISHOP.getBlackRepresentation());
        verifyPiece(Piece.createWhiteQueen(), Piece.Color.WHITE, Piece.Type.QUEEN.getWhiteRepresentation());
        verifyPiece(Piece.createBlackQueen(), Piece.Color.BLACK, Piece.Type.QUEEN.getBlackRepresentation());
        verifyPiece(Piece.createWhiteKing(), Piece.Color.WHITE, Piece.Type.KING.getWhiteRepresentation());
        verifyPiece(Piece.createBlackKing(), Piece.Color.BLACK, Piece.Type.KING.getBlackRepresentation());
    }

    @Test
    @DisplayName("색상 테스트")
    public void check_color(){
        assertThat(Piece.createWhitePawn().isWhite()).isEqualTo(true);
        assertThat(Piece.createWhitePawn().isBlack()).isEqualTo(false);
        assertThat(Piece.createBlackPawn().isWhite()).isEqualTo(false);
        assertThat(Piece.createBlackPawn().isBlack()).isEqualTo(true);
    }

    private void verifyPiece(final Piece piece, final Piece.Color color, final char representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }
}

