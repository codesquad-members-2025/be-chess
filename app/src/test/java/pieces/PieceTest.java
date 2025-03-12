package pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PieceTest {

    @Test
    @DisplayName("지정된 색과 타입의 기물이 생성되어야 한다.")
    public void create() {
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

    void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Piece.Type type){
        assertThat(whitePiece.isWhite()).isEqualTo(true);
        assertThat(whitePiece.getType()).isEqualTo(type);

        assertThat(blackPiece.isBlack()).isEqualTo(true);
        assertThat(blackPiece.getType()).isEqualTo(type);
    }

    @Test
    @DisplayName("흰색 기물이 생성되어야 한다.")
    public void isWhite(){
        assertThat(Piece.createWhitePawn().isWhite()).isTrue();
    }

    @Test
    @DisplayName("검은색 기물이 생성되어야 한다.")
    public void isBlack(){
        assertThat(Piece.createBlackPawn().isBlack()).isTrue();
    }


    @Test
    public void getRepresentationPerPiece(){
        assertThat(Piece.Type.PAWN.getWhiteRepresentation()).isEqualTo('p');
        assertThat(Piece.Type.PAWN.getBlackRepresentation()).isEqualTo('P');
    }




}
