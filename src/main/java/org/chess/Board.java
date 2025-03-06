package org.chess;

import org.pieces.Pawn;

import java.util.*;

public class Board {
    private List<Pawn> pieceList = new ArrayList<>();
    private List<Pawn> whitePawnList = new ArrayList<>();
    private List<Pawn> blackPawnList = new ArrayList<>();

    public Board() {
        pieceList = new ArrayList<>();
    }

    public void add(Pawn pawn) {
        pieceList.add(pawn);
    }

    public Pawn findPawn(int number) {
        return pieceList.get(number);
    }

    public int size() {
        return pieceList.size();
    }

    public void initialize() {
        for(int i = 0 ; i<8; i++){
            Pawn pawn = new Pawn(Pawn.WHITE_COLOR);
            whitePawnList.add(pawn);
        }
        for(int i = 0 ; i<8; i++){
            Pawn pawn = new Pawn(Pawn.BLACK_COLOR);
            blackPawnList.add(pawn);
        }
    }

    public String getPawnsResult(List<Pawn> pawnList){
        StringBuilder sb = new StringBuilder();
        for(Pawn pawn : pawnList){
            sb.append(pawn.getRepresentation());
        }
        return sb.toString();
    }

    public String getWhitePawnsResult(){
        return getPawnsResult(whitePawnList);
    }

    public String getBlackPawnsResult(){
        return getPawnsResult(blackPawnList);
    }

    public String getBlankLine(){
        return "........";
    }

    public String print(){
        StringBuilder sb = new StringBuilder();
        sb.append(getBlankLine()).append("\n");
        sb.append(getBlackPawnsResult()).append("\n");
        sb.append(getBlankLine()).append("\n");
        sb.append(getBlankLine()).append("\n");
        sb.append(getBlankLine()).append("\n");
        sb.append(getBlankLine()).append("\n");
        sb.append(getWhitePawnsResult()).append("\n");
        sb.append(getBlankLine()).append("\n");

        return sb.toString();
    }
}
