package pieces;

public class Pawn {
    private String color;
    private char shape;

    public final static String WHITE_COLOR = "white";
    public final static String BLACK_COLOR = "black";

    public final static char WHITE_REPRESENTATION = 'p';
    public final static char BLACK_REPRESENTATION = 'P';

    public Pawn() { this.color = WHITE_COLOR; }

    public Pawn(String color, char shape) {
        this.color = color;
        this.shape = shape;
    }
    public String getColor(){ return color; }
    public char getRepresentation(){ return shape; }
}
