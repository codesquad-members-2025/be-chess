package chess.view;

import chess.board.Board;
import chess.enums.Color;
import chess.piece.Pawn;
import chess.piece.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.assertj.core.api.Assertions.*;

class ViewTest {
    private Piece[][] board;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    @DisplayName("체스 보드 초기화")
    void setUp() {
        Board board = new Board();
        board.initializeEmpty();
        this.board = board.getBoard();

        // System.out 출력을 가로채어 테스트 가능하게 만듦
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("체스판이 올바르게 출력되는지 확인")
    void testPrintBoard() {
        board[6][4] = new Pawn(Color.WHITE); // e2에 폰 배치
        board[1][4] = new Pawn(Color.BLACK); // e7에 폰 배치

        ChessView.printBoard(board);
        String expectedBoard =
                "........\n" +
                        "....p...\n" +
                        "........\n" +
                        "........\n" +
                        "........\n" +
                        "........\n" +
                        "....P...\n" +
                        "........";

        // 출력값을 trim() 하여 불필요한 개행 비교 문제 해결
        assertThat(outputStream.toString().trim()).isEqualTo(expectedBoard);
    }

    @Test
    @DisplayName("빈 체스판이 올바르게 출력되는지 확인")
    void testPrintEmptyBoard() {
        ChessView.printBoard(board);
        String expectedEmptyBoard =
                "........\n" +
                        "........\n" +
                        "........\n" +
                        "........\n" +
                        "........\n" +
                        "........\n" +
                        "........\n" +
                        "........";

        // trim()으로 개행 문제 해결
        assertThat(outputStream.toString().trim()).isEqualTo(expectedEmptyBoard);
    }
}
