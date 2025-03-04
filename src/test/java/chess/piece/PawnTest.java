package chess.piece;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PawnTest {

    @Test
    void createWhitePawn() {
        Pawn pawn = new Pawn(Pawn.Color.WHITE);
        assertThat(pawn.getColor()).isEqualTo(Pawn.Color.WHITE);
    }

    @Test
    void createBlackPawn() {
        Pawn pawn = new Pawn(Pawn.Color.BLACK);
        assertThat(pawn.getColor()).isEqualTo(Pawn.Color.BLACK);
    }
}
