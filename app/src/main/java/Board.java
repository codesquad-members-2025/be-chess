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
}
