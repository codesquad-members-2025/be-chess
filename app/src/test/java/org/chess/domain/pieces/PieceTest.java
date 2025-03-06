package org.chess.domain.pieces;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class PieceTest {

    @Test
    @DisplayName("팩토리 메소드에 의해 맞는 색상과 표현을 가진 Piece를 생성할 수 있어야 한다")
    void Piece_생성_테스트() {
        verifyPiece(Piece.createWhitePawn(), Piece.Color.WHITE, Piece.Type.PAWN);
        verifyPiece(Piece.createBlackPawn(), Piece.Color.BLACK, Piece.Type.PAWN);
        verifyPiece(Piece.createWhiteQueen(), Piece.Color.WHITE, Piece.Type.QUEEN);
        verifyPiece(Piece.createBlackQueen(), Piece.Color.BLACK, Piece.Type.QUEEN);
        verifyPiece(Piece.createWhiteKing(), Piece.Color.WHITE, Piece.Type.KING);
        verifyPiece(Piece.createBlackKing(), Piece.Color.BLACK, Piece.Type.KING);
        verifyPiece(Piece.createWhiteRook(), Piece.Color.WHITE, Piece.Type.ROOK);
        verifyPiece(Piece.createBlackRook(), Piece.Color.BLACK, Piece.Type.ROOK);
        verifyPiece(Piece.createWhiteBishop(), Piece.Color.WHITE, Piece.Type.BISHOP);
        verifyPiece(Piece.createBlackBishop(), Piece.Color.BLACK, Piece.Type.BISHOP);
        verifyPiece(Piece.createWhiteKnight(), Piece.Color.WHITE, Piece.Type.KNIGHT);
        verifyPiece(Piece.createBlackKnight(), Piece.Color.BLACK, Piece.Type.KNIGHT);
    }

    private void verifyPiece(final Piece piece, final Piece.Color color, final Piece.Type type) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getType()).isEqualTo(type);
    }

    @Test
    @DisplayName("Piece의 표현을 검은 색과 흰 색에 따라 반환해야 한다")
    void enum_Type_표현_반환_테스트() {
        assertThat('p').isEqualTo(Piece.Type.PAWN.getWhiteType());
        assertThat('P').isEqualTo(Piece.Type.PAWN.getBlackType());
    }

    @ParameterizedTest
    @MethodSource("whitePiecesProvider")
    @DisplayName("White 로 생성한 Piece의 색상은 White이어야 한다")
    void 흰색_기물_생성시_색상_검증_테스트(Piece piece) {
        assertThat(piece.isWhite()).isTrue();
    }

    @ParameterizedTest
    @MethodSource("blackPiecesProvider")
    @DisplayName("Black으로 생성한 Piece의 색상은 Black이어야 한다")
    void 검은색_기물_생성시_색상_검증_테스트(Piece piece) {
        assertThat(piece.isBlack()).isTrue();
    }

    static Stream<Piece> whitePiecesProvider() {
        return Stream.of(
                Piece.createWhitePawn(),
                Piece.createWhiteQueen(),
                Piece.createWhiteKing(),
                Piece.createWhiteRook(),
                Piece.createWhiteBishop(),
                Piece.createWhiteKnight()
        );
    }

    static Stream<Piece> blackPiecesProvider() {
        return Stream.of(
                Piece.createBlackPawn(),
                Piece.createBlackQueen(),
                Piece.createBlackKing(),
                Piece.createBlackRook(),
                Piece.createBlackBishop(),
                Piece.createBlackKnight()
        );
    }

}
