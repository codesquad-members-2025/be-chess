package chess;

import static chess.utils.StringUtils.*;
import static org.assertj.core.api.Assertions.assertThat;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {
    private Board board;

    @BeforeEach
    void init() {
        board = new Board();
    }
    @Test
    @DisplayName("보드가 초기화 되면 모든 말들이 생성되어야 한다.")
    void create() throws Exception {
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(32);
        String blankRank = appendNewLine("........");
        assertThat(appendNewLine("♜♞♝♛♚♝♞♜") +
                appendNewLine("♟♟♟♟♟♟♟♟") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("♙♙♙♙♙♙♙♙") +
                appendNewLine("♖♘♗♕♔♗♘♖")).isEqualTo(board.showBoard());
    }

    @Test
    @DisplayName("보드초기화시 같은 색의 폰들이 한줄에 있어야한다.")
    void initialize() throws Exception {
        board.initialize();
        assertThat(board.getPawnResult(Color.WHITE)).isEqualTo("♙♙♙♙♙♙♙♙");
        assertThat(board.getPawnResult(Color.BLACK)).isEqualTo("♟♟♟♟♟♟♟♟");
    }

    @Test
    @DisplayName("색과 종류에 따른 보드 위에 존재하는 기물 갯수를 리턴한다.")
    void pieceCountOnBoard() {
        initializeBoardByString();
        int pawnCount = board.pieceCountOnBoard(Color.BLACK, Type.PAWN);
        int knightCount = board.pieceCountOnBoard(Color.WHITE, Type.KNIGHT);

        assertThat(pawnCount).isEqualTo(3);
        assertThat(knightCount).isEqualTo(1);
    }

    @Test
    @DisplayName("초기화 후 특정위치에 기물이 존재하는지 확인합니다.")
    public void findPiece() {
        board.initialize();

        assertThat(board.findPiece("a8").getName()).isEqualTo(Type.ROOK);
        assertThat(board.findPiece("h8").getName()).isEqualTo(Type.ROOK);
        assertThat(board.findPiece("a1").getName()).isEqualTo(Type.ROOK);
        assertThat(board.findPiece("h1").getName()).isEqualTo(Type.ROOK);
    }

    private void initializeBoardByString() {
        String boardText = ".♚♜.....\n"
                + "♟.♟♝....\n"
                + ".♟..♛...\n"
                + "........\n"
                + ".....♘♕.\n"
                + ".....♙..\n"
                + "......♙.\n"
                + "....♖♔..";

        String[] split = boardText.split("\n");
        for (String s : split) {
            List<Piece> rank = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                Piece piece = Piece.createPieceByRepresentation(s.charAt(i));
                rank.add(piece);
            }
            board.addPiece(new Rank(rank));
        }
    }
}