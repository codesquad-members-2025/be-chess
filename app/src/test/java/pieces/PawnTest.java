package pieces;

import org.junit.jupiter.api.*;
import pieces.Pawn;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    private String white;
    private String black;

    @BeforeEach
    public void init(){
        white = "white";
        black = "black";
    }

    @Test
    @DisplayName("지정된 색의 폰이 생성되어야 한다.")
    public void create() {
        verifyPawn(white);
        verifyPawn(black);
    }

    void verifyPawn(final String color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

    @Test
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.WHITE_COLOR, pawn.getColor());
    }



}
