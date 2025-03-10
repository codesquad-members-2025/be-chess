package org.pieces;

import org.chess.Board;
import org.chess.Coordinate;
import org.chess.Game;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class KingTest {
    Board board;
    Game game;
    Piece king;
    Coordinate source;

    @BeforeEach
    void setUp() {
        board = new Board();
        game = new Game(board);
        board.initializeEmpty();
        king = Piece.createWhiteKing();
        source = new Coordinate("e4");
        board.putPiece(source, king);
    }

    @ParameterizedTest(name = "King move from e4 to {0}")
    @ValueSource(strings = {"e5", "f4", "f5", "d3", "d4", "d5", "f3", "e3"})
    @DisplayName("왕이 모든 방향으로 이동할 수 있는지 확인")
    public void move_direction(String targetCoordinate) throws Exception {
        Coordinate target = new Coordinate(targetCoordinate);
        assertThat(king.verifyMovePosition(board, source, target)).isTrue();
    }

    @ParameterizedTest(name = "King can't move from e4 to {0}")
    @ValueSource(strings = {"e1", "e2","e6", "e7", "e8", "f1", "f2", "d6", "d7", "d8"})
    @DisplayName("왕이 이동 할 수 없는 곳 이동할 수 없는지 확인")
    public void move_to_invalid(String targetCoordinate) throws Exception {
        Coordinate target = new Coordinate(targetCoordinate);
        assertThat(king.verifyMovePosition(board,source,target)).isFalse();
    }
    
    @Test
    @DisplayName("왕이 같은 색으로 이동 할 수 없는지 확인")
    public void move_to_same_team() throws Exception {
        board.putPiece(new Coordinate("e5"), Piece.createWhitePawn());

        Coordinate targetP = new Coordinate("e5");

        assertThat(king.verifyMovePosition(board,source, targetP)).isFalse();
    }

    @Test
    @DisplayName("왕이 다른 색으로 이동 할 수 있는지 확인")
    public void move_to_enemy() throws Exception {
        board.putPiece(new Coordinate("e5"), Piece.createBlackPawn());

        Coordinate targetP = new Coordinate("e5");

        assertThat(king.verifyMovePosition(board, source, targetP)).isTrue();
    }
}

