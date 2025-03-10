package chess;

import org.junit.jupiter.api.*;
import pieces.Piece;
import pieces.Piece.*;
import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
        assertThat(board.findPiece("a8")).isEqualTo(Piece.createBlackRook());
        assertThat(board.findPiece("h8")).isEqualTo(Piece.createBlackRook());
        assertThat(board.findPiece("a1")).isEqualTo(Piece.createWhiteRook());
        assertThat(board.findPiece("h1")).isEqualTo(Piece.createWhiteRook());
    }

    @Test
    @DisplayName("체스 판의 기물을 이동하려면 체스 판의 임의의 위치에 기물을 추가할 수 있어야 한다.")
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.move(position, piece);

        assertThat(board.findPiece(position)).isEqualTo(piece);
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("검은색 말들의 순위를 출력할 수 있어야한다.")
    public void testSortBlackAscending() throws Exception {
        board.initialize();
        ArrayList<Piece> sortBlack = board.sortByScore(Color.BLACK, false);
        checkPieces(sortBlack);
    }

    @Test
    @DisplayName("흰색 말들의 순위를 출력할 수 있어야한다.")
    public void testSortWhiteAscending() {
        board.initialize();
        ArrayList<Piece> sortWhite = board.sortByScore(Color.WHITE, false);
        checkPieces(sortWhite);
    }

    private void checkPieces(ArrayList<Piece> sortedPieces) {
        Type[] expectedTypes = {
                Type.QUEEN, Type.ROOK, Type.ROOK, Type.BISHOP, Type.BISHOP, Type.KNIGHT, Type.KNIGHT, Type.PAWN
        };

        for (int i = 0; i < expectedTypes.length; i++) {
            assertThat(sortedPieces.get(i).getType()).isEqualTo(expectedTypes[i]);
        }
    }

    @Test
    @DisplayName("현재까지 남아 있는 기물에 따라 점수를 계산할 수 있어야 한다.")
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

        assertEquals(15.0, board.caculcatePoint(Color.BLACK), 0.01);
        assertEquals(7.0, board.caculcatePoint(Color.WHITE), 0.01);


        System.out.println(board.showBoard());
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }
}
