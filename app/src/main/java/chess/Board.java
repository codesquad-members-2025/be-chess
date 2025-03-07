package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.StringUtils.appendNewLine;

public class Board {
    private List<Piece> pieces;
    private char[][] board;
    private int piecesIndex;

    public Board() {
        this.pieces = new ArrayList<>();
        this.board = new char[8][8];
        this.piecesIndex = 0;
        for (char[] chars : board) {
            Arrays.fill(chars, '.' );
        }
    }

    public void add(Piece piece) {
        pieces.add(piece);
    }

    public int pieceCount() {
        return pieces.size();
    }

    public Piece findPawn(int pawnNumber) {
        return pieces.get(pawnNumber);
    }

    public void initialize() {
       addPawns();
       addWhitePieces();
       addBlackPieces();
       placePawn();
       placeWhitePieces();
       placeBlackPieces();
    }

    public void addPawns() {
        for (int i = 0; i < board.length; ++i) {
            pieces.add(Piece.createWhitePawn());
            pieces.add(Piece.createBlackPawn());
        }
    }

    public void addWhitePieces() {
        pieces.add(Piece.createWhiteRook());
        pieces.add(Piece.createWhiteKnight());
        pieces.add(Piece.createWhiteBishop());
        pieces.add(Piece.createWhiteQueen());
        pieces.add(Piece.createWhiteKing());
        pieces.add(Piece.createWhiteBishop());
        pieces.add(Piece.createWhiteKnight());
        pieces.add(Piece.createWhiteRook());
    }

    public void addBlackPieces() {
        pieces.add(Piece.createBlackRook());
        pieces.add(Piece.createBlackKnight());
        pieces.add(Piece.createBlackBishop());
        pieces.add(Piece.createBlackQueen());
        pieces.add(Piece.createBlackKing());
        pieces.add(Piece.createBlackBishop());
        pieces.add(Piece.createBlackKnight());
        pieces.add(Piece.createBlackRook());
    }

    public void placePawn() {
        for (int i = 0; i < board.length; ++i) {
            board[1][i] = pieces.get(piecesIndex).getRepresentation();
            board[6][i] = pieces.get(piecesIndex + 1).getRepresentation();
            piecesIndex += 2;
        }
    }

    public void placeWhitePieces() {
        for (int i = 0; i < board.length; ++i) {
            board[0][i] = pieces.get(piecesIndex).getRepresentation();
            ++piecesIndex;
        }
    }

    public void placeBlackPieces() {
        for (int i = 0; i < board.length; ++i) {
            board[7][i] = pieces.get(piecesIndex).getRepresentation();
            ++piecesIndex;
        }
    }

    public String getWhitePawnResult() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < board.length; ++i) {
            sb.append(board[1][i]);
        }

        return sb.toString();
    }

    public String getBlackPawnResult() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < board.length; ++i) {
            sb.append(board[6][i]);
        }

        return sb.toString();
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; ++i) {
            String line = "";
            for (int j = 0; j < board.length; ++j) {
                line += (board[i][j]);
            }
            line = appendNewLine(line);
            sb.append(line);
        }
        System.out.print(sb);
    }

    public String showBoard() {
        StringBuilder chessBoard = new StringBuilder();
        for (char[] chars : board) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < board.length; ++j) {
                line.append(chars[j]);
            }
            line = new StringBuilder(appendNewLine(line.toString()));
            chessBoard.append(line);
        }
        return chessBoard.toString();
    }

}
