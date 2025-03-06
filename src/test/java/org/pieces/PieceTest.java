package org.pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PieceTest {
    @Test
    @DisplayName("representation 확인")
    public void getRepresentationPerPiece() throws Exception {
        assertThat(Piece.Type.PAWN.getWhiteRepresentation()).isEqualTo('p');
        assertThat(Piece.Type.PAWN.getBlackRepresentation()).isEqualTo('P');
    }

    @Test
    @DisplayName("기물 색,타입 확인, blank 잘 생성하는지 확인")
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), Piece.Type.PAWN);
        verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), Piece.Type.KNIGHT);
        verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), Piece.Type.ROOK);
        verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), Piece.Type.BISHOP);
        verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), Piece.Type.QUEEN);
        verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), Piece.Type.KING);

        Piece blank = Piece.createBlank();
        assertThat(blank.isWhite()).isFalse();
        assertThat(blank.isBlack()).isFalse();
        assertThat(blank.getType()).isEqualTo(Piece.Type.NO_PIECE);
    }

    @Test
    @DisplayName("색상 테스트")
    public void check_color(){
        assertThat(Piece.createWhitePawn().isWhite()).isEqualTo(true);
        assertThat(Piece.createWhitePawn().isBlack()).isEqualTo(false);
        assertThat(Piece.createBlackPawn().isWhite()).isEqualTo(false);
        assertThat(Piece.createBlackPawn().isBlack()).isEqualTo(true);
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Piece.Type type) {
        assertThat(whitePiece.isWhite()).isTrue();
        assertThat(whitePiece.getType()).isEqualTo(type);

        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(blackPiece.getType()).isEqualTo(type);
    }
}

