package org.chess;

import org.chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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

//        Pawn white = new Pawn(WHITE);
//        board.add(white);
//        assertThat(board.size()).isEqualTo(1);
//        assertThat(white).isEqualTo(board.findPawn(0));
//
//        Pawn black = new Pawn(BLACK);
//        board.add(black);
//        assertThat(board.size()).isEqualTo(2);
//        assertThat(black).isEqualTo(board.findPawn(1));
    }

    /*@Test
    @DisplayName("체스판에 Pawn 이외의 객체가 추가되지 않는지 테스트")
    public void 체스판엔_Pawn만() {
        Board board = new Board();

        board.add(new Integer(7));
        board.add(new ArrayList<>());
        board.add(new int[]{1,2,3});
    }*/

    private void verifyBoard(String color, int size, int index) {
        Pawn pawn = new Pawn(color);
        board.add(pawn);
        assertThat(board.size()).isEqualTo(size);
        assertThat(pawn).isEqualTo(board.findPawn(index));
    }
}
