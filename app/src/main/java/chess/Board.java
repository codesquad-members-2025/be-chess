package chess;

import pieces.Pawn;

import java.util.*;

public class Board {
    private List<Pawn> pawns = new ArrayList<>();

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public int size(){
        return pawns.size();
    }

    Pawn findPawn(int num){
        return pawns.get(num);
    }
}
