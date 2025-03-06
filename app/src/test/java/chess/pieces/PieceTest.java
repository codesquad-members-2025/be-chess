package chess.pieces;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PieceTest {
    @Test
    public void create_기본생성자() throws Exception {
        Piece piece = new Piece();
        assertThat(piece.getColor()).isEqualTo(Piece.WHITE);
        assertThat(piece.getRepresentation()).isEqualTo(Piece.WHITE_REPRESENTATION);
    }

    @Test
    public void create() {
        verifyPawn(Piece.WHITE, Piece.WHITE_REPRESENTATION);
        verifyPawn(Piece.BLACK, Piece.BLACK_REPRESENTATION);
    }

    void verifyPawn(final String color, final char representation) {
        Piece piece = new Piece(color, representation);
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }
}

