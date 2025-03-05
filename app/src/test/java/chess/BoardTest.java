package chess;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import pieces.Pawn;

public class BoardTest {
    private Board board;

    @BeforeEach
    void init(){
        board = new Board();
    }

    @Test
    public void create() throws Exception {
        addAndVerifyPawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION, 0);
        addAndVerifyPawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION, 1);
    }

    @Test
    public void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
    }

    private void addAndVerifyPawn(final String color, final char representation, int expectedNum){
        Pawn pawn = new Pawn(color, representation);
        board.add(pawn);
        assertEquals(expectedNum+1, board.size());
        assertEquals(pawn, board.findPawn(expectedNum));
    }
}