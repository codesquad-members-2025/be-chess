package pieces;

public class Pawn extends Piece {
    public Pawn(Color color, Type type, Position position) {
        super(color, type, position);
    }

    @Override
    public boolean canMove(Position target) {
        return false;
    }
}
