package chess.game;

import chess.board.Board;
import chess.enums.Color;
import chess.piece.Pawn;
import chess.piece.Piece;
import chess.piece.Queen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GameTest {

    private Game game;
    private Board board;

    @BeforeEach
    void setUp(){
        board = new Board();
        game = new Game(board);
    }

    @Test
    @DisplayName("폰 이동 테스트")
    void testPawnMove(){
        //Given: 특정 위치에 폰 배치
        String initialPosition = "e2";
        String targetPosition = "e4";
        Piece pawn = new Pawn(Color.WHITE);
        game.move(initialPosition,pawn);

        // When: 폰을 이동시킴
        game.move(initialPosition, targetPosition);

        // Then: 원래 위치는 비어 있고, 새로운 위치에 폰이 있어야 함
        assertThat(board.findPiece(initialPosition)).isEqualTo(Piece.createBlank());
        assertThat(board.findPiece(targetPosition)).isEqualTo(pawn);
    }

    @Test
    @DisplayName("기물 점수 계산 테스트")
    void testCalculatePoint() {
        // Given: 보드에 기물 추가
        game.move("d1", new Queen(Color.WHITE));
        game.move("e2", new Pawn(Color.WHITE));
        game.move("e3", new Pawn(Color.WHITE));
        game.move("e4", new Pawn(Color.WHITE)); // 같은 열에 3개의 폰

        // When: 점수를 계산
        double whiteScore = game.calculatePoint(Color.WHITE);

        // Then: 폰 3개 (첫 번째 1점, 나머지 0.5점) + 퀸 9점 = 10점
        assertThat(whiteScore).isEqualTo(10.0);
    }
}
