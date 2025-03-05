package chess.pieces;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class PieceTest {
    @Test
    @DisplayName("흰색, 검은색 폰이 생성되어야 한다")
    void create() {
        String[] colors = new String[]{Piece.WHITE_COLOR, Piece.BLACK_COLOR};
        char[] representations = new char[]{Piece.WHITE_REPRESENTATION, Piece.BLACK_REPRESENTATION};
        for (int i = 0; i < colors.length; i++) {
            verifyPawn(colors[i], representations[i]);
        }

    }
    @Test
    @DisplayName("기본생성자로 생성시 흰색 폰이 생성되어야 한다.")
    void create_기본생성자() throws Exception {
        Piece piece = new Piece();
        assertThat(piece.getColor()).isEqualTo(Piece.WHITE_COLOR);
        assertThat(piece.getRepresentation()).isEqualTo(Piece.WHITE_REPRESENTATION);
    }
    void verifyPawn(final String color, final char representation) {
        Piece piece = new Piece(color, representation);
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }
}
