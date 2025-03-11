package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.StringUtils.appendNewLine;

public class BoardViewTest {
    private Board board;
    private BoardView boardView;

    @BeforeEach
    public void setup() {
        board = new Board();
        boardView = new BoardView(board);
    }

    @Test
    @DisplayName("체스판이 정상적으로 출력되는지 확인")
    public void create() throws Exception {
        board.initialize();
        String blankRank = appendNewLine("........");
        assertThat(boardView.showBoard()).isEqualTo(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr")
        );
    }
}
