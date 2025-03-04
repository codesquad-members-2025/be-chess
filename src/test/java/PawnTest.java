import chess.piece.Pawn;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create(){
        final Pawn.Color white = Pawn.Color.WHITE;
        final Pawn.Color black = Pawn.Color.BLACK;

        verifyPawn(white);
        verifyPawn(black);
    }

    private void verifyPawn(final Pawn.Color color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }




}
