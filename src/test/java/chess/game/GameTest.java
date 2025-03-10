package chess.game;

import chess.board.Board;
import chess.enums.Color;
import chess.piece.Pawn;
import chess.piece.Piece;
import chess.piece.Queen;
import chess.record.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameTest {
    private Game game;
    private Board board;

    @BeforeEach
    @DisplayName("체스 게임 초기화")
    void setUp() {
        board = new Board();
        game = new Game(board);
    }

    @Test
    @DisplayName("유효한 위치에 말을 배치할 수 있다")
    void testMove_ValidMove() {
        Piece pawn = new Pawn(Color.WHITE);
        game.move("e2", pawn);

        Position position = new Position(4, 6);
        assertThat(board.getBoard()[position.yPos()][position.xPos()]).isEqualTo(pawn);
    }

    @Test
    @DisplayName("잘못된 위치에 말을 배치하면 예외가 발생한다")
    void testMove_InvalidMove_OutOfBounds() {
        Piece pawn = new Pawn(Color.WHITE);
        assertThatThrownBy(() -> game.move("z9", pawn))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("체스 보드판의 범위를 벗어난 값을 입력했습니다.");
    }

    @Test
    @DisplayName("말을 정상적으로 이동시킬 수 있다")
    void testMove_PieceMovement() {
        Piece pawn = new Pawn(Color.WHITE);
        game.move("e2", pawn);
        game.move("e2", "e4");

        Position targetPosition = new Position(4, 4);
        Position sourcePosition = new Position(4, 6);

        assertThat(board.getBoard()[targetPosition.yPos()][targetPosition.xPos()]).isEqualTo(pawn);
        assertThat(board.getBoard()[sourcePosition.yPos()][sourcePosition.xPos()]).isEqualTo(Piece.createBlank());
    }

    @Test
    @DisplayName("잘못된 이동을 시도하면 예외가 발생한다")
    void testMove_InvalidPieceMovement() {
        Piece queen = new Queen(Color.BLACK);
        game.move("d8", queen);

        assertThatThrownBy(() -> game.move("d8", "h4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("해당 위치로 이동할 수 없는 기물입니다.");
    }

    @Test
    @DisplayName("폰 하나의 점수를 올바르게 계산할 수 있다")
    void testCalculatePoint_SinglePawn() {
        Piece pawn = new Pawn(Color.WHITE);
        game.move("a2", pawn);
        assertThat(game.calculatePoint(Color.WHITE)).isEqualTo(1.0);
    }

    @Test
    @DisplayName("같은 열에 두 개의 폰이 있을 때 점수를 올바르게 계산한다")
    void testCalculatePoint_DoublePawnColumn() {
        game.move("a2", new Pawn(Color.WHITE));
        game.move("a3", new Pawn(Color.WHITE));

        assertThat(game.calculatePoint(Color.WHITE)).isEqualTo(1.0); // 0.5 * 2
    }

    @Test
    @DisplayName("퀸의 점수를 올바르게 계산할 수 있다")
    void testCalculatePoint_Queen() {
        game.move("d1", new Queen(Color.WHITE));

        assertThat(game.calculatePoint(Color.WHITE)).isEqualTo(9.0);
    }

    @Test
    @DisplayName("현재 플레이어의 말인지 확인할 수 있다")
    void testIsValidMove_ValidPiece() {
        game.move("e2", new Pawn(Color.WHITE));
        assertThat(game.isValidMove("e2", Color.WHITE)).isTrue();
    }

    @Test
    @DisplayName("상대 플레이어의 말을 움직일 수 없다")
    void testIsValidMove_InvalidPiece() {
        assertThat(game.isValidMove("e2", Color.BLACK)).isFalse();
    }

    @Test
    @DisplayName("빈 위치를 선택하면 유효하지 않다")
    void testIsValidMove_EmptyPosition() {
        assertThat(game.isValidMove("d4", Color.WHITE)).isFalse();
    }
}
