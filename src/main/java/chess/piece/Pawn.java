package chess.piece;


public class Pawn {

    // 폰의 색상 정의
    public enum Color {
        WHITE, BLACK
    }

    // 폰의 색상 필드
    private final Color color;


    public Pawn(Color color) {
        this.color = color;
    }


    public Color getColor() {
        return color;
    }
}
