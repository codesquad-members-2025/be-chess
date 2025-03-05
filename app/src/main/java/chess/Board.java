package chess;

import pieces.Pawn;

import java.util.*;

public class Board {
    private List<Pawn> pawns = new ArrayList<>();
    public final static int MAX_ROW = 8;
    public final static int MAX_CAL = 8;
    private List<List<Object>> board;

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public int size(){
        return pawns.size();
    }

    public void initialize(){
        board = new ArrayList<>();
        for (int i = 0; i < MAX_ROW; i++) {
            List<Object> row = new ArrayList<>();
            for (int j = 0; j < MAX_CAL; j++) {
                row.add(SetUpBoard(i));
            }
            board.add(row);
        }
    }

    private Object SetUpBoard(int i){
        if ( i == 1 ) return new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        if ( i == 6 ) return new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
        return " . ";
    }

    public String getWhitePawnsResult(){
        return getPawnsResult(1);
    }

    public String getBlackPawnsResult(){
        return getPawnsResult(6);
    }

    private String getPawnsResult(int index){
        StringBuilder result = new StringBuilder();
        for (Object obj : board.get(index)) {
            result.append(((Pawn)obj).getRepresentation());
        }
        return result.toString();
    }

    Pawn findPawn(int num){
        return pawns.get(num);
    }
}