package org.pieces;

import org.chess.Board;
import org.chess.Coordinate;
import org.chess.Game;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class KingTest {
    Board board;
    Game game;
    Piece king;

    @BeforeEach
    void setUp() {
        board = new Board();
        game = new Game(board);
        board.initializeEmpty();
        king = Piece.createWhiteKing();
    }

    @Test
    @DisplayName("왕이 모든 방향으로 이동할 수 있는지 확인")
    public void move_direction() throws Exception {
        board.putPiece(new Coordinate("e4"), king);
        Coordinate position1 = new Coordinate("e5");
        Coordinate position2 = new Coordinate("f4");
        Coordinate position3 = new Coordinate("f5");
        Coordinate position4 = new Coordinate("d3");
        Coordinate position5 = new Coordinate("d4");
        Coordinate position6 = new Coordinate("d5");
        Coordinate position7 = new Coordinate("f3");
        Coordinate position8 = new Coordinate("e3");

        Coordinate position9 = new Coordinate("e8");

        assertThat(king.verifyMovePosition(board, new Coordinate("e4"), position1)).isTrue();
        assertThat(king.verifyMovePosition(board, new Coordinate("e4"), position2)).isTrue();
        assertThat(king.verifyMovePosition(board, new Coordinate("e4"), position3)).isTrue();
        assertThat(king.verifyMovePosition(board, new Coordinate("e4"), position4)).isTrue();
        assertThat(king.verifyMovePosition(board, new Coordinate("e4"), position5)).isTrue();
        assertThat(king.verifyMovePosition(board, new Coordinate("e4"), position6)).isTrue();
        assertThat(king.verifyMovePosition(board, new Coordinate("e4"), position7)).isTrue();
        assertThat(king.verifyMovePosition(board, new Coordinate("e4"), position8)).isTrue();

        assertThat(king.verifyMovePosition(board, new Coordinate("e4"), position9)).isFalse();
    }

    @Test
    @DisplayName("왕이 같은 색으로 이동 할 수 없는지 확인")
    public void move_to_same_team() throws Exception {
        board.putPiece(new Coordinate("e4"), king);
        board.putPiece(new Coordinate("e5"), Piece.createWhitePawn());

        Coordinate targetP = new Coordinate("e5");

        assertThat(king.verifyMovePosition(board, new Coordinate("e4"), targetP)).isFalse();
    }

    @Test
    @DisplayName("왕이 다른 색으로 이동 할 수 있는지 확인")
    public void move_to_enemy() throws Exception {
        board.putPiece(new Coordinate("e4"), king);
        board.putPiece(new Coordinate("e5"), Piece.createBlackPawn());

        Coordinate targetP = new Coordinate("e5");

        assertThat(king.verifyMovePosition(board, new Coordinate("e4"), targetP)).isTrue();
    }
}

