package chess;

import org.junit.jupiter.api.*;
import pieces.Piece;
import pieces.Position;
import pieces.Type;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    private Board board;
    private Game game;
    private ChessView view;

    @BeforeEach
    void setup(){
        board = new Board();
        view = new ChessView(board);
        game = new Game(board, view);
    }

    @Test
    @DisplayName("기물들의 각 사정거리 내로 이동할 수 있는지 체크한다.")
    public void PawnMoveTest(){
        board.initialize();
        game.move("e7", "e5");

        Piece source = board.findPiece(new Position("e7"));
        Piece target = board.findPiece(new Position("e5"));

        assertThat(source.getType()).isEqualTo(Type.PAWN);
        assertThat(target.getType()).isEqualTo(Type.NO_PIECE);
    }

    @Test
    @DisplayName("폰은 시작점에서만 2칸 전진이 가능하고, 대각선 1칸은 상대 기물이 있을때만 가능하다, 나머지는 다 1칸씩 전진만 가능해야 한다.")
    public void PawnTest(){
        board.initialize();
        Piece whitePawn = board.findPiece(new Position("f2"));
        //시작 지점에선 2칸 가능
        assertThat(whitePawn.canMove(new Position("f4"), board)).isTrue();

        game.move("f2", "f4");
        assertThat(whitePawn.canMove(new Position("f6"), board)).isFalse();//시작점이 아니라면 1칸만 가능
        assertThat(whitePawn.canMove(new Position("f3"), board)).isFalse();//뒤로 못감
        assertThat(whitePawn.canMove(new Position("g5"), board)).isFalse(); //대각선도 안가짐

        game.move("g7", "g5");
        assertThat(whitePawn.canMove(new Position("g5"), board)).isTrue();//대각선이 상대 기물이라면 가능 (화이트)
        Piece blackPawn = board.findPiece(new Position("g5"));
        assertThat(blackPawn.canMove(new Position("f4"), board)).isTrue(); //대각선이 상대 기물이라면 가능 (블랙)

        //3번 라인에 블랙 기물위치함
        board.getPieces().get(5).setPiece(0,Piece.create(Type.KING, Piece.Color.BLACK, new Position("a3")));
        Piece whitePawn1 = board.findPiece(new Position("a2"));
        assertThat(whitePawn1.canMove(new Position("a4"), board)).isFalse(); //안가짐
        game.move("f4", "f5");
    }

    @Test
    @DisplayName("대각선으로 갈 수 있는 기물은 앞에 기물에 가로막혀있으면 가지 못한다. 하지만 타겟지점이 다른색 말이라면 잡을 수 있다.")
    public void linerTest(){
        board.initializeEmpty();
        board.getPieces().get(1).setPiece(0,Piece.create(Type.QUEEN, Piece.Color.BLACK, new Position("a7")));
        board.getPieces().get(1).setPiece(1,Piece.create(Type.PAWN, Piece.Color.BLACK, new Position("b7")));
        board.getPieces().get(6).setPiece(0,Piece.create(Type.PAWN, Piece.Color.WHITE, new Position("a2")));
        board.getPieces().get(6).setPiece(1,Piece.create(Type.ROOK, Piece.Color.WHITE, new Position("b2")));

        System.out.println(view.showBoard());

        Piece whiteRook = board.findPiece(new Position("b2"));
        Piece blackQueen = board.findPiece(new Position("a7"));

        //룩 검사
        assertThat(whiteRook.canMove(new Position("a2"), board)).isFalse(); //우리팀이 막고있으면 안됨
        assertThat(whiteRook.canMove(new Position("b7"), board)).isTrue(); //적 기물이면 가능
        assertThat(whiteRook.canMove(new Position("h2"), board)).isTrue(); //빈 공간이면 가능
        assertThat(whiteRook.canMove(new Position("b8"), board)).isFalse(); //점프 불가능

        //퀸 검사
        assertThat(blackQueen.canMove(new Position("b7"), board)).isFalse(); //우리팀이 막고있으면 안됨
        assertThat(blackQueen.canMove(new Position("a2"), board)).isTrue(); //적 기물이면 가능
        assertThat(blackQueen.canMove(new Position("a3"), board)).isTrue(); //빈 공간이면 가능
        assertThat(blackQueen.canMove(new Position("a1"), board)).isFalse(); //점프 불가능
    }

    @Test
    @DisplayName("선형으로 갈 수 있는 기물은 앞에 기물에 가로막혀있으면 가지 못한다. 하지만 타겟지점이 다른색 말이라면 잡을 수 있다.")
    public void diagonalTest(){
        board.initializeEmpty();
        board.getPieces().get(1).setPiece(1,Piece.create(Type.QUEEN, Piece.Color.BLACK, new Position("b7")));
        board.getPieces().get(6).setPiece(6,Piece.create(Type.BISHOP, Piece.Color.WHITE, new Position("g2")));

        Piece blackQueen = board.findPiece(new Position("b7"));
        Piece whiteBishop = board.findPiece(new Position("g2"));

        System.out.println(view.showBoard());

        //퀸 검사
        assertThat(blackQueen.canMove(new Position("g2"), board)).isTrue(); //적 기물이면 가능
        assertThat(blackQueen.canMove(new Position("f3"), board)).isTrue(); //빈 공간이면 가능
        assertThat(blackQueen.canMove(new Position("h1"), board)).isFalse(); //점프 불가능

        //비숍검사
        assertThat(whiteBishop.canMove(new Position("b7"), board)).isTrue(); //적 기물이면 가능
        assertThat(whiteBishop.canMove(new Position("c6"), board)).isTrue(); //빈 공간이면 가능
        assertThat(whiteBishop.canMove(new Position("a8"), board)).isFalse(); //점프 불가능

        // 중간에 폰을 놓고 검사
        board.getPieces().get(3).setPiece(3,Piece.create(Type.PAWN, Piece.Color.BLACK, new Position("d5")));
        board.getPieces().get(4).setPiece(4,Piece.create(Type.PAWN, Piece.Color.WHITE, new Position("e4")));
        // 비숍검사
        assertThat(whiteBishop.canMove(new Position("e4"), board)).isFalse();// 타겟이 우리팀이면 False가 되는지
        assertThat(whiteBishop.canMove(new Position("d5"), board)).isFalse();// 타겟이 적이면 점프가 되는지
        //퀸검사
        assertThat(blackQueen.canMove(new Position("e4"), board)).isFalse();// 타겟이 우리팀이면 False가 되는지
        assertThat(blackQueen.canMove(new Position("d5"), board)).isFalse();// 타겟이 적이면 점프가 되는지
    }

    @Test
    @DisplayName("나이트는 빈 공간이거나 적 기물이 있는곳만 갈 수 있다.")
    public void knightTest(){
        board.initialize();
        Piece whiteKnight = board.findPiece(new Position("b1"));
        assertThat(whiteKnight.canMove(new Position("a3"), board)).isTrue(); //빈 공간일 때
        assertThat(whiteKnight.canMove(new Position("c3"), board)).isTrue(); //빈 공간일 때
        assertThat(whiteKnight.canMove(new Position("d2"), board)).isFalse(); //우리팀 기물이 있을때

        board.getPieces().get(5).setPiece(3,Piece.create(Type.PAWN, Piece.Color.BLACK, new Position("c3")));
        assertThat(whiteKnight.canMove(new Position("a3"), board)).isTrue(); //상대 기물이 있을때
        game.move("b1","c3");
        assertThat(whiteKnight.canMove(new Position("d1"), board)).isFalse();
    }

    @Test
    @DisplayName("king은 주위 8방향으로 이동할 수 있다. 단 우리팀이 있을 때는 이동할 수 없다.")
    public void kingTest(){
        board.initializeEmpty();
        board.getPieces().get(2).setPiece(2,Piece.create(Type.QUEEN, Piece.Color.BLACK, new Position("c6")));
        board.getPieces().get(3).setPiece(3,Piece.create(Type.KING, Piece.Color.BLACK, new Position("d5")));
        board.getPieces().get(4).setPiece(4,Piece.create(Type.ROOK, Piece.Color.WHITE, new Position("e4")));

        Piece blackKing = board.findPiece(new Position("d5"));

        assertThat(blackKing.canMove(new Position("d6"), board)).isTrue(); //빈칸으로 이동
        assertThat(blackKing.canMove(new Position("e4"), board)).isTrue(); //적팀으로 이동
        assertThat(blackKing.canMove(new Position("c6"), board)).isFalse(); //본인 팀으로 이동
    }

    @Test
    @DisplayName("블랭크는 이동할 수 없다.")
    public void blankTest(){
        board.initialize();
        Piece blank = board.findPiece(new Position("c4"));
        assertThat(blank.canMove(new Position("a3"), board)).isFalse();
    }
}
