package pieces;


public class Pawn {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static char WHITE_REPRESENTATION = 'p';
    public static char BLACK_REPRESENTATION = 'P';

    private final String color;
    private final char representation;

    // 기본 생성자
    public Pawn() {
        this.color = WHITE_COLOR;
        this.representation = WHITE_REPRESENTATION;
    }

    public Pawn(String color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
