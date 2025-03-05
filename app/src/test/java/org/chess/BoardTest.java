package org.chess;

import org.chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.chess.pieces.Pawn.*;

public class BoardTest {

    private Board board;
    @BeforeEach
    public void setUp() {
        board = new Board();
    }
    @Test
    @DisplayName("체스판에 폰이 잘 들어가는지 테스트")
    public void create() throws Exception {

        verifyBoard(WHITE, 1, 0);
        verifyBoard(BLACK, 2, 1);
    }

    private void verifyBoard(String color, int size, int index) {
        Pawn pawn = new Pawn(color);
        board.add(pawn);
        assertThat(board.size()).isEqualTo(size);
        assertThat(pawn).isEqualTo(board.findPawn(index));
    }
}
