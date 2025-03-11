package pieces;

public class Queen extends Piece {
    public Queen(Color color, Type type, Position position) {
        super(color, type, position);
    }

    @Override
    public boolean canMove(Position target) {
        return false;
    }
}
