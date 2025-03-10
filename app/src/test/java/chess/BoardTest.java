package chess;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import pieces.Piece;


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
    @DisplayName("임의의 위치에 기물이 잘 추가되는지 확인")
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlack(Piece.Type.ROOK);
        board.move(position, piece);

        assertThat(board.findPiece(position)).isEqualTo(piece);
        System.out.println(boardView.showBoard());
    }

    @Test
    @DisplayName("주어진 위치의 기물이 잘 조회되는지 확인")
    //Unit의 assertThat(A).isEqualTo(B)는 내부적으로 equals()를 자동 호출
    //equals()는 Piece.java에서 구현
    public void findPiece() throws Exception {
        board.initialize();
        assertThat(board.findPiece("a8")).isEqualTo(Piece.createBlack(Piece.Type.ROOK));
        assertThat(board.findPiece("h8")).isEqualTo(Piece.createBlack(Piece.Type.ROOK));
        assertThat(board.findPiece("a1")).isEqualTo(Piece.createWhite(Piece.Type.ROOK));
        assertThat(board.findPiece("h1")).isEqualTo(Piece.createWhite(Piece.Type.ROOK));

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
        assertThat(board.pieceCount(Piece.Color.BLACK, Piece.Type.PAWN)).isEqualTo(8);
        assertThat(board.pieceCount(Piece.Color.WHITE, Piece.Type.PAWN)).isEqualTo(8);

        assertThat(board.pieceCount(Piece.Color.BLACK, Piece.Type.ROOK)).isEqualTo(2);
        assertThat(board.pieceCount(Piece.Color.WHITE, Piece.Type.ROOK)).isEqualTo(2);
    }


}

