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
    @DisplayName("주어진 위치의 기물이 잘 조회되는지 확인")
    //Unit의 assertThat(A).isEqualTo(B)는 내부적으로 equals()를 자동 호출
    //equals()는 Piece.java에서 구현
    public void findPiece() throws Exception {
        board.initialize();
        assertThat(board.findPiece("a8")).isEqualTo(Piece.createBlack(Piece.Type.ROOK));
        assertThat(board.findPiece("h8")).isEqualTo(Piece.createBlack(Piece.Type.ROOK));
        assertThat(board.findPiece("a1")).isEqualTo(Piece.createWhite(Piece.Type.ROOK));
        assertThat(board.findPiece("h1")).isEqualTo(Piece.createWhite(Piece.Type.ROOK));

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

