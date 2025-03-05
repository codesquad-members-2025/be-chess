package org.chess;

import org.chess.pieces.Pawn;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class BoardTest {
    Board board;
    Pawn white;
    Pawn black;

    @BeforeEach
    public void setUp(){
        Board board = new Board();
        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        Pawn black = new Pawn(Pawn.BLACK_COLOR);
    }

    @Test
    public void create() throws Exception {
        board.add(white);
        assertThat(1).isEqualTo(board.size());
        assertThat(white).isEqualTo(board.findPawn(0));

        board.add(black);
        assertThat(2).isEqualTo(board.size());
        assertThat(black).isEqualTo(board.findPawn(1));
    }
//    @Test
//    public void 추가테스트(){
//        Board board = new Board();
//        board.add(new Integer(7));
//    }
//    에러 발생
}