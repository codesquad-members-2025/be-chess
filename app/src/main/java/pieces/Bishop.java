package pieces;

public class Bishop extends Piece{
    public Bishop(Color color, Type type, Position position) {
        super(color, type, position);
    }

    @Override
    public boolean canMove(Position target) {
        return false;
    }
}
