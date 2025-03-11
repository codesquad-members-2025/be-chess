package pieces;

public class Pawn extends Piece {
    private Pawn(Color color, Position position) {
        super(color, Type.PAWN, position);
    }

    public static Pawn createPawn(Color color, Position position) {
        return new Pawn(color, position);
    }

    @Override
    public boolean canMove(Position target) {
        return false;
    }
}
