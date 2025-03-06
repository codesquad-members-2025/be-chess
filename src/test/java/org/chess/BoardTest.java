package org.chess;

import org.junit.jupiter.api.*;
import org.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.utils.StringUtils.appendNewLine;

public class BoardTest {
    Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("체스 보드 생성 테스트")
    void create() throws Exception {
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
    void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.move(position, piece);

        assertThat(board.findPiece(position)).isEqualTo(piece);
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("주어진 위치의 기물 조회하기")
    public void findPiece() throws Exception {
        board.initialize();
        Piece piece1 = Piece.createBlackRook();
        Piece piece2 = Piece.createBlackRook();
        Piece piece3 = Piece.createWhiteRook();
        Piece piece4 = Piece.createWhiteRook();

        addPiece("a8",piece1);
        addPiece("h8",piece2);
        addPiece("a1",piece3);
        addPiece("h1",piece4);

        assertThat(board.findPiece("a8")).isEqualTo(piece1);
        assertThat(board.findPiece("h8")).isEqualTo(piece2);
        assertThat(board.findPiece("a1")).isEqualTo(piece3);
        assertThat(board.findPiece("h1")).isEqualTo(piece4);
    }

    @Test
    @DisplayName("기본적인 Point 계산하는 테스트")
    void caculcatePoint() throws Exception {
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
    void caculcatePoint2() throws Exception {
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

    @Test
    @DisplayName("기물 리스트 만들고 정렬되었는지 확인하는 테스트")
    void sortTest() throws Exception {
        board.initializeEmpty();
        Piece piece2 = Piece.createBlackKnight();
        Piece piece1 = Piece.createBlackPawn();
        Piece piece4 = Piece.createBlackRook();
        Piece piece3 = Piece.createBlackBishop();

        addPiece("e6", piece2);
        addPiece("c7", piece4);
        addPiece("b6", piece1);
        addPiece("a7", piece3);

        assertThat(board.makeAndSortPieceList(Piece.Color.BLACK,true)).isEqualTo(new ArrayList<>(List.of(piece1,piece2,piece3,piece4)));
        assertThat(board.makeAndSortPieceList(Piece.Color.BLACK,false)).isEqualTo(new ArrayList<>(List.of(piece4,piece3,piece2,piece1)));
        System.out.println(board.showBoard());
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }
}
