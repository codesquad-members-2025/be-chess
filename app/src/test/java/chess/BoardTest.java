package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.StringUtils.appendNewLine;

public class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    public void create() throws Exception{
        //Given
        board.initialize();

        //When
        int pieceCount = board.pieceCount();
        String actualBoard = board.showBoard();

        //Then
        String blankRank = appendNewLine("........");
        String expectedBoard = appendNewLine("♜♞♝♛♚♝♞♜") +
            appendNewLine("♟♟♟♟♟♟♟♟") +
            blankRank + blankRank + blankRank + blankRank +
            appendNewLine("♙♙♙♙♙♙♙♙") +
            appendNewLine("♖♘♗♕♔♗♘♖");

        assertThat(pieceCount).isEqualTo(32);
        assertThat(actualBoard).isEqualTo(expectedBoard);
    }
}
