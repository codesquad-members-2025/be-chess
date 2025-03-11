package pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chess.Board;
import chess.Color;
import chess.Piece;
import chess.Type;
import org.junit.Before;
import org.junit.Test;
import static utils.StringUtils.appendNewLine;

import static org.junit.Assert.*;

public class BoardTest {
    private Board board;

    @Before
    public void setup() {
        board = new Board();
    }

    @Test
    public void create() throws Exception {
        board.initializePawns();
        board.initializeBoard();
        assertEquals(32, board.pieceCount());
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                board.showBoard());
    }
}
