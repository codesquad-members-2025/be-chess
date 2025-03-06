package org.chess;

import org.junit.jupiter.api.*;
import org.pieces.Piece;

import static org.assertj.core.api.Assertions.*;
import static org.utils.StringUtils.appendNewLine;

public class BoardTest {
    Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("체스 보드 생성 테스트")
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
    @DisplayName("원하는 위치에 기물 추가할 수 있는지 확인")
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.move(position, piece);

        assertThat(board.findPiece(position)).isEqualTo(piece);
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("기본적인 Point 계산하는 테스트")
    public void caculcatePoint() throws Exception {
        board.initializeEmpty();

        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());

        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());

        assertThat(board.calculatePoint(Piece.Color.BLACK)).isCloseTo(15.0, within(0.01));
        assertThat(board.calculatePoint(Piece.Color.WHITE)).isCloseTo(7.0, within(0.01));
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("좀 더 많은 Point 계산하는 테스트")
    public void caculcatePoint2() throws Exception {
        board.initializeEmpty();

        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("a7", Piece.createBlackPawn());
        addPiece("c7", Piece.createBlackPawn());
        addPiece("d7", Piece.createBlackBishop());
        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());

        addPiece("f4", Piece.createWhiteKnight());
        addPiece("g4", Piece.createWhiteQueen());
        addPiece("f3", Piece.createWhitePawn());
        addPiece("h3", Piece.createWhitePawn());
        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());

        assertThat(board.calculatePoint(Piece.Color.BLACK)).isCloseTo(20.0, within(0.01));
        assertThat(board.calculatePoint(Piece.Color.WHITE)).isCloseTo(19.5, within(0.01));
        System.out.println(board.showBoard());
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }
}
