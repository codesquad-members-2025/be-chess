package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("흑/백의 값을 잘 가져오는지 테스트")
    public void initialize() throws Exception {
        assertThat("pppppppp").isEqualTo(board.getWhitePawnsResult());
        assertThat("PPPPPPPP").isEqualTo(board.getBlackPawnsResult());
    }

    @Test
    @DisplayName("체스판 출력")
    public void print() throws Exception{
        String expectResult =
                """
                ........
                PPPPPPPP
                ........
                ........
                ........
                ........
                pppppppp
                ........
                """;
        String result = board.print();
        System.out.println(result);
        assertThat(result).isEqualTo(expectResult);

    }
}

