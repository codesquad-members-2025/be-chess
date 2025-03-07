package chess.pieces;
import org.junit.jupiter.api.*;

import static chess.pieces.Piece.*;
import static chess.pieces.Piece.Color.*;
import static chess.pieces.Piece.Type.*;
import static org.assertj.core.api.Assertions.*;

public class PieceTest {
    @Test
    @DisplayName("각 기물의 생성 테스트")
    public void create_piece() {
        verifyPiece(createWhitePawn(), WHITE, PAWN.getWhiteRepresentation());
        verifyPiece(createBlackPawn(), BLACK, PAWN.getBlackRepresentation());

        verifyPiece(createWhiteKing(), WHITE, KING.getWhiteRepresentation());
        verifyPiece(createBlackKing(), BLACK, KING.getBlackRepresentation());

        verifyPiece(createWhiteQueen(), WHITE, QUEEN.getWhiteRepresentation());
        verifyPiece(createBlackQueen(), BLACK, QUEEN.getBlackRepresentation());

        verifyPiece(createWhiteRook(), WHITE, ROOK.getWhiteRepresentation());
        verifyPiece(createBlackRook(), BLACK, ROOK.getBlackRepresentation());

        verifyPiece(createWhiteBishop(), WHITE, BISHOP.getWhiteRepresentation());
        verifyPiece(createBlackBishop(), BLACK, BISHOP.getBlackRepresentation());

        verifyPiece(createWhiteKnight(), WHITE, KNIGHT.getWhiteRepresentation());
        verifyPiece(createBlackKnight(), BLACK, KNIGHT.getBlackRepresentation());
    }

    @Test
    @DisplayName("흰색 말 테스트")
    public void whiteColor() throws Exception{
        Piece whiteBishop = createWhiteBishop();
        Piece whitePawn = createWhitePawn();

        assertThat(whiteBishop.isWhite()).isTrue();
        assertThat(whitePawn.isWhite()).isTrue();
        assertThat(whiteBishop.isBlack()).isFalse();
        assertThat(whitePawn.isBlack()).isFalse();
    }

    @Test
    @DisplayName("검은 말 테스트")
    public void blackColor() throws Exception{
        Piece blackBishop = createBlackBishop();
        Piece blackPawn = createBlackPawn();

        assertThat(blackBishop.isBlack()).isTrue();
        assertThat(blackPawn.isBlack()).isTrue();
        assertThat(blackBishop.isWhite()).isFalse();
        assertThat(blackPawn.isWhite()).isFalse();
    }

    @Test
    @DisplayName("기물의 representation이 잘 할당 되었는지 테스트")
    public void getRepresentationPerPiece() throws Exception {
        assertThat(PAWN.getWhiteRepresentation()).isEqualTo('p');
        assertThat(PAWN.getBlackRepresentation()).isEqualTo('P');
    }

    private void verifyPiece(final Piece piece, final Color color, final char representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }
}

