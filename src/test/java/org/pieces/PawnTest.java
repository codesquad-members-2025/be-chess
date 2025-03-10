package org.pieces;

import org.chess.Board;
import org.chess.Coordinate;
import org.chess.Game;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {
    Board board;
    Game game;
    Piece whitePawn;
    Piece blackPawn;
    Coordinate blackSource;
    Coordinate whiteSource;

    @BeforeEach
    void setUp() {
        board = new Board();
        game = new Game(board);
        board.initializeEmpty();
        whiteSource = new Coordinate("a2");
        blackSource = new Coordinate("a7");
        whitePawn = Piece.createWhitePawn();
        blackPawn = Piece.createBlackPawn();
        board.putPiece(whiteSource, whitePawn);
        board.putPiece(blackSource, blackPawn);
    }

    @Test
    @DisplayName("폰이 앞으로 한 칸 이동할 수 있는지 확인")
    void test_pawn_move_forward() throws Exception {
        assertThat(whitePawn.verifyMovePosition(board, whiteSource, new Coordinate("a3"))).isTrue();
        assertThat(blackPawn.verifyMovePosition(board, blackSource, new Coordinate("a6"))).isTrue();
    }

    @Test
    @DisplayName("폰이 이동 할 수 없는 곳은 이동할 수 없는지 확인")
    void test_pawn_cant_move() throws Exception {
        assertThat(whitePawn.verifyMovePosition(board, whiteSource, new Coordinate("b3"))).isFalse();
        assertThat(blackPawn.verifyMovePosition(board, blackSource, new Coordinate("b6"))).isFalse();
        assertThat(whitePawn.verifyMovePosition(board, whiteSource, new Coordinate("a1"))).isFalse();
        assertThat(blackPawn.verifyMovePosition(board, blackSource, new Coordinate("a8"))).isFalse();
    }

    @Test
    @DisplayName("폰이 아군이 있는 곳으로 이동할 수 없는지 확인")
    void test_pawn_cant_move_to_ally() throws Exception {
        Coordinate whitePiece = new Coordinate("a3");
        Coordinate blackPiece = new Coordinate("a6");
        board.putPiece(whitePiece, Piece.createWhitePawn());
        board.putPiece(blackPiece, Piece.createBlackPawn());

        assertThat(whitePawn.verifyMovePosition(board, whiteSource, whitePiece)).isFalse();
        assertThat(blackPawn.verifyMovePosition(board, blackSource, blackPiece)).isFalse();
    }

    @Test
    @DisplayName("폰이 적군이 있는 곳으로 한칸 전진 할 수 없는지 확인")
    void test_pawn_cant_move_to_enemy_forward() throws Exception {
        Coordinate blackPiece = new Coordinate("a3");
        Coordinate whitePiece = new Coordinate("a6");
        board.putPiece(blackPiece, Piece.createBlackPawn());
        board.putPiece(whitePiece, Piece.createWhitePawn());

        assertThat(whitePawn.verifyMovePosition(board, whiteSource, blackPiece)).isFalse();
        assertThat(blackPawn.verifyMovePosition(board, blackSource, whitePiece)).isFalse();
    }

    @Test
    @DisplayName("폰이 적군이 있는 곳으로 대각선으로 이동할 수 있는지 확인")
    void test_pawn_move_to_enemy_diagonal() throws Exception {
        Coordinate blackPiece = new Coordinate("b3");
        Coordinate whitePiece = new Coordinate("b6");
        board.putPiece(blackPiece, Piece.createBlackPawn());
        board.putPiece(whitePiece, Piece.createWhitePawn());

        assertThat(whitePawn.verifyMovePosition(board, whiteSource, blackPiece)).isTrue();
        assertThat(blackPawn.verifyMovePosition(board, blackSource, whitePiece)).isTrue();
    }
}
