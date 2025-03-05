package org.example;

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
        return pawns.get(index);
    }

    private void validatePawnSize() {
        if (pawns.size() > 8) {
            throw new IllegalStateException("폰은 8개를 초과할 수 없습니다.");
        }
    }
}
