package chess.pieces;

public class Piece {

    public static final String BLACK = "black";
    public static final String WHITE = "white";
    public static final char WHITE_REPRESENTATION = '♙';
    public static final char BLACK_REPRESENTATION = '♟';

    private final String name;
    private final String color;
    private final char representation;

    public Piece(String color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public Piece(String color) {
        this.color = color;
        this.representation = color.equals(WHITE) ? WHITE_REPRESENTATION : BLACK_REPRESENTATION;
    }
    public Piece() {
        this.color = WHITE;
        this.representation = WHITE_REPRESENTATION;
    }
    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}

