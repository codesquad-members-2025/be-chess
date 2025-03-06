package chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Pawn> chessPiecesList;

    public void add(Pawn pawn){
        chessPiecesList.add(pawn);
    }

    public int size(){
        return chessPiecesList.size();
    }

    public Pawn findPawn(int pawnNumber){
        return chessPiecesList.get(pawnNumber);
    }


    public Board() {
        chessPiecesList = new ArrayList<>();
    }
}
