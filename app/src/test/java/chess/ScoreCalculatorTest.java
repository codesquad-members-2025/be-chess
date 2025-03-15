package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece;
import pieces.Piece.*;
import static pieces.PieceFactory.*;

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

        board.addPiece("b6", createBlack(Type.PAWN));
        board.addPiece("e6", createBlack(Type.QUEEN));
        board.addPiece("b8", createBlack(Type.KING));
        board.addPiece("c8", createBlack(Type.ROOK));

        board.addPiece("f2", createWhite(Type.PAWN));
        board.addPiece("g2", createWhite(Type.PAWN));
        board.addPiece("e1", createWhite(Type.ROOK));
        board.addPiece("f1", createWhite(Type.KING));

        assertThat(scoreCalculator.calculatePoint(Color.BLACK)).isEqualTo(15.0);
        assertThat(scoreCalculator.calculatePoint(Color.WHITE)).isEqualTo(7.0);
    }

    @Test
    @DisplayName("같은 column에 있는 PAWN 점수 계산")
    public void calculatePoint_pawnsInSameColumn() {
        board.initializeEmpty();

        board.addPiece("a2", createWhite(Type.PAWN));
        board.addPiece("a3", createWhite(Type.PAWN)); // 같은 col: 0.5+0.5

        board.addPiece("b2", createWhite(Type.PAWN)); // 1.0

        assertThat(scoreCalculator.calculatePoint(Color.WHITE)).isEqualTo(2);

    }


    @Test
    @DisplayName("체스판 내 기물 정렬")
    public void sortPiecesbyScore() {
        board.initializeEmpty();

        board.addPiece("b6", createBlack(Type.PAWN));  // PAWN(1.0)
        board.addPiece("e6", createBlack(Type.QUEEN));  // Queen (9.0)
        board.addPiece("b8", createBlack(Type.KING));  // KING (0.0)
        board.addPiece("c8", createBlack(Type.ROOK));  // Rook (5.0)

        List<Piece> sortedBlackPieces = scoreCalculator.sortByScore(Color.BLACK, true);

        assertThat(sortedBlackPieces.get(0).getType()).isEqualTo(Type.QUEEN);
        assertThat(sortedBlackPieces.get(1).getType()).isEqualTo(Type.ROOK);
        assertThat(sortedBlackPieces.get(2).getType()).isEqualTo(Type.PAWN);
        assertThat(sortedBlackPieces.get(3).getType()).isEqualTo(Type.KING);

        board.addPiece("f2", createWhite(Type.PAWN));  // PAWN(1.0)
        board.addPiece("g2", createWhite(Type.PAWN));  //  PAWN(1.0)
        board.addPiece("e1", createWhite(Type.ROOK));  //  Rook (5.0)
        board.addPiece("f1", createWhite(Type.KING));  //  KING (0.0)

        List<Piece> sortedWhitePieces = scoreCalculator.sortByScore(Piece.Color.WHITE, true);

        assertThat(sortedWhitePieces.get(0).getType()).isEqualTo(Type.ROOK);
        assertThat(sortedWhitePieces.get(1).getType()).isEqualTo(Type.PAWN);
        assertThat(sortedWhitePieces.get(2).getType()).isEqualTo(Type.PAWN);
        assertThat(sortedWhitePieces.get(3).getType()).isEqualTo(Type.KING);

    }

}
