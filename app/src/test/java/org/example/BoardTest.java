package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BoardTest {
    @Test
    @DisplayName("체스판에 폰이 잘 들어가는지 테스트")
    public void create() throws Exception {
        Board board = new Board();

        Pawn white = new Pawn(Pawn.WHITE);
        board.add(white);
        assertThat(board.size()).isEqualTo(1);
        assertThat(white).isEqualTo(board.findPawn(0));

        Pawn black = new Pawn(Pawn.BLACK);
        board.add(black);
        assertThat(board.size()).isEqualTo(2);
        assertThat(black).isEqualTo(board.findPawn(1));
    }
}
