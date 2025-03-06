package pieces;

public class Pawn implements Piece {
    public static final String COLOR_W = "white";
    public static final String COLOR_B = "black";
    private final String color;

    // 기본생성자
    public Pawn() {
        this.color = COLOR_W;
    }

    public Pawn(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
