package chess.pieces;

public class Piece {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final char WHITE_REPRESENTATION = '♗';
    public static final char BLACK_REPRESENTATION = '♟';
    private final String color;
    private char representation;

    public Piece(String color, char representation) {
        this.color = color;
        this.representation = representation;
    }
    public Piece(String color) {
        this.color = color;
    }
    public Piece() {
        color = WHITE_COLOR;
        representation = '♗';
    }


    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
