package pieces;

public class Rook extends Piece {
    public Rook(Color color, Type type, Position position) {
        super(color, type, position);
    }

    @Override
    public boolean canMove(Position target) {
        return false;
    }
}
