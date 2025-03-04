import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    final String COLOR_W = "white";
    final String COLOR_B = "black";

    @Test
    @DisplayName("흰색, 검은색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(COLOR_W);
        verifyPawn(COLOR_B);
    }

    public void verifyPawn(String color) {
        Pawn whitePawn = new Pawn(color);
        assertThat(whitePawn.getColor()).isEqualTo(color);
    }

}