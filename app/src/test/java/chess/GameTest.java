package chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
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
        game.move(sourcePosition, targetPosition);
        assertThat(game.findPiece(sourcePosition)).isEqualTo(Piece.createBlack(Type.KING));
        assertThat(game.findPiece(targetPosition)).isEqualTo(Piece.createBlank());
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
        game.move(sourcePosition, targetPosition);
        assertThat(game.findPiece(sourcePosition)).isEqualTo(Piece.createBlack(Type.QUEEN));
        assertThat(game.findPiece(targetPosition)).isEqualTo(Piece.createBlank());
    }

    @Test
    @DisplayName("움직임 예외 처리 - 같은 색으로는 이동 물가")
    public void invalidSameColor() {
        board.initialize();
        String sourcePosition = "e8";
        String targetPosition = "e7";
        game.move(sourcePosition, targetPosition);
        assertThat(game.findPiece(sourcePosition)).isEqualTo(Piece.createBlack(Type.QUEEN));
        assertThat(game.findPiece(targetPosition)).isEqualTo(Piece.createBlack(Type.PAWN));
    }



//    @Test
//    @DisplayName("기물이 현재 위치에서 다른 위치로 잘 이동하는지 확인")
//    public void move() throws Exception {
//        board.initialize();
//
//        String sourcePosition = "b2";
//        String targetPosition = "b3";
//        game.move(sourcePosition, targetPosition);
//        assertThat(game.findPiece(sourcePosition)).isEqualTo(Piece.createBlank());
//        assertThat(game.findPiece(targetPosition)).isEqualTo(Piece.createWhite(Type.PAWN));
//    }

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
