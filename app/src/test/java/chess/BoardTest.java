package chess;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pieces.Pawn;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    private Board board;
    private Pawn white;
    private Pawn black;

    @BeforeEach
    public void setUp() {
        board = new Board();
        white = new Pawn(Pawn.WHITE);
        black = new Pawn(Pawn.BLACK);
    }

    @Test
    public void create() {
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));


        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(1));


    }
}
