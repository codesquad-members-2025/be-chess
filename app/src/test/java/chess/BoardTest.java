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
        board.initialize();
        assertThat("♙♙♙♙♙♙♙♙").isEqualTo(board.getWhitePawnsResult());
        assertThat("♟♟♟♟♟♟♟♟").isEqualTo(board.getBlackPawnsResult());
    }
}

