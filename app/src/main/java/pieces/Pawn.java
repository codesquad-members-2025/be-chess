package pieces;

public class Pawn {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";

    public static final char WHITE_REPRESENTATION = '♙';
    public static final char BLACK_REPRESENTATION = '♟';

    private final String color;

    public Pawn() {
        this.color = WHITE_COLOR;
    }

    public Pawn(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
