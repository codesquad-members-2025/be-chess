package org.example;

import java.util.ArrayList;

public class Board {

    ArrayList<Pawn> BoardList = new ArrayList<>();

    public void add(Pawn pawn) {
        BoardList.add(pawn);
    }

    public int size() {
        return BoardList.size();
    }

    // 인덱스를 사용하여 Pawn 객체 찾기
    public Pawn findPawn(int idx) {
        if (idx >= 0 && idx < BoardList.size()) {
            return BoardList.get(idx);
        }
        return null;
    }
}
