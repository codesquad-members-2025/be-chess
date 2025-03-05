import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Pawn> pawns;

    public Board() {
        this.pawns = new ArrayList<>();
    }

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int pawnNumber) {
        return pawns.get(pawnNumber);
    }
}
