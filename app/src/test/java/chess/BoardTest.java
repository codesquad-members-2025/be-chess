package chess;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import pieces.Piece;
import pieces.Piece.Type;
import pieces.Piece.Color;


import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }


    @Test
    @DisplayName("초기화된 체스판의 기물 개수 확인")
    public void create() throws Exception {
        board.initialize();
        assertThat(board.totalPieceCount()).isEqualTo(32);
    }

    @Test
    @DisplayName("특정 기물 개수 확인")
    public void testPieceCount() {
        board.initialize();
        assertThat(board.pieceCount(Color.BLACK, Type.PAWN)).isEqualTo(8);
        assertThat(board.pieceCount(Color.WHITE, Type.PAWN)).isEqualTo(8);

        assertThat(board.pieceCount(Color.BLACK, Type.ROOK)).isEqualTo(2);
        assertThat(board.pieceCount(Color.WHITE, Type.ROOK)).isEqualTo(2);
    }


}

