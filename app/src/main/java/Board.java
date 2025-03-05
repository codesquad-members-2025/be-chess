import java.util.ArrayList;
import java.util.List;

public class Board {
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
