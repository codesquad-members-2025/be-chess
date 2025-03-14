package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.within;
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

    @Test
    @DisplayName("각 기물별 점수가 더해져야 하며 PAWN의 경우 같은 세로줄에 있을 때 0.5점으로 계산되어야 한다.")
    public void calculatePoint() throws Exception {
        board.initializeEmptyBoard();

        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());

        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());

        assertThat(board.calculatePoint(Piece.Color.BLACK))
                .isCloseTo(15.0, within(0.01));

        assertThat(board.calculatePoint(Piece.Color.WHITE))
                .isCloseTo(7.0, within(0.01));

        System.out.println(board.showBoard());
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }

    @Test
    @DisplayName("기물의 점수가 내림차순으로 정렬되어야 한다.")
    public void sortPiecesDescending(){

        board.initializeEmptyBoard();

        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());

        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());

        List<Piece> reverseSortedBlackPiecesList = board.sortPiecesDescending(Piece.Color.BLACK);
        List<Piece> reverseSortedWhitePiecesList = board.sortPiecesDescending(Piece.Color.WHITE);

        assertThat(reverseSortedBlackPiecesList)
                .extracting(Piece::getColor)
                .containsOnly(Piece.Color.BLACK);

        assertThat(reverseSortedBlackPiecesList)
                .extracting(piece -> piece.getType().getDefaultPoint())
                .isSortedAccordingTo(Comparator.reverseOrder());

        assertThat(reverseSortedWhitePiecesList)
                .extracting(Piece::getColor)
                .containsOnly(Piece.Color.WHITE);

        assertThat(reverseSortedWhitePiecesList)
                .extracting(piece -> piece.getType().getDefaultPoint())
                .isSortedAccordingTo(Comparator.reverseOrder());



    }


    @Test
    @DisplayName("기물의 점수가 오름차순으로 정렬되어야 한다.")
    public void sortPiecesAscending(){

        board.initializeEmptyBoard();

        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());

        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());

        List<Piece> sortedBlackPiecesList = board.sortPiecesAscending(Piece.Color.BLACK);
        List<Piece> sortedWhitePiecesList = board.sortPiecesAscending(Piece.Color.WHITE);

        assertThat(sortedBlackPiecesList)
                .extracting(Piece::getColor)
                .containsOnly(Piece.Color.BLACK);

        assertThat(sortedBlackPiecesList)
                .extracting(piece -> piece.getType().getDefaultPoint())
                .isSortedAccordingTo(Comparator.naturalOrder());

        assertThat(sortedWhitePiecesList)
                .extracting(Piece::getColor)
                .containsOnly(Piece.Color.WHITE);

        assertThat(sortedWhitePiecesList)
                .extracting(piece -> piece.getType().getDefaultPoint())
                .isSortedAccordingTo(Comparator.naturalOrder());


    }






}
