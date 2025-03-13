package chess;

import org.junit.jupiter.api.*;
import pieces.*;
import pieces.Piece.*;
import pieces.Position;
import pieces.Type;

import static org.assertj.core.api.Assertions.*;

public class BoardTest {
    private Board board;

    @BeforeEach
    void setup(){
        board = new Board();
    }

    @Test
    @DisplayName("기물마다 해당되는 위치에 초기화 되어야한다.")
    public void findPiece() throws Exception {
        board.initialize();
        assertThat(board.findPiece(new Position("a8"))).isEqualTo(Piece.create(Type.ROOK, Color.BLACK,new Position("a8")));
        assertThat(board.findPiece(new Position("b8"))).isEqualTo(Piece.create(Type.KNIGHT, Color.BLACK,new Position("b8")));
        assertThat(board.findPiece(new Position("c8"))).isEqualTo(Piece.create(Type.BISHOP, Color.BLACK,new Position("c8")));
        assertThat(board.findPiece(new Position("a7"))).isEqualTo(Piece.create(Type.PAWN, Color.BLACK,new Position("a7")));
        assertThat(board.findPiece(new Position("d2"))).isEqualTo(Piece.create(Type.PAWN, Color.WHITE,new Position("d2")));
        assertThat(board.findPiece(new Position("e1"))).isEqualTo(Piece.create(Type.KING, Color.WHITE,new Position("e1")));
        assertThat(board.findPiece(new Position("f1"))).isEqualTo(Piece.create(Type.BISHOP, Color.WHITE,new Position("f1")));
        assertThat(board.findPiece(new Position("g1"))).isEqualTo(Piece.create(Type.KNIGHT, Color.WHITE,new Position("g1")));
    }

    @Test
    @DisplayName("보드 초기화 코드가 진정 \".\"으로 이뤄졌는지 확인하는 코드")
    public void isEmpty(){
        board.initializeEmpty();
        for(Rank rank : board.getPieces()){
            for(Piece piece : rank.getPieces()){
                assertThat(Type.NO_PIECE).isEqualTo(piece.getType());
            }
        }
    }

    @Test
    @DisplayName("게임을 끝내기 위해 킹이 살았는지 죽었는지 판별할 수 있어야한다.")
    public void servivesKing(){
        board.initializeEmpty();
        assertThat(board.isKingAlive(Color.BLACK)).isFalse();
        assertThat(board.isKingAlive(Color.WHITE)).isFalse();

        board.getPieces().get(0).setPiece(0, Piece.create(Type.KING, Color.BLACK, new Position("a8")));
        board.getPieces().get(0).setPiece(1, Piece.create(Type.KING, Color.WHITE, new Position("b8")));

        assertThat(board.isKingAlive(Color.BLACK)).isTrue();
        assertThat(board.isKingAlive(Color.WHITE)).isTrue();
    }
}
