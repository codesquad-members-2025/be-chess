package org.chess;

import org.pieces.Pawn;
import java.util.*;

public class Board {
    private List<Pawn> pieceList;

    public Board(){
        pieceList = new ArrayList<>();
    }

    public void add(Pawn pawn){
        pieceList.add(pawn);
    }

    public Pawn findPawn(int number){
        return pieceList.get(number);
    }

    public int size(){
        return pieceList.size();
    }
}
