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


    public void initialize() {
        for(int i = 0; i<BOARD_SIZE; i++){
           whitePawns.add(new Pawn());
           blackPawns.add(new Pawn("black"));
        }

        for(int i = 0; i<BOARD_SIZE; i++){
            for(int j = 0; j<BOARD_SIZE; j++){
                if(i == 1){
                    board[i][j] = blackPawns.get(j).getRepresentation();
                }
                else if(i == 6){
                    board[i][j] = whitePawns.get(j).getRepresentation();
                }

                else board[i][j] = '.';
            }
        }

    }

    public String getWhitePawnsResult() {
        StringBuilder sb = new StringBuilder();

        for(Pawn whitePawn : whitePawns){
            sb.append(whitePawn.getRepresentation());
        }

        return sb.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder sb = new StringBuilder();

        for(Pawn blackPawn : blackPawns){
            sb.append(blackPawn.getRepresentation());
        }

        return sb.toString();
    }

    public String print(){
        StringBuilder board_sb = new StringBuilder();
        for(int i = 0; i<BOARD_SIZE; i++){
            board_sb.append(board[i]).append("\n");
        }

        return board_sb.toString();
    }
}
