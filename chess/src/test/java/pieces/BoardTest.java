package pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chess.Board;
import chess.Main;
import chess.Pawn;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    private Board board;
    private Pawn white;
    private Pawn black;

    @Before
    public void setUp(){
        board = new Board();
        white = new Pawn(Pawn.WHITE_COLOR);
        black = new Pawn(Pawn.BLACK_COLOR);
    }

    @Test
    public void create() throws Exception {
       // Board board = new Board();

        //Pawn white = new Pawn(Pawn.WHITE_COLOR);
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));

       // Pawn black = new Pawn(Pawn.BLACK_COLOR);
        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(1));
    }

    //추가 테스트 구현
    @Test
    public void add_another(){
        //Board board = new Board();
       // board.add(new Integer("7")); -> compile 에러 발생
    }

    @Test
    public void initialize() throws Exception {
        Board board = new Board();
        board.initializePawns();
        board.initializeBoard();
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());

        System.out.println(board.print());
    }

}
