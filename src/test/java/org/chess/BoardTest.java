package org.chess;

import org.chess.pieces.Pawn;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class BoardTest {
    @Test
    public void create() throws Exception {
        Board board = new Board();

        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        board.add(white);
        assertThat(1).isEqualTo(board.size());
        assertThat(white).isEqualTo(board.findPawn(0));

        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        board.add(black);
        assertThat(2).isEqualTo(board.size());
        assertThat(black).isEqualTo(board.findPawn(1));
    }
}