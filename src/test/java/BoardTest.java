import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import pieces.Pawn;

public class BoardTest {
    @Test
    public void create() throws Exception {
        Board board = new Board();

        Pawn white = new Pawn(Pawn.COLOR_W);
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(Pawn.COLOR_W, board.findPawn(0));

        Pawn black = new Pawn(Pawn.COLOR_B);
        board.add(black);
        assertEquals(2, board.size());
        assertEquals(Pawn.COLOR_B, board.findPawn(1));
    }
}
