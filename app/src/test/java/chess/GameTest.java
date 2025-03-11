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
    @DisplayName("기물이 현재 위치에서 다른 위치로 잘 이동하는지 확인")
    public void move() throws Exception {
        board.initialize();

        String sourcePosition = "b2";
        String targetPosition = "b3";
        game.move(sourcePosition, targetPosition);
        assertThat(game.findPiece(sourcePosition)).isEqualTo(Piece.createBlank());
        assertThat(game.findPiece(targetPosition)).isEqualTo(Piece.createWhite(Type.PAWN));
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
