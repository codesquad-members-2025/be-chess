public class Pawn {
    private final String color;
    final String COLOR_W = "white";
    final String COLOR_B = "black";

    // 기본생성자
    public Pawn() {
        this.color = "white";
    }

    public Pawn(String color) {
        this.color = color;
    }

    public void move() {
    }

    public String getColor() {
        return color;
    }
}
