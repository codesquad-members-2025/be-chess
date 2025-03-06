package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pieces.Pawn;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    private Pawn[] pawns;
    private Board board;

    @BeforeEach
    void setUp() {
        String[] colors = {Pawn.WHITE_COLOR, Pawn.BLACK_COLOR};
        char[] representation = {Pawn.WHITE_REPRESENTATION, Pawn.BLACK_REPRESENTATION};
        pawns = new Pawn[colors.length];

        for (int i = 0; i < pawns.length; ++i) {
            pawns[i] = new Pawn(colors[i], representation[i]);
        }
    }

    @Test
    public void create() {
        board = new Board();
        for (int i = 0; i < pawns.length; ++i) {
            board.add(pawns[i]);
            verifyBoard(i);
        }
    }

    // Pawn이 Board에 정상적으로 추가되는지 확인한다.
    void verifyBoard(int i) {
        assertEquals(i + 1, board.size());
        assertEquals(pawns[i], board.findPawn(i));
    }
}
