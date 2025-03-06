package chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<Pawn> pawns;
    private char[][] board;

    public Board() {
        this.pawns = new ArrayList<>();
        this.board = new char[8][8];
        for (char[] chars : board) {
            Arrays.fill(chars, '.' );
        }
    }

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int pawnNumber) {
        return pawns.get(pawnNumber);
    }

    public void initialize() {
        for (int i = 0; i < board.length; ++i) {
            pawns.add(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
            pawns.add(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
        }
        placePawn();
    }

    public void placePawn() {
        int pawnsIndex = 0; // Pawn 리스트 전체를 순회하기 위한 인덱스 값

        for (int i = 0; i < board.length; ++i) {
            board[1][i] = pawns.get(pawnsIndex).getRepresentation();
            board[6][i] = pawns.get(pawnsIndex + 1).getRepresentation();
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
            for (int j = 0; j < board.length; ++j) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
