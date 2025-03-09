package org.pieces;

import org.chess.Board;
import org.chess.Coordinate;
import org.chess.Game;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class KnightTest {
    Board board;
    Game game;
    Piece knight;

    @BeforeEach
    void setUp() {
        board = new Board();
        game = new Game(board);
        board.initializeEmpty();
        knight = Piece.createWhiteKnight();
        board.putPiece(new Coordinate("e4"), knight);
    }

    @ParameterizedTest(name = "Knight can move from e4 to {0}")
    @ValueSource(strings = {"f6", "g5", "g3", "f2", "d2", "c3", "c5", "d6"})
    @DisplayName("나이트가 모든 방향으로 이동할 수 있는지 확인")
    void test_knight_valid_move(String targetCoordinateStr) throws Exception {
        Coordinate target = new Coordinate(targetCoordinateStr);
        assertThat(knight.verifyMovePosition(board, new Coordinate("e4"), target)).isTrue();
    }

    @ParameterizedTest(name = "Knight can't move from e4 to {0}")
    @ValueSource(strings = {"e4", "e5", "e3", "e2", "e1", "e6", "e7", "e8", "f4", "g4", "d4", "c4", "b4", "a4"})
    @DisplayName("나이트가 이동할 수 없는 곳으로 이동할 수 없는지 확인")
    void test_queen_valid_move(String targetCoordinateStr) throws Exception {
        Coordinate target = new Coordinate(targetCoordinateStr);
        assertThat(knight.verifyMovePosition(board, new Coordinate("e4"), target)).isFalse();
    }

    @Test
    @DisplayName("knight 같은 팀으로 이동할 수 없는지 확인")
    void test_knight_same_team_move() throws Exception {
        board.putPiece(new Coordinate("f6"), Piece.createWhitePawn());

        Coordinate targetP = new Coordinate("f6");
        assertThat(knight.verifyMovePosition(board, new Coordinate("e4"), targetP)).isFalse();
    }

    @Test
    @DisplayName("knight 다른 팀으로 이동할 수 있는지 확인")
    void test_knight_other_team_move() throws Exception {
        board.putPiece(new Coordinate("f6"), Piece.createBlackPawn());

        Coordinate targetP = new Coordinate("f6");
        assertThat(knight.verifyMovePosition(board, new Coordinate("e4"), targetP)).isTrue();
    }
}
