package pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    private final String COLOR_W = "white";
    private final String COLOR_B = "black";

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

    @Test
    public void createDefaultConstructor() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(COLOR_W, pawn.getColor());
    }

}