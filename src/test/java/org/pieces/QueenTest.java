package org.pieces;

import org.chess.Board;
import org.chess.Coordinate;
import org.chess.Game;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class QueenTest {
    Board board;
    Game game;
    Piece queen;

    @BeforeEach
    void setUp() {
        board = new Board();
        game = new Game(board);
        board.initializeEmpty();
        queen = Piece.createWhiteQueen();
        board.putPiece(new Coordinate("e4"), queen);
    }

    @ParameterizedTest(name = "Queen can move from e4 to {0}")
    @ValueSource(strings = {"e5", "f4", "f5", "d3", "d4", "d5", "f3", "e3", "e8", "e1", "e2","e3","e6","e7","e8","a4","b4","c4","d4","f4","g4","h4"})
    @DisplayName("퀸이 모든 방향으로 이동할 수 있는지 확인")
    void test_queen_valid_move(String targetCoordinateStr) throws Exception {
        Coordinate target = new Coordinate(targetCoordinateStr);
        assertThat(queen.verifyMovePosition(board, new Coordinate("e4"), target)).isTrue();
    }

    @ParameterizedTest(name = "Queen can move from e4 to {0}")
    @ValueSource(strings = {"c1","d1","f1","h5","b3"})
    @DisplayName("퀸이 이동할 수 없는 곳은 이동할 수 없는지 확인")
    void test_queen_invalid_move(String targetCoordinateStr) throws Exception {
        Coordinate target = new Coordinate(targetCoordinateStr);
        assertThat(queen.verifyMovePosition(board, new Coordinate("e4"), target)).isFalse();
    }

    @Test
    @DisplayName("Queen이 같은 팀으로 이동할 수 없는지 확인")
    void test_queen_same_team_move() throws Exception {
        board.putPiece(new Coordinate("e5"), Piece.createWhitePawn());
        // e5에 같은 색이 있다면 e6도 못가야 한다.
        Coordinate targetP1 = new Coordinate("e5");
        Coordinate targetP2 = new Coordinate("e6");
        assertThat(queen.verifyMovePosition(board, new Coordinate("e4"), targetP1)).isFalse();
        assertThat(queen.verifyMovePosition(board, new Coordinate("e4"), targetP2)).isFalse();
    }

    @Test
    @DisplayName("Queen이 다른 팀으로 이동할 수 있는지 확인")
    void test_queen_opposite_team_move() throws Exception {
        board.putPiece(new Coordinate("e5"), Piece.createBlackPawn());
        // e5에 다른 색이 있다면 e5로 갈 수 있어야 한다.
        // e6은 못가야 한다.
        Coordinate targetP1 = new Coordinate("e5");
        Coordinate targetP2 = new Coordinate("e6");
        assertThat(queen.verifyMovePosition(board, new Coordinate("e4"), targetP1)).isTrue();
        assertThat(queen.verifyMovePosition(board, new Coordinate("e4"), targetP2)).isFalse();
    }
}
