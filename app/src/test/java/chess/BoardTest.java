package chess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pieces.Pawn;

public class BoardTest {
    private Board board;
    private Pawn white;
    private Pawn black;

    @BeforeEach
    public void setUp(Board board) {
        board = new Board();
        white = new Pawn(Pawn.BLACK);
        black = new Pawn(Pawn.BLACK);
    }

    @Test
    public void create() {
        board.add(white);
        Assertions.assertEquals(1, board.size());
        Assertions.assertEquals(white, board.findPawn(0));


        board.add(black);
        Assertions.assertEquals(2, board.size());
        Assertions.assertEquals(black, board.findPawn(1));


    }
}
