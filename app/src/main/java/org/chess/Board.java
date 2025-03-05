package org.chess;

import org.chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Pawn> pawns = new ArrayList<>();

    public void add(Pawn pawn) {
        validatePawnSize();
        pawns.add(pawn);
    }
    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int index) {
        validateIndex(index);
        return pawns.get(index);
    }

    private void validatePawnSize() {
        if (pawns.size() > 16) {
            throw new IllegalStateException("폰은 8개를 초과할 수 없습니다.");
        }
    }

    private void validateIndex(int index) {
        if(1> index || index > 16){
            throw new IllegalStateException(index + "번의 폰은 없습니다. 0부터 7 중 골라주세요.");
        }
    }
}
