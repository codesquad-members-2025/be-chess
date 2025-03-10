package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece;

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

        addPiece("b6", Piece.createBlack(Piece.Type.PAWN));  // Rook (5.0)
        addPiece("e6", Piece.createBlack(Piece.Type.QUEEN));  // Knight (2.5)
        addPiece("b8", Piece.createBlack(Piece.Type.KING));  // Bishop (3.0)
        addPiece("c8", Piece.createBlack(Piece.Type.ROOK));  // Queen (9.0)

        addPiece("f2", Piece.createWhite(Piece.Type.PAWN));  // Rook (5.0)
        addPiece("g2", Piece.createWhite(Piece.Type.PAWN));  // Knight (2.5)
        addPiece("e1", Piece.createWhite(Piece.Type.ROOK));  // Bishop (3.0)
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

}
