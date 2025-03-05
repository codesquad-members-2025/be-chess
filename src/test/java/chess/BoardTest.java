package chess;

import chess.piece.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    private Board board;  // 공용으로 사용할 board 선언

    @BeforeEach  // 각 테스트 실행 전에 무조건 실행됨
    public void setUp() {
        board = new Board();  // 테스트마다 항상 새로운 Board 생성
    }

    @Test
    public void create() {
        Pawn white = new Pawn(Pawn.WHITE);
        testSinglePawnAdd(white);
    }
    @Test
    public void createAnother(){
        Pawn black = new Pawn(Pawn.BLACK);
        testSinglePawnAdd(black);
    }

    public void testSinglePawnAdd(Pawn pawn) {
        board.add(pawn);

        assertEquals(1, board.size());
        assertEquals(pawn, board.findPawn(0));
    }
}
