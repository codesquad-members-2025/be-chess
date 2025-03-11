package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.StringUtils.appendNewLine;

public class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    public void create() throws Exception {
        //Given & When
        String blankRank = appendNewLine("........");
        String expectedBoard = appendNewLine("RNBQKBNR") +
            appendNewLine("PPPPPPPP") +
            blankRank + blankRank + blankRank + blankRank +
            appendNewLine("pppppppp") +
            appendNewLine("rnbqkbnr");
        board.initialize();
        int pieceCount = board.pieceCount();
        String actualBoard = board.showBoard();


        //Then
        assertThat(pieceCount).isEqualTo(32);
        assertThat(actualBoard).isEqualTo(expectedBoard);
    }

    @Test
    @DisplayName("체스 보드 초기화 시 검은색 폰 8개가 존재해야 한다")
    void countPiece() {
        //Given
        board.initialize();
        Piece.Color color = Piece.Color.BLACK;
        Piece.Type type = Piece.Type.PAWN;
        int expectedCount = 8;

        //When
        int actualCount = board.countPiece(color, type);

        //Then
        assertThat(actualCount).isEqualTo(expectedCount);
    }
}
