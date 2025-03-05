package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final int MIN_PAWN_INDEX = 0;
    private static final int MAX_PAWN_INDEX = 15;
    private static final int MAX_PAWN_SIZE = 16;

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
        if (pawns.size() > MAX_PAWN_SIZE) {
            throw new IllegalStateException("폰은 " + MAX_PAWN_SIZE + "을 초과할 수 없습니다.");
        }
    }

    private void validateIndex(int index) {
        if(MIN_PAWN_INDEX> index || index > MAX_PAWN_INDEX){
            throw new IllegalStateException(index + "번의 폰은 없습니다. 0부터 7 중 골라주세요.");
        }
    }
}
