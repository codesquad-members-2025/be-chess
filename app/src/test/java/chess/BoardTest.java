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
    void setUp() {
        board = new Board();
    }

    @Test
    public void create() throws Exception {
        //Given & When
        String blankRank = appendNewLine("........");
        String expectedBoard = appendNewLine("RNBQKBNR") +
            appendNewLine("PPPPPPPP") +
            blankRank + blankRank + blankRank + blankRank +
            appendNewLine("pppppppp") +
            appendNewLine("rnbqkbnr");
        board.initialize();
        int pieceCount = board.pieceCount();
        String actualBoard = board.showBoard();


        //Then
        assertThat(pieceCount).isEqualTo(32);
        assertThat(actualBoard).isEqualTo(expectedBoard);
    }

    @Test
    @DisplayName("체스 보드 초기화 시 검은색 폰 8개가 존재해야 한다")
    void countPiece() {
        //Given
        board.initialize();
        Piece.Color color = Piece.Color.BLACK;
        Piece.Type type = Piece.Type.PAWN;
        int expectedCount = 8;

        //When
        int actualCount = board.countPiece(color, type);

        //Then
        assertThat(actualCount).isEqualTo(expectedCount);
    }

    @Test
    @DisplayName("a8 위치에 검은색 룩이 존재해야한다.")
    void searchPiece() {
        //Given
        board.initialize();
        Piece expectedPiece = new Piece(Piece.Color.BLACK, Piece.Type.ROOK);

        //When
        Piece actualPiece = board.searchPiece(new Position("a8"));

        //Then
        assertThat(actualPiece.getType()).isEqualTo(expectedPiece.getType());
        assertThat(actualPiece.getColor()).isEqualTo(expectedPiece.getColor());
    }

    @Test
    @DisplayName("검은색 룩이 b5로 위치해있어야한다.")
    void move() throws Exception {
        //Given
        board.setEmptyBoard();
        Piece piece = new Piece(Piece.Color.BLACK, Piece.Type.ROOK);
        Position position = new Position("b5");

        //When
        board.move(position, piece);

        //Then
        assertThat(board.searchPiece(position).getColor()).isEqualTo(piece.getColor());
        assertThat(board.searchPiece(position).getType()).isEqualTo(piece.getType());
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("검은색 체스말의 점수는 15점, 흰색 체스말의 점수는 7점을 갖는다.")
    void calculatePoint() throws Exception {
        //Given
        board.setEmptyBoard();
        board.move(new Position("b6"), new Piece(Piece.Color.BLACK, Piece.Type.PAWN));
        board.move(new Position("e6"), new Piece(Piece.Color.BLACK, Piece.Type.QUEEN));
        board.move(new Position("b8"), new Piece(Piece.Color.BLACK, Piece.Type.KING));
        board.move(new Position("c8"), new Piece(Piece.Color.BLACK, Piece.Type.ROOK));

        board.move(new Position("f2"), new Piece(Piece.Color.WHITE, Piece.Type.PAWN));
        board.move(new Position("g2"), new Piece(Piece.Color.WHITE, Piece.Type.PAWN));
        board.move(new Position("e2"), new Piece(Piece.Color.WHITE, Piece.Type.ROOK));
        board.move(new Position("f1"), new Piece(Piece.Color.WHITE, Piece.Type.KING));

        //When & Then
        assertThat(board.calculatePoint(Piece.Color.BLACK)).isEqualTo(15.0);
        assertThat(board.calculatePoint(Piece.Color.WHITE)).isEqualTo(7.0);
    }
}
