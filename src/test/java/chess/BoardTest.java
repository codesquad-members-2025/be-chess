package chess;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoardTest {
    private Board board;
    private String[] colors;

    @BeforeEach
    public void init() {
        board = new Board();
        colors = new String[]{Pawn.WHITE_COLOR, Pawn.BLACK_COLOR};
    }
    @Test
    @DisplayName("폰이 추가될 Pawn의 수와 마지막에 추가된 폰이 맞는지 확인")
    public void create() throws Exception {
        for (int i = 0; i < colors.length; i++) {
            verifyBoard(i);
        }

//        board.add(new Integer(7));
    }

    private void verifyBoard(int i) {
        Pawn pawn = new Pawn(colors[i]);
        board.add(pawn);

        assertEquals(i +1, board.size());
        assertEquals(pawn, board.findPawn(i));
    }
}