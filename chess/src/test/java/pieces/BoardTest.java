package pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chess.Board;
import chess.Piece;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static utils.StringUtils.appendNewLine;

import static org.junit.Assert.*;

public class BoardTest {
    private Board board;

    @Before
    public void setup() {
        board = new Board();
        board.initializePawns();
        board.initializeBoard();
    }

    @Test
    public void create() throws Exception {
        assertEquals(32, board.pieceCount());
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                board.showBoard());
    }

    @Test
    @DisplayName("피스의 종류를 센다")
    public void countPieces(){
        assertEquals(1, board.getPiecesCnt(Piece.Color.WHITE, Piece.Type.QUEEN));
        assertEquals(2, board.getPiecesCnt(Piece.Color.BLACK, Piece.Type.ROOK));
        assertEquals(1, board.getPiecesCnt(Piece.Color.WHITE, Piece.Type.KING));
        assertEquals(8, board.getPiecesCnt(Piece.Color.WHITE, Piece.Type.PAWN));
        assertEquals(8, board.getPiecesCnt(Piece.Color.BLACK, Piece.Type.PAWN));

    }

    @Test
    @DisplayName("좌표를 통해 주어진 위치의 기물을 조회한다")
    public void findPiece() throws Exception {
        assertEquals(Piece.createBlackRook(), board.findPiece("a8"));
        assertEquals(Piece.createBlackRook(), board.findPiece("h8"));
        assertEquals(Piece.createWhiteRook(), board.findPiece("a1"));
        assertEquals(Piece.createWhiteRook(), board.findPiece("h1"));
    }
}
