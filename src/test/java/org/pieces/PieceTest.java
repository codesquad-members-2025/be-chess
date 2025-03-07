package org.pieces;

import org.chess.Coordinate;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PieceTest {
    @Test
    @DisplayName("representation 확인")
    void getRepresentationPerPiece() throws Exception {
        assertThat(Piece.Type.PAWN.getWhiteRepresentation()).isEqualTo('p');
        assertThat(Piece.Type.PAWN.getBlackRepresentation()).isEqualTo('P');
    }

    @Test
    @DisplayName("기물 색,타입 확인, blank 잘 생성하는지 확인")
    void create_piece() {
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
    void check_color(){
        assertThat(Piece.createWhitePawn().isWhite()).isEqualTo(true);
        assertThat(Piece.createWhitePawn().isBlack()).isEqualTo(false);
        assertThat(Piece.createBlackPawn().isWhite()).isEqualTo(false);
        assertThat(Piece.createBlackPawn().isBlack()).isEqualTo(true);
    }

    @Test
    @DisplayName("King 움직이기 테스트")
    void move_king(){
        Piece king = Piece.createWhiteKing();
        Coordinate sourcePosition = new Coordinate(4,4);
        Coordinate position1 = new Coordinate(4,5);
        Coordinate position2 = new Coordinate(5,4);
        Coordinate position3 = new Coordinate(5,5);
        Coordinate position4 = new Coordinate(3,3);
        Coordinate position5 = new Coordinate(3,4);

        Coordinate position6 = new Coordinate(1,3);
        Coordinate position7 = new Coordinate(1,2);
        Coordinate position8 = new Coordinate(7,5);
        Coordinate position9 = new Coordinate(7,7);
        // 이동 가능
        assertThat(king.verifyMovePosition(sourcePosition,position1)).isEqualTo(true);
        assertThat(king.verifyMovePosition(sourcePosition,position2)).isEqualTo(true);
        assertThat(king.verifyMovePosition(sourcePosition,position3)).isEqualTo(true);
        assertThat(king.verifyMovePosition(sourcePosition,position4)).isEqualTo(true);
        assertThat(king.verifyMovePosition(sourcePosition,position5)).isEqualTo(true);
        //이동 불가
        assertThat(king.verifyMovePosition(sourcePosition,position6)).isEqualTo(false);
        assertThat(king.verifyMovePosition(sourcePosition,position7)).isEqualTo(false);
        assertThat(king.verifyMovePosition(sourcePosition,position8)).isEqualTo(false);
        assertThat(king.verifyMovePosition(sourcePosition,position9)).isEqualTo(false);

    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Piece.Type type) {
        assertThat(whitePiece.isWhite()).isTrue();
        assertThat(whitePiece.getType()).isEqualTo(type);

        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(blackPiece.getType()).isEqualTo(type);
    }
}

