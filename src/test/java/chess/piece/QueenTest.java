package chess.piece;

import chess.enums.Color;
import chess.record.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QueenTest {
    private Queen queen;

    @BeforeEach
    void setUp() {
        queen = new Queen(Color.WHITE); // when 흰색 퀸을 초기 위치에 배치
    }

    @Test
    @DisplayName("퀸의 이동 테스트")
    void testQueenCanMove() {
        queen.setCurrentPosition(new Position(4, 4)); // 중앙에 배치

        // 대각선 이동 가능 여부 테스트
        assertTrue(queen.canMove(new Position(7, 7))); // ↗
        assertTrue(queen.canMove(new Position(1, 1))); // ↙
        assertTrue(queen.canMove(new Position(1, 7))); // ↖
        assertTrue(queen.canMove(new Position(7, 1))); // ↘

        // 수직 이동 가능 여부 테스트
        assertTrue(queen.canMove(new Position(4, 7))); // ↑
        assertTrue(queen.canMove(new Position(4, 1))); // ↓

        // 수평 이동 가능 여부 테스트
        assertTrue(queen.canMove(new Position(7, 4))); // →
        assertTrue(queen.canMove(new Position(1, 4))); // ←
    }

    @Test
    @DisplayName("퀸의 잘못된 이동 테스트")
    void testInvalidMoves() {
        queen.setCurrentPosition(new Position(4, 4)); // 중앙에 배치

        // 나이트처럼 L자 이동은 불가능해야 함
        assertFalse(queen.canMove(new Position(5, 2)));
        assertFalse(queen.canMove(new Position(2, 5)));

        // 체스판 밖으로 나가는 이동
        assertFalse(queen.canMove(new Position(-1, 4))); // 왼쪽 밖
        assertFalse(queen.canMove(new Position(4, 8)));  // 위쪽 밖
        assertFalse(queen.canMove(new Position(8, 4)));  // 오른쪽 밖
        assertFalse(queen.canMove(new Position(4, -1))); // 아래쪽 밖

        // 비직선적 이동 (퀸은 대각선, 수직, 수평 이동만 가능)
        assertFalse(queen.canMove(new Position(3, 6)));
        assertFalse(queen.canMove(new Position(6, 3)));
    }
}
