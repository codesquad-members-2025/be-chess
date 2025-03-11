package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreCalculatorTest {
    private Board board;
    private ScoreCalculator scoreCalculator;

    @BeforeEach
    public void setup() {
        board = new Board();
        scoreCalculator = new ScoreCalculator(board);
    }

    @Test
    @DisplayName("기본 점수 계산 테스트 - 기물 한 개씩 배치")
    public void calculatePoint() throws Exception {
        board.initializeEmpty();

        addPiece("b6", Piece.createBlack(Piece.Type.PAWN));
        addPiece("e6", Piece.createBlack(Piece.Type.QUEEN));
        addPiece("b8", Piece.createBlack(Piece.Type.KING));
        addPiece("c8", Piece.createBlack(Piece.Type.ROOK));

        addPiece("f2", Piece.createWhite(Piece.Type.PAWN));
        addPiece("g2", Piece.createWhite(Piece.Type.PAWN));
        addPiece("e1", Piece.createWhite(Piece.Type.ROOK));
        addPiece("f1", Piece.createWhite(Piece.Type.KING));

        assertThat(scoreCalculator.calculatePoint(Piece.Color.BLACK)).isEqualTo(15.0);
        assertThat(scoreCalculator.calculatePoint(Piece.Color.WHITE)).isEqualTo(7.0);
    }

    @Test
    @DisplayName("같은 column에 있는 PAWN 점수 계산")
    public void calculatePoint_pawnsInSameColumn() {
        board.initializeEmpty();

        addPiece("a2", Piece.createWhite(Piece.Type.PAWN));
        addPiece("a3", Piece.createWhite(Piece.Type.PAWN)); // 같은 col: 0.5+0.5

        addPiece("b2", Piece.createWhite(Piece.Type.PAWN)); // 1.0

        assertThat(scoreCalculator.calculatePoint(Piece.Color.WHITE)).isEqualTo(2);

    }
    
    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }

    @Test
    @DisplayName("체스판 내 기물 정렬")
    public void sortPiecesbyScore() {
        board.initializeEmpty();

        addPiece("b6", Piece.createBlack(Piece.Type.PAWN));  // PAWN(1.0)
        addPiece("e6", Piece.createBlack(Piece.Type.QUEEN));  // Queen (9.0)
        addPiece("b8", Piece.createBlack(Piece.Type.KING));  // KING (0.0)
        addPiece("c8", Piece.createBlack(Piece.Type.ROOK));  // Rook (5.0)

        List<Piece> sortedBlackPieces = scoreCalculator.sortByScore(Piece.Color.BLACK, true);

        assertThat(sortedBlackPieces.get(0).getType()).isEqualTo(Piece.Type.QUEEN);
        assertThat(sortedBlackPieces.get(1).getType()).isEqualTo(Piece.Type.ROOK);
        assertThat(sortedBlackPieces.get(2).getType()).isEqualTo(Piece.Type.PAWN);
        assertThat(sortedBlackPieces.get(3).getType()).isEqualTo(Piece.Type.KING);

        addPiece("f2", Piece.createWhite(Piece.Type.PAWN));  // PAWN(1.0)
        addPiece("g2", Piece.createWhite(Piece.Type.PAWN));  //  PAWN(1.0)
        addPiece("e1", Piece.createWhite(Piece.Type.ROOK));  //  Rook (5.0)
        addPiece("f1", Piece.createWhite(Piece.Type.KING));  //  KING (0.0)

        List<Piece> sortedWhitePieces = scoreCalculator.sortByScore(Piece.Color.WHITE, true);

        assertThat(sortedWhitePieces.get(0).getType()).isEqualTo(Piece.Type.ROOK);
        assertThat(sortedWhitePieces.get(1).getType()).isEqualTo(Piece.Type.PAWN);
        assertThat(sortedWhitePieces.get(2).getType()).isEqualTo(Piece.Type.PAWN);
        assertThat(sortedWhitePieces.get(3).getType()).isEqualTo(Piece.Type.KING);

    }

}
