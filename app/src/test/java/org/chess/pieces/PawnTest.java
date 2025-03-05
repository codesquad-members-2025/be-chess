package org.chess.pieces;
import org.chess.pieces.Pawn;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import static org.chess.pieces.Pawn.*;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰과 검은색 폰이 생성되어야 한다")
    public void create() {

        verifyPawn(BLACK);
        verifyPawn(WHITE);
    }
    /**
     * 이 테스트는 왜 컴파일 에러를 발생시키는가? (힌트: 기본 생성자에 대해 생각해보자.)
     * -> 기본 생성자가 아닌 생성자를 생성하였다면 기본 생성자는 생성되지 않기 때문에 Pawn 객체를 생성할 때는 인자에 color를 넣어줘야 함.
     * -> 기본 생성자를 명시적으로 만들어 인자에 color를 넣지 않았다면 기본으로 white를 가지게 하면 됨.
     */
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