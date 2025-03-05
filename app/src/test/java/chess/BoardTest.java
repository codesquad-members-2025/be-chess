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
        addAndVerifyPawn(Pawn.WHITE_COLOR, 0);
        addAndVerifyPawn(Pawn.BLACK_COLOR, 1);
    }

    private void addAndVerifyPawn(String color, int expectedNum){
        Pawn pawn = new Pawn(color);
        board.add(pawn);
        assertEquals(expectedNum+1, board.size());
        assertEquals(pawn, board.findPawn(expectedNum));
    }
}