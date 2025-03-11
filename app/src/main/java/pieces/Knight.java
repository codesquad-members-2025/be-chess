package pieces;

public class Knight extends Piece {
    public Knight(Color color, Type type, Position position) {
        super(color, type, position);
    }

    @Override
    public boolean canMove(Position target) {
        return false;
    }
}
