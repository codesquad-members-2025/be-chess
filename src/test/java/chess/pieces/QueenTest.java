package chess.pieces;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import chess.Board;
import chess.ChessGame;
import chess.ChessView;
import chess.Rank;
import chess.pieces.Piece.Type;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QueenTest {
    private Board board;
    private ChessGame chessGame;
    private ChessView chessView;

    @BeforeEach
    void init() {
        List<Rank> chessBoard = new ArrayList<>();
        board = new Board(chessBoard);
        chessGame = new ChessGame(chessBoard);
        chessView = new ChessView(chessBoard);
    }
    @Test
    @DisplayName("퀸은 직선과 대각선 방향으로 움직인다.")
    void moveQueen() {
        initEmptyBoardTest();

        String sourcePosition = "e6";
        String targetPosition = "e1";

        chessGame.move(sourcePosition, targetPosition);

        assertThat(chessGame.findPiece(sourcePosition)).isEqualTo(Piece.createBlank());
        assertThat(chessGame.findPiece(targetPosition)).isEqualTo(Piece.createBlack(Type.QUEEN));

        System.out.println(chessView.showBoard());

        sourcePosition = "e1";
        targetPosition = "a5";

        chessGame.move(sourcePosition, targetPosition);

        assertThat(chessGame.findPiece(sourcePosition)).isEqualTo(Piece.createBlank());
        assertThat(chessGame.findPiece(targetPosition)).isEqualTo(Piece.createBlack(Type.QUEEN));

        System.out.println(chessView.showBoard());
    }

    @Test
    @DisplayName("퀸이 잘못된 위치로 이동할 경우 에러를 발생시킨다.")
    void moveQueenFail() {
        initEmptyBoardTest();

        String sourcePosition = "e6";
        String targetPosition = "a1";

        assertThrows(IllegalArgumentException.class, () ->chessGame.move(sourcePosition, targetPosition));
        assertThat(chessGame.findPiece(sourcePosition)).isEqualTo(Piece.createBlack(Type.QUEEN));

        System.out.println(chessView.showBoard());
    }
    private void initEmptyBoardTest() {
        board.initializeEmpty();

        addPiece("b6", Piece.createBlack(Type.PAWN));
        addPiece("e6", Piece.createBlack(Type.QUEEN));
        addPiece("b8", Piece.createBlack(Type.KING));
        addPiece("c8", Piece.createBlack(Type.ROOK));

        addPiece("g2", Piece.createWhite(Type.PAWN));
        addPiece("g3", Piece.createWhite(Type.PAWN));
        addPiece("e1", Piece.createWhite(Type.ROOK));
        addPiece("f1", Piece.createWhite(Type.KING));
    }
    private void addPiece(String position, Piece piece) {
        chessGame.addPiece(position, piece);
    }
}
