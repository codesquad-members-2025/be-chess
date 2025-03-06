package chess;

import java.util.ArrayList;
import java.util.List;

public class Board {
    ArrayList<Pawn> boardList = new ArrayList<>();
    private final List<Pawn> whitePawns = new ArrayList<>();
    private final List<Pawn> blackPawns = new ArrayList<>();
    static final int BOARD_SIZE = 8;
    char[][] board = new char[BOARD_SIZE][BOARD_SIZE];

    public void add(Pawn pawn) {
        boardList.add(pawn);
    }

    public int size() {
        return boardList.size();
    }

    // 인덱스를 사용하여 Pawn 객체 찾기
    public Pawn findPawn(int idx) {
        if (isValidIndex(idx)) {
            return boardList.get(idx);
        }
        return null;
    }

    //유효성 검사
    private boolean isValidIndex(int idx) {
        return idx >= 0 && idx < boardList.size();
    }

    public void initializePawns() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            whitePawns.add(new Pawn());
            blackPawns.add(new Pawn("black"));
        }
    }

    public void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = getPawnRepresentation(i, j);
            }
        }
    }

    public char getPawnRepresentation(int row, int col) {
        if (row == 1) return blackPawns.get(col).getRepresentation();
        if (row == 6) return whitePawns.get(col).getRepresentation();
        return '.';
    }
    public String getPawnsResult(List<Pawn> pawns) {
        StringBuilder sb = new StringBuilder();
        for (Pawn pawn : pawns) {
            sb.append(pawn.getRepresentation());
        }
        return sb.toString();
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(blackPawns);
    }

    public String print() {
        StringBuilder board_sb = new StringBuilder();
        for (int i = 0; i < BOARD_SIZE; i++) {
            board_sb.append(board[i]).append("\n");
        }

        return board_sb.toString();
    }
}