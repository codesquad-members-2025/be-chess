package chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import pieces.Piece;
import pieces.Piece.Type;


import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    private Board board;
    private Game game;

    @BeforeEach
    public void setup() {
        board = new Board();
        game =  new Game(board);

    }

    @Test
    @DisplayName("king이 잘 움직이는지 확인")
    public void moveKing() {
        board.initialize();
        board.removePiece("d7");

        String sourcePosition = "e8";
        String targetPosition = "d7";
        game.move(sourcePosition, targetPosition);
        assertThat(game.findPiece(sourcePosition)).isEqualTo(Piece.createBlank());
        assertThat(game.findPiece(targetPosition)).isEqualTo(Piece.createBlack(Type.KING));
    }
    @Test
    @DisplayName("king 움직임 예외처리 - 한 칸씩만 이동 가능")
    public void invalidKingMove() {
        board.initialize();
        String sourcePosition = "e8";
        String targetPosition = "e3";
        try {
            game.move(sourcePosition, targetPosition);
            // 예외가 발생해야 함. 발생하지 않으면 실패
            fail("움직임 예외 처리 안됨 - 한 칸씩만 이동 가능");
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).isEqualTo("Cannot move to this location.");
        }
    }

    @Test
    @DisplayName("Queen 이 잘 움직이는지 확인")
    public void moveQueen() {
        board.initialize();

        String sourcePosition = "d8";
        String targetPosition = "d4";
        game.move(sourcePosition, targetPosition);
        assertThat(game.findPiece(sourcePosition)).isEqualTo(Piece.createBlank());
        assertThat(game.findPiece(targetPosition)).isEqualTo(Piece.createBlack(Type.QUEEN));
    }

    @Test
    @DisplayName("Queen 움직임 예외처리 - 직선으로만 이동 가능")
    public void invalidQueenMove() {
        board.initialize();
        String sourcePosition = "e8";
        String targetPosition = "a3";
        try {
            game.move(sourcePosition, targetPosition);
            // 예외가 발생해야 함. 발생하지 않으면 실패
            fail("움직임 예외 처리 안됨 - 직선으로만 이동 가능");
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).isEqualTo("Cannot move to this location.");
        }
    }

    @Test
    @DisplayName("움직임 예외 처리 - 같은 색으로는 이동 물가")
    public void invalidSameColor() {
        board.initialize();
        String sourcePosition = "e8";
        String targetPosition = "e7";
        try {
            game.move(sourcePosition, targetPosition);
            // 예외가 발생해야 함. 발생하지 않으면 실패
            fail("같은 색의 말이 있는 곳으로 이동했음에도 예외 발생 안함.");
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).isEqualTo("Cannot move to pieces of the same color.");
        }
    }

    @Test
    @DisplayName("주어진 위치의 기물이 잘 조회되는지 확인")
    //Unit의 assertThat(A).isEqualTo(B)는 내부적으로 equals()를 자동 호출
    //equals()는 Piece.java에서 구현
    public void findPiece() throws Exception {
        board.initialize();
        assertThat(game.findPiece("a8")).isEqualTo(Piece.createBlack(Type.ROOK));
        assertThat(game.findPiece("h8")).isEqualTo(Piece.createBlack(Type.ROOK));
        assertThat(game.findPiece("a1")).isEqualTo(Piece.createWhite(Type.ROOK));
        assertThat(game.findPiece("h1")).isEqualTo(Piece.createWhite(Type.ROOK));

    }
}
