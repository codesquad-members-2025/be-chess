package chess.pieces;
import chess.pieces.Pawn;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import static chess.pieces.Pawn.*;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰과 검은색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(BLACK);
        verifyPawn(WHITE);
    }

    @Test
    @DisplayName("인자에 color를 넣지 않을 경우 white 색상의 pawn이 만들어져야 한다.")
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(WHITE);
    }

    private void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}
