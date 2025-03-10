package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void init(){
        board = new Board();
    }


    @Test
    public void create() throws Exception {
//        board.initialize();
//        assertEquals(32, board.pieceCount());
//        String blankRank = appendNewLine("........");

    }

    @Test
    @DisplayName("Pawn 객체만 추가되어야 한다.")
    public void add(){
        Board board = new Board();

//        board.add(new Integer("7"));
    }

    @Test
    public void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
    }

    @Test
    public void print(){
        Board board = new Board();
        board.initialize();
        System.out.println(board.print());
    }


}
