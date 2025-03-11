package pieces;

public class Blank extends Piece {
    private Blank(Position position) {
        super(Color.NOCOLOR, Type.NO_PIECE, position);
    }

    public static Blank createBlank(Position position) {
        return new Blank(position);
    }

    @Override
    public boolean canMove(Position target) {
        return false;
    }
}