package org.chess.domain.board;

import org.chess.domain.pieces.Piece;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName("Rank 내에 Pieces를 반환할 수 있어야 한다")
    void Rank_내에_Pieces_반환_테스트() {
        // given
        List<Piece> pieces = List.of(
                Piece.createWhite(Piece.Type.ROOK), Piece.createWhite(Piece.Type.KNIGHT), Piece.createWhite(Piece.Type.BISHOP),
                Piece.createWhite(Piece.Type.QUEEN), Piece.createWhite(Piece.Type.KING), Piece.createWhite(Piece.Type.BISHOP),
                Piece.createWhite(Piece.Type.KNIGHT), Piece.createWhite(Piece.Type.ROOK)
        );

        // when
        Rank rank = Rank.of(pieces);

        // then
        assertThat(pieces).isEqualTo(rank.getPieces());
    }

}
