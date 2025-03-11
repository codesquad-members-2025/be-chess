package pieces;

public class Bishop extends Piece{
    private Bishop(Color color, Position position) {
        super(color, Type.BISHOP, position);
    }

    public static Bishop createBishop(Color color, Position position) {
        return new Bishop(color, position);
    }

    @Override
    public boolean canMove(Position target) {
        return false;
    }
}
