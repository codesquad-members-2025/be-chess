package chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class PawnTest {
    // 중복 제거를 위해 로컬 변수로 색상 정의
    final Pawn.Color white = Pawn.Color.WHITE;
    final Pawn.Color black = Pawn.Color.BLACK;

    @Test
    @DisplayName("흰색과 검은색 폰이 정상적으로 생성되어야 한다")
    void create() {


        // verifyPawn 메서드로 중복 제거
        verifyPawn(white);
        verifyPawn(black);
    }
    @Test
    public void create_defaultConstructor() throws Exception {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(white);
    }

    private void verifyPawn(final Pawn.Color color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}
