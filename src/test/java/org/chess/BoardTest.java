package org.chess;

import org.junit.jupiter.api.*;
import org.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.utils.StringUtils.appendNewLine;

public class BoardTest {
    Board board;
    BoardStatus boardStatus;
    Game game;

    @BeforeEach
    void setUp() {
        board = new Board();
        boardStatus = new BoardStatus(board);
        game = new Game(board);
    }

    @Test
    @DisplayName("기본 이동 테스트")
    public void move() throws Exception {
        board.initialize();
        String sourcePosition = "b2";
        String targetPosition = "b3";
        game.move(sourcePosition, targetPosition);
        assertThat(Piece.createBlank()).isEqualTo(board.findPiece(new Coordinate(sourcePosition)));
        assertThat(Piece.createWhitePawn()).isEqualTo(board.findPiece(new Coordinate(targetPosition)));
    }


    @Test
    @DisplayName("체스 보드 생성 테스트")
    void create() throws Exception {
        board.initialize();
        assertThat(boardStatus.pieceCount()).isEqualTo(32);
        String blankRank = appendNewLine("........");
        assertThat(boardStatus.showBoard())
                .isEqualTo(appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"));
    }

    @Test
    @DisplayName("원하는 위치에 기물 추가할 수 있는지 확인")
    void 기물추가() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.putPiece(new Coordinate(position), piece);

        assertThat(board.findPiece(new Coordinate(position))).isEqualTo(piece);
        System.out.println(boardStatus.showBoard());
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

        assertThat(board.findPiece(new Coordinate("a8"))).isEqualTo(piece1);
        assertThat(board.findPiece(new Coordinate("h8"))).isEqualTo(piece2);
        assertThat(board.findPiece(new Coordinate("a1"))).isEqualTo(piece3);
        assertThat(board.findPiece(new Coordinate("h1"))).isEqualTo(piece4);
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

        assertThat(boardStatus.calculatePoint(Piece.Color.BLACK)).isCloseTo(15.0, within(0.01));
        assertThat(boardStatus.calculatePoint(Piece.Color.WHITE)).isCloseTo(7.0, within(0.01));
        System.out.println(boardStatus.showBoard());
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

        assertThat(boardStatus.calculatePoint(Piece.Color.BLACK)).isCloseTo(20.0, within(0.01));
        assertThat(boardStatus.calculatePoint(Piece.Color.WHITE)).isCloseTo(19.5, within(0.01));
        System.out.println(boardStatus.showBoard());
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

        assertThat(boardStatus.makeAndSortPieceList(Piece.Color.BLACK,true)).isEqualTo(new ArrayList<>(List.of(piece1,piece2,piece3,piece4)));
        assertThat(boardStatus.makeAndSortPieceList(Piece.Color.BLACK,false)).isEqualTo(new ArrayList<>(List.of(piece4,piece3,piece2,piece1)));
        System.out.println(boardStatus.showBoard());
    }

    @Test
    @DisplayName("Game이 각 기물의 이동 법칙에 맞게 움직일 수 있다.")
    void Game의Move확인() throws Exception {
        board.initialize();
        Game game = new Game(board);
        Piece blackPawn = board.findPiece(new Coordinate(3,1));
        Piece blackQueen = board.findPiece(new Coordinate(3,0));

        // 폰 두칸전진
        game.move("d2","d3");
        game.move("d3","d4");
        // 퀸 이동
        game.move("d1","d3");
        game.move("d3","a6");

        //이동 안함
        game.move("a6","a8");

        // 이동함
        game.move("a6","a7");
        game.move("a7","a4");

        //이동 안함
        game.move("a4","a2");

        //d4는 폰, a7은 빈칸, a4는 퀸, a2는 폰이어야함.
        assertThat(board.findPiece(new Coordinate(3,3)).getType()).isEqualTo(Piece.Type.PAWN);
        assertThat(board.findPiece(new Coordinate(0,6)).getType()).isEqualTo(Piece.Type.NO_PIECE);
        assertThat(board.findPiece(new Coordinate(0,3)).getType()).isEqualTo(Piece.Type.QUEEN);
        assertThat(board.findPiece(new Coordinate(0,1)).getType()).isEqualTo(Piece.Type.PAWN);

        System.out.println(boardStatus.showBoard());
        System.out.println(board.findPiece(new Coordinate(3,2)).getType());
    }

    private void addPiece(String position, Piece piece) {
        board.putPiece(new Coordinate(position), piece);
    }
}
