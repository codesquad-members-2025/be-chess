package pieces;

import chess.Board;
import chess.ChessView;
import chess.Game;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PieceTest {
    @Test
    @DisplayName("각 Refresentation당 모양이 일치해야한다.")
    public void getRepresentationPerPiece() throws Exception {
        assertThat(Type.PAWN.getWhiteRepresentation()).isEqualTo('p');
        assertThat(Type.PAWN.getBlackRepresentation()).isEqualTo('P');
    }

    @Test
    @DisplayName("기물의 색이 달라도 타입은 일치해야한다.")
    public void create_piece() {
        verifyPiece(Piece.create(Type.PAWN, Piece.Color.WHITE, new Position("a7")), Piece.create(Type.PAWN, Piece.Color.BLACK, new Position("d2")), Type.PAWN);
        verifyPiece(Piece.create(Type.QUEEN, Piece.Color.WHITE, new Position("d1")), Piece.create(Type.QUEEN, Piece.Color.BLACK, new Position("d8")), Type.QUEEN);
        verifyPiece(Piece.create(Type.KING, Piece.Color.WHITE, new Position("e1")), Piece.create(Type.KING, Piece.Color.BLACK, new Position("e8")), Type.KING);

        Piece blank = Piece.create(Type.NO_PIECE, Piece.Color.NOCOLOR, new Position("a5"));
        assertThat(blank.isBlack()).isFalse();
        assertThat(blank.isWhite()).isFalse();
        assertThat(blank.getType()).isEqualTo(Type.NO_PIECE);
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertThat(whitePiece.isWhite()).isTrue();
        assertThat(type).isEqualTo(whitePiece.getType());

        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(type).isEqualTo(blackPiece.getType());
    }
}
