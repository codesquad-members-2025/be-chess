package chess.pieces;

public class Pawn {

    public static final String BLACK = "black";
    public static final String WHITE = "white";


    private final String color;

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
