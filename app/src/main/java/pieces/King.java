package pieces;

public class King extends Piece {
    private King(Color color, Position position) {
        super(color, Type.KING, position);
    }

    public static King createKing(Color color, Position position) {
        return new King(color, position);
    }

    @Override
    public boolean canMove(Position target) {
        return false;
    }
}
