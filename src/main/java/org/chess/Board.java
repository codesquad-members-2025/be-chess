package org.chess;

import org.pieces.Piece;

import java.util.*;

public class Board {
    private List<Piece> pieceList = new ArrayList<>();
    private List<Piece> whitePawnList = new ArrayList<>();
    private List<Piece> blackPawnList = new ArrayList<>();

    public Board() {
        pieceList = new ArrayList<>();
    }

    public void add(Piece piece) {
        pieceList.add(piece);
    }

    public Piece findPawn(int number) {
        return pieceList.get(number);
    }

    public int size() {
        return pieceList.size();
    }

    public void initialize() {
        for(int i = 0 ; i<8; i++){
            Piece piece = Piece.createWhitePawn();
            whitePawnList.add(piece);
        }
        for(int i = 0 ; i<8; i++){
            Piece piece = Piece.createBlackPawn();
            blackPawnList.add(piece);
        }
    }

    public String getPawnsResult(List<Piece> pawnList){
        StringBuilder sb = new StringBuilder();
        for(Piece piece : pawnList){
            sb.append(piece.getRepresentation());
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
