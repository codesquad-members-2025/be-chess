package pieces;

public class Rook extends Piece {
    private Rook(Color color, Position position) {
        super(color, Type.ROOK, position);
    }

    public static Rook createRook(Color color, Position position) {
        return new Rook(color, position);
    }

    @Override
    public boolean canMove(Position target) {
        Position position = getPosition();
        if (position.getX() == target.getX() || position.getY() == target.getY()) { return true; }

        return false;
    }
}
