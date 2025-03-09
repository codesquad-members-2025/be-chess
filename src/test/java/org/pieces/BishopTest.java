package org.pieces;

import org.chess.Board;
import org.chess.Coordinate;
import org.chess.Game;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class BishopTest {
    Board board;
    Game game;
    Piece bishop;

    @BeforeEach
    void setUp() {
        board = new Board();
        game = new Game(board);
        board.initializeEmpty();
        bishop = Piece.createWhiteBishop();
        board.putPiece(new Coordinate("e4"), bishop);
    }

    @ParameterizedTest(name = "Bishop can move from e4 to {0}")
    @ValueSource(strings = {"f5", "d3", "d5", "f3"})
    @DisplayName("비숍이 대각선 방향으로 이동할 수 있는지 확인")
    void test_bishop_valid_move(String targetCoordinateStr) throws Exception {
        Coordinate target = new Coordinate(targetCoordinateStr);
        assertThat(bishop.verifyMovePosition(board, new Coordinate("e4"), target)).isTrue();
    }

    @ParameterizedTest(name = "Bishop can't move from e4 to {0}")
    @ValueSource(strings = {"c1", "d1", "f1", "h5", "b3"})
    @DisplayName("비숍이 이동할 수 없는 곳은 이동할 수 없는지 확인")
    void test_bishop_invalid_move(String targetCoordinateStr) throws Exception {
        Coordinate target = new Coordinate(targetCoordinateStr);
        assertThat(bishop.verifyMovePosition(board, new Coordinate("e4"), target)).isFalse();
    }

    @Test
    @DisplayName("비숍이 같은 팀으로 이동할 수 없는지 확인")
    void test_bishop_same_team_move() throws Exception {
        board.putPiece(new Coordinate("f5"), Piece.createWhitePawn());
        // f5에 같은 색이 있다면 f5로 못가야 한다.
        Coordinate targetP1 = new Coordinate("f5");
        Coordinate targetP2 = new Coordinate("f6");
        assertThat(bishop.verifyMovePosition(board, new Coordinate("e4"), targetP1)).isFalse();
        assertThat(bishop.verifyMovePosition(board, new Coordinate("e4"), targetP2)).isFalse();
    }

    @Test
    @DisplayName("비숍이 다른 팀으로 이동할 수 있는지 확인")
    void test_bishop_opposite_team_move() throws Exception {
        board.putPiece(new Coordinate("f5"), Piece.createBlackPawn());
        // f5에 다른 색이 있다면 f5로 갈 수 있어야 한다.
        // f6은 못가야 한다.
        Coordinate targetP1 = new Coordinate("f5");
        Coordinate targetP2 = new Coordinate("f6");
        assertThat(bishop.verifyMovePosition(board, new Coordinate("e4"), targetP1)).isTrue();
        assertThat(bishop.verifyMovePosition(board, new Coordinate("e4"), targetP2)).isFalse();
    }
}
