package chess;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static utils.StringUtils.appendNewLine;
import pieces.Piece;

public class BoardTest {
    private Board board;

    @BeforeEach
    void setup(){
        board = new Board();
    }

    @Test
    public void create() throws Exception {
        board.initialize();
//        assertEquals(32, board.pieceCount());
//        String blankRank = appendNewLine("........");
//        assertEquals(
//            appendNewLine("RNBQKBNR") +
//            appendNewLine("PPPPPPPP") +
//            blankRank + blankRank + blankRank + blankRank +
//            appendNewLine("pppppppp") +
//            appendNewLine("rnbqkbnr"),
//            board.showBoard());
    }
}