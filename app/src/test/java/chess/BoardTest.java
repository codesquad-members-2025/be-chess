package chess;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import pieces.Piece;
import pieces.Piece.Type;
import pieces.Piece.Color;


import static org.assertj.core.api.Assertions.assertThat;
import static utils.StringUtils.appendNewLine;

public class BoardTest {
    private Board board;
    private BoardView boardView;

    @BeforeEach
    public void setup() {
        board = new Board();
        boardView = new BoardView(board);
    }

    @Test
    @DisplayName("기물이 현재 위치에서 다른 위치로 잘 이동하는지 확인")
    public void move() throws Exception {
        board.initialize();

        String sourcePosition = "b2";
        String targetPosition = "b3";
        board.move(sourcePosition, targetPosition);
        assertThat(board.findPiece(sourcePosition)).isEqualTo(Piece.createBlank());
        assertThat(board.findPiece(targetPosition)).isEqualTo(Piece.createWhite(Type.PAWN));
    }

    @Test
    @DisplayName("주어진 위치의 기물이 잘 조회되는지 확인")
    //Unit의 assertThat(A).isEqualTo(B)는 내부적으로 equals()를 자동 호출
    //equals()는 Piece.java에서 구현
    public void findPiece() throws Exception {
        board.initialize();
        assertThat(board.findPiece("a8")).isEqualTo(Piece.createBlack(Type.ROOK));
        assertThat(board.findPiece("h8")).isEqualTo(Piece.createBlack(Type.ROOK));
        assertThat(board.findPiece("a1")).isEqualTo(Piece.createWhite(Type.ROOK));
        assertThat(board.findPiece("h1")).isEqualTo(Piece.createWhite(Type.ROOK));

    }

    @Test
    @DisplayName("초기화된 체스판의 기물 개수 확인")
    public void create() throws Exception {
        board.initialize();
        assertThat(board.totalPieceCount()).isEqualTo(32);
    }

    @Test
    @DisplayName("특정 기물 개수 확인")
    public void testPieceCount() {
        board.initialize();
        assertThat(board.pieceCount(Color.BLACK, Type.PAWN)).isEqualTo(8);
        assertThat(board.pieceCount(Color.WHITE, Type.PAWN)).isEqualTo(8);

        assertThat(board.pieceCount(Color.BLACK, Type.ROOK)).isEqualTo(2);
        assertThat(board.pieceCount(Color.WHITE, Type.ROOK)).isEqualTo(2);
    }


}

