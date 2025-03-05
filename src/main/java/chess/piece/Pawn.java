package chess.piece;



public class Pawn {

    public static final Color WHITE = Color.WHITE;
    public static final Color BLACK = Color.BLACK;


    public enum Color {
        WHITE, BLACK
    }

    private final Color color;


    public Pawn(Color color) {
        this.color = color;
    }


    public Pawn() {
        this.color = WHITE;
    }

    public Color getColor() {
        return color;
    }
}

