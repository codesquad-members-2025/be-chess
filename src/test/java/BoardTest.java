import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTest {
    private Board board;

    // 각 테스트 전에 실행
    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    public void initialize() throws Exception {
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnResult());
        assertEquals("PPPPPPPP", board.getBlackPawnResult());
    }
}
