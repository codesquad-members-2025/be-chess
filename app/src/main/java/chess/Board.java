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
                if ( i == 1 ){
                    row.add(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
                } else if ( i == 6 ){
                    row.add(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
                } else {
                    row.add(" . ");
                }
            }
            board.add(row);
        }
    }

    public String getWhitePawnsResult(){
        StringBuilder whiteLine = new StringBuilder();
        for (Object obj : board.get(1)) {
            whiteLine.append(((Pawn)obj).getRepresentation());
        }
        return whiteLine.toString();
    }

    public String getBlackPawnsResult(){
        StringBuilder blackLine = new StringBuilder();
        for (Object obj : board.get(6)) {
            blackLine.append(((Pawn)obj).getRepresentation());
        }
        return blackLine.toString();
    }

    Pawn findPawn(int num){
        return pawns.get(num);
    }
}
