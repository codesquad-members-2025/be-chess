package chess;

import org.junit.jupiter.api.*;
import pieces.Piece;
import pieces.Piece.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private Board board;

    @BeforeEach
    void setup(){
        board = new Board();
    }

    @Test
    public void findPiece() throws Exception {
        board.initialize();

        assertEquals(Piece.createBlackRook(), board.findPiece("a8"));
        assertEquals(Piece.createBlackRook(), board.findPiece("h8"));
        assertEquals(Piece.createWhiteRook(), board.findPiece("a1"));
        assertEquals(Piece.createWhiteRook(), board.findPiece("h1"));
    }

    @Test
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.move(position, piece);

        assertEquals(piece, board.findPiece(position));
        System.out.println(board.showBoard());
    }

    @Test
    public void testSortBlackAscending() throws Exception {
        board.initialize();
        ArrayList<Piece> sortBlack = board.sortByScore(Color.BLACK, false);
        assertEquals(Type.QUEEN, sortBlack.get(0).getType());
        assertEquals(Type.ROOK, sortBlack.get(1).getType());
        assertEquals(Type.ROOK, sortBlack.get(2).getType());
        assertEquals(Type.BISHOP, sortBlack.get(3).getType());
        assertEquals(Type.BISHOP, sortBlack.get(4).getType());
        assertEquals(Type.KNIGHT, sortBlack.get(5).getType());
        assertEquals(Type.KNIGHT, sortBlack.get(6).getType());
        assertEquals(Type.PAWN, sortBlack.get(7).getType());
    }

    @Test
    public void testSortWhiteAscending() {
        board.initialize();
        ArrayList<Piece> sortWhite = board.sortByScore(Color.WHITE, false);
        assertEquals(Type.QUEEN, sortWhite.get(0).getType());
        assertEquals(Type.ROOK, sortWhite.get(1).getType());
        assertEquals(Type.ROOK, sortWhite.get(2).getType());
        assertEquals(Type.BISHOP, sortWhite.get(3).getType());
        assertEquals(Type.BISHOP, sortWhite.get(4).getType());
        assertEquals(Type.KNIGHT, sortWhite.get(5).getType());
        assertEquals(Type.KNIGHT, sortWhite.get(6).getType());
        assertEquals(Type.PAWN, sortWhite.get(7).getType());
    }

    @Test
    public void caculcatePoint() throws Exception {
        board.initializeEmpty();

        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());

        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());

        assertEquals(15.0, board.caculcatePoint(Color.BLACK), 0.01);
        assertEquals(7.0, board.caculcatePoint(Color.WHITE), 0.01);


        System.out.println(board.showBoard());
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }
}
