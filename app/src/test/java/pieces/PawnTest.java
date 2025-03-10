package pieces;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    private final String white = "white";
    private final String black = "black";

    @Test
    @DisplayName("지정된 색의 폰이 생성되어야 한다.")
    public void create() {
        verifyPawn(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION);
        verifyPawn(Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION);
    }

    void verifyPawn(final String color, final char representation){
        Piece pawn = Piece.of(color, representation);
        assertEquals(color, pawn.getColor());
        assertEquals(representation, pawn.getRepresentation());
    }

//    @Test
//    public void create_기본생성자() throws Exception {
//        Piece pawn = new Piece();
//        assertEquals(Piece.WHITE_COLOR, pawn.getColor());
//        assertEquals(Piece.WHITE_REPRESENTATION, pawn.getRepresentation());
//    }



}
