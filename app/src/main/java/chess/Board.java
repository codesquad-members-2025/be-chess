package chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Pawn> chessPiecesList;

    private List<Pawn> whitePawnsList;
    private List<Pawn> blackPawnsList;
//    private static final int TOTAL_PAWNS_PER_PLAYER = 8;

    private String whitePawnsResult;
    private String blackPawnsResult;


    public void add(Pawn pawn){
        chessPiecesList.add(pawn);
    }

    public int size(){
        return chessPiecesList.size();
    }

    public Pawn findPawn(int pawnNumber){
        return chessPiecesList.get(pawnNumber);
    }

    public void initialize(){
        for(int i = 0; i < 8; i++){
            whitePawnsList.add(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
            blackPawnsList.add(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
        }

        initializeWhitePawnsResult();
        initializeBlackPawnsResult();
    }

    public String print(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 8; i++){
            if(i == 1) {
                sb.append(blackPawnsResult).append("\n");
                continue;
            }
            if(i == 6) {
                sb.append(whitePawnsResult).append("\n");
                continue;
            }
            sb.append("........").append("\n");
        }
        return sb.toString();
    }



    private void initializeWhitePawnsResult() {
        StringBuilder whitePawnSb = new StringBuilder();

        for (int i = 0; i < whitePawnsList.size(); i++){
            whitePawnSb.append(whitePawnsList.get(i).getRepresentation());
        }

        whitePawnsResult = whitePawnSb.toString();
    }

    private void initializeBlackPawnsResult() {
        StringBuilder blackPawnSb = new StringBuilder();

        for (int i = 0; i < blackPawnsList.size(); i++){
            blackPawnSb.append(blackPawnsList.get(i).getRepresentation());
        }

        blackPawnsResult = blackPawnSb.toString();
    }


    public Board() {
        chessPiecesList = new ArrayList<>();
        whitePawnsList = new ArrayList<>();
        blackPawnsList = new ArrayList<>();
    }

    public String getWhitePawnsResult() {
        return whitePawnsResult;
    }

    public String getBlackPawnsResult() {
        return blackPawnsResult;
    }
}
