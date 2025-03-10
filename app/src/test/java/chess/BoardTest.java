package chess;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    private Board board;
    private Piece white;
    private Piece black;

    @BeforeEach
    public void init(){
        board = new Board();
        white = Piece.of(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION);
        black = Piece.of(Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION);
    }


    @Test
    public void create() throws Exception {
        board.add(white);
        assertThat(board.size()).isEqualTo(1);
        assertThat(board.findPawn(0)).isEqualTo(white);

        board.add(black);
        assertThat(board.size()).isEqualTo(2);
        assertThat(board.findPawn(1)).isEqualTo(black);
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
