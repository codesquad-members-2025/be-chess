package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PieceTest {

    @Test
    @DisplayName("흰색, 검은색 기물이 생성되어야 한다.")
    void create_piece() {
        //Given
        List<Piece> whitePieces = Piece.createWhite();
        List<Piece> blackPieces = Piece.createBlack();
        int piecesIndex = 0;

        //When & Than
        for (Piece.Type type : Piece.Type.values()) {
            if (Piece.Type.NO_PIECE == type) continue;
            verifyPiece(whitePieces.get(piecesIndex), blackPieces.get(piecesIndex), type);
            ++piecesIndex;
        }
    }

    @Test
    @DisplayName("빈칸이 생성되어야 한다.")
    void create_blank() {
        Piece blank = Piece.createBlank();
        assertFalse(blank.isWhite());
        assertFalse(blank.isBlack());
        assertThat(blank.getType()).isEqualTo(Piece.Type.NO_PIECE.getRepresentation());
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Piece.Type type) {
        assertTrue(whitePiece.isWhite());
        assertThat(whitePiece.getType()).isEqualTo(type.getRepresentation());

        assertTrue(blackPiece.isBlack());
        assertThat(blackPiece.getType()).isEqualTo(type.getRepresentation());
    }

    @Test
    @DisplayName("기물의 색상이 흰색이거나 검은색이어야한다.")
    void isWhiteAndBlack() {
        assertThat(Piece.createWhitePawn().isWhite()).isTrue();
        assertThat(Piece.createBlackPawn().isBlack()).isTrue();
    }
}
