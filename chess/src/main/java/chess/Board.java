package chess;

import java.util.ArrayList;

public class Board {
    ArrayList<Pawn> boardList = new ArrayList<>();

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


    public void initialize() {
        ArrayList<ArrayList<Character>> game_board = new ArrayList<>();


    }

    public String getWhitePawnsResult() {
        String result = "";
        return result;
    }

    public String getBlackPawnsResult() {
        String result = "";
        return result;
    }
}
