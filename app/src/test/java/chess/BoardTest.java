package chess;

import chess.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.pieces.Piece.Color.*;
import static chess.pieces.Piece.Type.*;
import static chess.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.Assertions.*;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("체스판 세팅 테스트")
    public void create() throws Exception {
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(32);
        String blankRank = appendNewLine("........");
        assertThat(board.showBoard()).isEqualTo(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"));
    }

    @Test
    @DisplayName("현재 보드에서 특정 타입과 색에 해당하는 기물의 수")
    public void getSpecificPieceCount() {
        board.initialize();
        assertThat(board.getSpecificPieceCount(PAWN, BLACK)).isEqualTo(8);
        assertThat(board.getSpecificPieceCount(PAWN, WHITE)).isEqualTo(8);

        assertThat(board.getSpecificPieceCount(ROOK, BLACK)).isEqualTo(2);
        assertThat(board.getSpecificPieceCount(ROOK, WHITE)).isEqualTo(2);

        assertThat(board.getSpecificPieceCount(BISHOP, BLACK)).isEqualTo(2);
        assertThat(board.getSpecificPieceCount(BISHOP, WHITE)).isEqualTo(2);

        assertThat(board.getSpecificPieceCount(KNIGHT, BLACK)).isEqualTo(2);
        assertThat(board.getSpecificPieceCount(KNIGHT, WHITE)).isEqualTo(2);

        assertThat(board.getSpecificPieceCount(QUEEN, BLACK)).isEqualTo(1);
        assertThat(board.getSpecificPieceCount(QUEEN, WHITE)).isEqualTo(1);

        assertThat(board.getSpecificPieceCount(KING, BLACK)).isEqualTo(1);
        assertThat(board.getSpecificPieceCount(KING, WHITE)).isEqualTo(1);
    }

    @Test
    @DisplayName("주어진 좌표의 기물을 조회하는 테스트")
    public void findPiece() throws Exception {
        board.initialize();

        assertThat(board.findPiece("a8")).isEqualTo(Piece.createBlackRook());
        assertThat(board.findPiece("h8")).isEqualTo(Piece.createBlackRook());
        assertThat(board.findPiece("a1")).isEqualTo(Piece.createWhiteRook());
        assertThat(board.findPiece("h1")).isEqualTo(Piece.createWhiteRook());
    }

    @Test
    @DisplayName("기물 이동 테스트")
    public void move() throws Exception {
        board.initializeEmpty();
        System.out.println(board.showBoard());

        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.move(position, piece);

        Piece blank = Piece.createBlank();

        assertThat(piece).isEqualTo(board.findPiece(position));

        assertThat(blank)
                .isEqualTo(board.findPiece("b1"))
                .isEqualTo(board.findPiece("b2"))
                .isEqualTo(board.findPiece("b3"))
                .isEqualTo(board.findPiece("b4"))
                .isEqualTo(board.findPiece("b6"))
                .isEqualTo(board.findPiece("b7"))
                .isEqualTo(board.findPiece("b8"));

        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("유효하지 않은 좌표값에 대한 예외 처리 테스트")
    public void invalidCoordinate() throws Exception {
        board.initialize();

        assertThatThrownBy(() -> board.findPiece("z9")) // x,y 유효하지 않은 값
                .isInstanceOf(IllegalStateException.class);

        assertThatThrownBy(() -> board.findPiece("a0")) // y 유효하지 않은 값
                .isInstanceOf(IllegalStateException.class);

        assertThatThrownBy(() -> board.findPiece("z5")) // x 유효하지 않은 값
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("흑/백 점수 계산 테스트 - 같은 세로줄 폰 경우 X")
    public void calculatePoint() throws Exception {
        board.initializeEmpty();

        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());

        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());

        // offset으로 부동소수점 오차 방지
        assertThat(board.calculatePoint(BLACK)).isCloseTo(15.0, offset(0.01));
        assertThat(board.calculatePoint(WHITE)).isCloseTo(7.0, offset(0.01));

        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("흑/백 점수 계산 테스트 - 같은 세로줄 폰 경우 O")
    public void calculatePoint2() throws Exception {
        board.initializeEmpty();

        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());
        addPiece("a7", Piece.createBlackPawn());
        addPiece("c7", Piece.createBlackPawn());
        addPiece("d7", Piece.createBlackBishop());
        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());

        addPiece("f4", Piece.createWhiteKnight());
        addPiece("g4", Piece.createWhiteQueen());
        addPiece("f3", Piece.createWhitePawn());
        addPiece("h3", Piece.createWhitePawn());
        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());

        // offset으로 부동소수점 오차 방지
        assertThat(board.calculatePoint(BLACK)).isCloseTo(20.0, offset(0.01));
        assertThat(board.calculatePoint(WHITE)).isCloseTo(19.5, offset(0.01));

        System.out.println(board.showBoard());
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }
}
