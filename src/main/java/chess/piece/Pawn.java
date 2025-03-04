package chess.piece;

/**
 * 체스 게임의 폰(Pawn)을 나타내는 클래스입니다.
 * 흰색(WHITE)과 검은색(BLACK)을 구분하여 생성할 수 있습니다.
 */
public class Pawn {

    // 폰의 색상 정의
    public enum Color {
        WHITE, BLACK
    }

    // 폰의 색상 필드
    private final Color color;

    /**
     * 지정된 색상으로 폰을 생성합니다.
     *
     * @param color 폰의 색상 (흰색 또는 검은색)
     */
    public Pawn(Color color) {
        this.color = color;
    }

    /**
     * 폰의 색상을 반환합니다.
     *
     * @return 폰의 색상 (WHITE 또는 BLACK)
     */
    public Color getColor() {
        return color;
    }
}
