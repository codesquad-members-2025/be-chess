package chess;

import chess.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.pieces.Piece.Color.*;
import static chess.pieces.Piece.Type.*;
import static chess.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.Assertions.*;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("체스판 세팅 테스트")
    public void create() throws Exception {
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(32);
        String blankRank = appendNewLine("........");
        assertThat(board.showBoard()).isEqualTo(
                appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr"));
    }

    @Test
    @DisplayName("현재 보드에서 특정 타입과 색에 해당하는 기물의 수")
    public void getSpecificPieceCount() {
        board.initialize();
        assertThat(board.getSpecificPieceCount(PAWN, BLACK)).isEqualTo(8);
        assertThat(board.getSpecificPieceCount(PAWN, WHITE)).isEqualTo(8);

        assertThat(board.getSpecificPieceCount(ROOK, BLACK)).isEqualTo(2);
        assertThat(board.getSpecificPieceCount(ROOK, WHITE)).isEqualTo(2);

        assertThat(board.getSpecificPieceCount(BISHOP, BLACK)).isEqualTo(2);
        assertThat(board.getSpecificPieceCount(BISHOP, WHITE)).isEqualTo(2);

        assertThat(board.getSpecificPieceCount(KNIGHT, BLACK)).isEqualTo(2);
        assertThat(board.getSpecificPieceCount(KNIGHT, WHITE)).isEqualTo(2);

        assertThat(board.getSpecificPieceCount(QUEEN, BLACK)).isEqualTo(1);
        assertThat(board.getSpecificPieceCount(QUEEN, WHITE)).isEqualTo(1);

        assertThat(board.getSpecificPieceCount(KING, BLACK)).isEqualTo(1);
        assertThat(board.getSpecificPieceCount(KING, WHITE)).isEqualTo(1);
    }

    @Test
    @DisplayName("주어진 좌표의 기물을 조회하는 테스트")
    public void findPiece() throws Exception {
        board.initialize();

        assertThat(board.findPiece("a8")).isEqualTo(Piece.createBlackRook());
        assertThat(board.findPiece("h8")).isEqualTo(Piece.createBlackRook());
        assertThat(board.findPiece("a1")).isEqualTo(Piece.createWhiteRook());
        assertThat(board.findPiece("h1")).isEqualTo(Piece.createWhiteRook());
    }
}
