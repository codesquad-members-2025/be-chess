package chess;

import static org.assertj.core.api.Assertions.assertThat;

import chess.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {
    private Board board;
    private String[] colors;

    @BeforeEach
    void init() {
        board = new Board();
        colors = new String[]{Piece.WHITE_COLOR, Piece.BLACK_COLOR};
    }
    @Test
    @DisplayName("폰이 추가될 Pawn의 수와 마지막에 추가된 폰이 맞는지 확인")
    void create() throws Exception {
        for (int i = 0; i < colors.length; i++) {
            verifyBoard(i);
        }

//        board.add(new Integer(7));
    }

    @Test
    @DisplayName("보드초기화시 같은 색의 폰들이 한줄에 있어야한다.")
    public void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
        assertThat(board.getPawnResult(Piece.WHITE_COLOR)).isEqualTo("pppppppp");
        assertThat(board.getPawnResult(Piece.BLACK_COLOR)).isEqualTo("PPPPPPPP");
    }

    private void verifyBoard(int i) {
        Piece piece = new Piece(colors[i]);
        board.add(piece);

        assertThat(board.size()).isEqualTo(i+1);
        assertThat(board.findPawn(i)).isEqualTo(piece);
    }
}