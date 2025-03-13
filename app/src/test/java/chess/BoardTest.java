package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.StringUtils.appendNewLine;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void init(){
        board = new Board();
    }


    @Test
    @DisplayName("32개의 모든 기물의 위치가 초기화 되어야 한다.")
    public void create() throws Exception {
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(32);

        String blankRank = appendNewLine("........");
        assertThat(board.showBoard())
                .isEqualTo(appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"));
    }

    @Test
    @DisplayName("입력으로 들어온 색과 종류의 기물의 개수가 출력되어야 한다.")
    public void getPiecesCount() {
        board.initialize();

        assertThat(board.getPiecesCount(Piece.Color.BLACK, Piece.Type.PAWN)).isEqualTo(8);
        assertThat(board.getPiecesCount(Piece.Color.WHITE, Piece.Type.PAWN)).isEqualTo(8);
        assertThat(board.getPiecesCount(Piece.Color.NOCOLOR, Piece.Type.NO_PIECE)).isEqualTo(32);
    }

    @Test
    @DisplayName("해당 좌표의 기물이 반환되어야 합니다.")
    public void findPiece() throws Exception {
        board.initialize();

        assertThat(board.findPiece("a8")).isEqualTo(Piece.createBlackRook());
        assertThat(board.findPiece("h8")).isEqualTo(Piece.createBlackRook());
        assertThat(board.findPiece("a1")).isEqualTo(Piece.createWhiteRook());
        assertThat(board.findPiece("h1")).isEqualTo(Piece.createWhiteRook());
    }

    @Test
    @DisplayName("해당 좌표에 기물이 생성되어야 합니다.")
    public void move() throws Exception {
        board.initializeEmptyBoard();

        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.move(position, piece);

        assertThat(board.findPiece(position)).isEqualTo(piece);
        System.out.println(board.showBoard());
    }




}
