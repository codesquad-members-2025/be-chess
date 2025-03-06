package chess.piece;

public abstract class Piece {

    public enum Color {
        WHITE, BLACK
    }

    private final Color color;

    protected Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    // 기물마다 다른 표시 문자 (P, R, N 등)를 반환하도록 추상 메소드
    public abstract char getSymbol();
}
