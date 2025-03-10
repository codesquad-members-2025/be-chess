package chess;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import pieces.Piece;


import static org.assertj.core.api.Assertions.assertThat;
import static utils.StringUtils.appendNewLine;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("기물이 체스판에 올바르게 배치되었는지 확인")
    public void create() throws Exception {
        board.initialize();
        assertThat(board.totalPieceCount()).isEqualTo(32);
        String blankRank = appendNewLine("........");
        assertThat(board.showBoard()).isEqualTo(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr")
                );
    }

    @Test
    @DisplayName("특정 기물 개수 확인")
    public void testPieceCount() {
        board.initialize();
        assertThat(board.pieceCount(Piece.Color.BLACK, Piece.Type.PAWN)).isEqualTo(8);
        assertThat(board.pieceCount(Piece.Color.WHITE, Piece.Type.PAWN)).isEqualTo(8);

        assertThat(board.pieceCount(Piece.Color.BLACK, Piece.Type.ROOK)).isEqualTo(2);
        assertThat(board.pieceCount(Piece.Color.WHITE, Piece.Type.ROOK)).isEqualTo(2);
    }


}

