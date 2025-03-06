import org.example.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {


    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() { // create() 테스트 메소드 작성
        String white = "white"; //local variable을 추가
        String black = "black";

        Pawn pawn = new Pawn(white);
        assertThat(pawn.getColor()).isEqualTo(white);

        //2. Pawn 클래스 구현
        Pawn blackPawn = new Pawn(black);
        assertThat(blackPawn.getColor()).isEqualTo(black);

        verifyPawn(white);
        verifyPawn(black);
    }

    //중복 코드 제거를 위한 verifyPawn(final String color)
    public void verifyPawn(final String color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

    @Test
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals("white", pawn.getColor());
    }

}