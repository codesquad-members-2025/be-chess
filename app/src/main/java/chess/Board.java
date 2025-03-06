package chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    //List<PAWN> 객체를 사용하고 있기 때문에 Pawn 이외의 객체를 추가하면 오류 발생
    private final List<Pawn> board; // 체스판에 있는 Pawn 리스트
    
    public Board() {
        this.board = new ArrayList<>();
    }

    public void add(Pawn pawn) {
        board.add(pawn);
    }
    
    public int size() {
        return board.size();
    }
    
    public Pawn findPawn(int index) {
        return board.get(index);
    }
}
