package chess.pieces;

public class Pawn {

    public static final String BLACK = "black";
    public static final String WHITE = "white";
    public static final char WHITE_REPRESENTATION = '♙';
    public static final char BLACK_REPRESENTATION = '♟';

    private final String color;
    private final char representation;

    public Pawn(String color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public Pawn(String color) {
        this.color = color;
    }
    public Pawn() {
        this.color = WHITE;
    }
    public String getColor() {
        return color;
    }
}
