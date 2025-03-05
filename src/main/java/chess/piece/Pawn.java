package chess.piece;


public class Pawn {

    public enum Color {
        WHITE, BLACK
    }


    private final Color color;


    public Pawn(Color color) {
        this.color = color;
    }


    public Color getColor() {
        return color;
    }
}
