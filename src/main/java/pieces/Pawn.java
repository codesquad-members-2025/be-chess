package pieces;

public class Pawn implements Piece {
    public static final String COLOR_WHITE = "white";
    public static final String COLOR_BLACK = "black";
    public static final char REPRESENTATION_WHITE = 'p';
    public static final char REPRESENTATION_BLACK = 'P';

    private final String color;
    private final char representation;

    // 기본생성자
    public Pawn() {
        this.color = COLOR_WHITE;
        this.representation = REPRESENTATION_WHITE;
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
