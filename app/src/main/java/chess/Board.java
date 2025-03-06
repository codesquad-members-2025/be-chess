package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static chess.pieces.Pawn.*;

public class Board {
    private static final int WHITE_PAWN_RANK = 6;
    private static final int BLACK_PAWN_RANK = 1;
    private static final int MIN_PAWN_INDEX = 0;
    private static final int MAX_PAWN_INDEX = 15;
    private static final int MAX_PAWN_SIZE = 16;
    private static final int FILE_SIZE = 8;
    private static final int RANK_SIZE = 8;
    private final List<Pawn> pawns = new ArrayList<>();
    private final char[][] board = new char[RANK_SIZE][FILE_SIZE];
    public void initialize() {
        addPawns();
        initializeEmptyBoard();
        initializeBoard();
    }

    private void initializeBoard() {
        for (int file = 0; file < FILE_SIZE; file++) {
            board[BLACK_PAWN_RANK][file] = pawns.get(file*2+1).getRepresentation();
            board[WHITE_PAWN_RANK][file] = pawns.get(file*2).getRepresentation();
        }
    }

    private void initializeEmptyBoard() {
        for (int rank = 0; rank < RANK_SIZE; rank++) {
            board[rank] = "........".toCharArray();
        }
    }

    private void addPawns() {
        for (int i = 0; i < 8; i++) {
            pawns.add(new Pawn()); // 백
            pawns.add(new Pawn(BLACK)); // 흑
        }
    }

    public void add(Pawn pawn) {
        validatePawnSize();
        pawns.add(pawn);
    }
    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int index) {
        validateIndex(index);
        return pawns.get(index);
    }

    public String getWhitePawnsResult() {
        return getResult(WHITE_PAWN_RANK);
    }
    public String getBlackPawnsResult() {
        return getResult(BLACK_PAWN_RANK);
    }

    private String getResult(int rank) {
        StringBuilder sb = new StringBuilder();
        for (int file = 0; file < FILE_SIZE; file++) {
            sb.append(board[rank][file]);
        }
        return sb.toString();
    }

    private void validatePawnSize() {
        if (pawns.size() > MAX_PAWN_SIZE) {
            throw new IllegalStateException("폰은 " + MAX_PAWN_SIZE + "개를 초과할 수 없습니다.");
        }
    }

    private void validateIndex(int index) {
        if(MIN_PAWN_INDEX> index || index > MAX_PAWN_INDEX){
            throw new IllegalStateException(index + "번의 폰은 없습니다. " + MIN_PAWN_INDEX + "부터 " + MAX_PAWN_INDEX + " 중 골라주세요.");
        }
    }
}

