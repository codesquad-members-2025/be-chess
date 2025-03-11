package pieces;

public class Queen extends Piece {
    private Queen(Color color, Position position) {
        super(color, Type.QUEEN, position);
    }

    public static Queen createQueen(Color color, Position position) {
        return new Queen(color, position);
    }

    @Override
    public boolean canMove(Position target) {
        return false;
    }
}
