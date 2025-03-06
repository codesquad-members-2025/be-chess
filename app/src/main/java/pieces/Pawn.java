package pieces;


public class Pawn {
    public static final String WHITE = "white";
    public static final String BLACK = "black";

    private final String color;

    // 기본 생성자
    public Pawn() {
        this.color = WHITE;
    }

    public Pawn(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
