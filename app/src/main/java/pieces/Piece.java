package pieces;

public class Piece {

    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";

    public static final char WHITE_REPRESENTATION = 'p';
    public static final char BLACK_REPRESENTATION = 'P';

    private final String color;
    private final char representation;

    private Piece(String color, char representation){
        this.color = color;
        this.representation = representation;
    }

    public static Piece of(String color, char representation){
        return new Piece(color, representation);
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
