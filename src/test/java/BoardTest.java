import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pieces.Pawn;

public class BoardTest {
    private Board board;

    // 각 테스트 전에 실행
    @BeforeEach
    void setUp() {
        board = new Board();
    }
    @Test
    public void create() throws Exception {
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
