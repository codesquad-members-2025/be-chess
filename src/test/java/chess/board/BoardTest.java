package chess.board;

import chess.piece.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static chess.piece.Piece.Color.BLACK;
import static chess.piece.Piece.Color.WHITE;
import static chess.piece.Piece.Type.*;
import static chess.util.StringUtils.appendNewLine;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
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
    public void findPiece() throws Exception {
        assertEquals(Piece.createBlack(Piece.Type.ROOK), board.findPiece("a8"));
        assertEquals(Piece.createBlack(Piece.Type.ROOK), board.findPiece("h8"));
        assertEquals(Piece.createWhite(Piece.Type.ROOK), board.findPiece("a1"));
        assertEquals(Piece.createWhite(Piece.Type.ROOK), board.findPiece("h1"));
    }

    @Test
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlack(Piece.Type.ROOK);
        board.move(position, piece);

        assertEquals(piece, board.findPiece(position));
        System.out.println(board.showBoard());
    }

    @Test
    public void caculcatePoint() throws Exception {
        board.initializeEmpty();

        addPiece("b6", Piece.createBlack(PAWN));
        addPiece("e6", Piece.createBlack(QUEEN));
        addPiece("b8", Piece.createBlack(KING));
        addPiece("c8", Piece.createBlack(ROOK));

        addPiece("f2", Piece.createWhite(PAWN));
        addPiece("g2", Piece.createWhite(PAWN));
        addPiece("e1", Piece.createWhite(ROOK));
        addPiece("f1", Piece.createWhite(KING));

        assertEquals(15.0, board.calculatePoint(BLACK));
        assertEquals(7.0, board.calculatePoint(WHITE));

        System.out.println(board.showBoard());
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }
}
