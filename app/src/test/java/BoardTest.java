import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    public void create() {
        Board board = new Board();

        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        Pawn black = new Pawn(Pawn.BLACK_COLOR);

        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));

        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(1));
    }
}
