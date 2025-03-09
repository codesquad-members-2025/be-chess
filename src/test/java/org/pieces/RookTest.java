package org.pieces;

import org.chess.Board;
import org.chess.Coordinate;
import org.chess.Game;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RookTest {
    Board board;
    Game game;
    Piece rook;
    Coordinate source;

    @BeforeEach
    void setUp() {
        board = new Board();
        game = new Game(board);
        board.initializeEmpty();
        rook = Piece.createWhiteRook();
        source = new Coordinate("e4");
        board.putPiece(source, rook);
    }

    @ParameterizedTest(name = "Rook can move from e4 to {0}")
    @ValueSource(strings = {"e5", "e6", "e7", "e8", "e3", "e2", "e1", "f4", "g4", "h4", "d4", "c4", "b4", "a4"})
    @DisplayName("룩이 십자가 방향으로 이동할 수 있는지 확인")
    void test_rook_valid_move(String targetCoordinateStr) throws Exception {
        Coordinate target = new Coordinate(targetCoordinateStr);
        assertThat(rook.verifyMovePosition(board, source, target)).isTrue();
    }

    @ParameterizedTest(name = "Rook can't move from e4 to {0}")
    @ValueSource(strings = {"f5", "d3", "d5", "f3"})
    @DisplayName("룩이 이동할 수 없는 곳은 이동할 수 없는지 확인")
    void test_rook_invalid_move(String targetCoordinateStr) throws Exception {
        Coordinate target = new Coordinate(targetCoordinateStr);
        assertThat(rook.verifyMovePosition(board, source, target)).isFalse();
    }

    @Test
    @DisplayName("룩이 같은 팀으로 이동할 수 없는지 확인")
    void test_rook_same_team_move() throws Exception {
        board.putPiece(new Coordinate("e5"), Piece.createWhitePawn());
        // f5에 같은 색이 있다면 f5로 못가야 한다.
        Coordinate targetP1 = new Coordinate("e5");
        Coordinate targetP2 = new Coordinate("e6");
        assertThat(rook.verifyMovePosition(board, source, targetP1)).isFalse();
        assertThat(rook.verifyMovePosition(board, source, targetP2)).isFalse();
    }

    @Test
    @DisplayName("룩이 다른 팀으로 이동할 수 있는지 확인")
    void test_rook_opposite_team_move() throws Exception {
        board.putPiece(new Coordinate("e5"), Piece.createBlackPawn());
        // f5에 다른 색이 있다면 f5로 갈 수 있어야 한다.
        // f6은 못가야 한다.
        Coordinate targetP1 = new Coordinate("e5");
        Coordinate targetP2 = new Coordinate("e6");
        assertThat(rook.verifyMovePosition(board, source, targetP1)).isTrue();
        assertThat(rook.verifyMovePosition(board, source, targetP2)).isFalse();
    }
}
