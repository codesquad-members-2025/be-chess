package pieces;

public class Knight extends Piece {
    private Knight(Color color, Position position) {
        super(color, Type.KNIGHT, position);
    }

    public static Knight createKnight(Color color, Position position) {
        return new Knight(color, position);
    }

    @Override
    public boolean canMove(Position target) {
        return false;
    }
}
