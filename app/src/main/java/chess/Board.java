package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.StringUtils.appendNewLine;

public class Board {
    private List<Piece> pieces;
    private char[][] board;

    public Board() {
        this.pieces = new ArrayList<>();
        this.board = new char[8][8];
        for (char[] chars : board) {
            Arrays.fill(chars, '.' );
        }
    }

    public void add(Piece piece) {
        pieces.add(piece);
    }

    public int size() {
        return pieces.size();
    }

    public Piece findPawn(int pawnNumber) {
        return pieces.get(pawnNumber);
    }

    public void initialize() {
       addPawns();
       placePawn();
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

    public void placePawn() {
        int pawnsIndex = 0; // Pawn 리스트 전체를 순회하기 위한 인덱스 값

        for (int i = 0; i < board.length; ++i) {
            board[1][i] = pieces.get(pawnsIndex).getRepresentation();
            board[6][i] = pieces.get(pawnsIndex + 1).getRepresentation();
            pawnsIndex += 2;
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
}
