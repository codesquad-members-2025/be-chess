package chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import static utils.StringUtils.appendNewLine;

public class ChessViewTest {
    private Board board;
    private ChessView chessView;

    @BeforeEach
    void setup(){
        board = new Board();
        chessView = new ChessView(board);
    }

    @Test
    @DisplayName("출력이 동일한지 확인해야한다.")
    void testShowBoard() {
        board.initialize();

        String expectBoard =
            appendNewLine("R N B Q K B N R    8") +
            appendNewLine("P P P P P P P P    7") +
            appendNewLine(". . . . . . . .    6") +
            appendNewLine(". . . . . . . .    5") +
            appendNewLine(". . . . . . . .    4") +
            appendNewLine(". . . . . . . .    3") +
            appendNewLine("p p p p p p p p    2") +
            appendNewLine("r n b q k b n r    1") +
            appendNewLine("") +
            "a b c d e f g h ";

        assertThat(chessView.showBoard()).isEqualTo(expectBoard);
    }
}
