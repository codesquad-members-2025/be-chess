package chess.piece;


import chess.enums.Color;
import chess.record.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KingTest {

    private King whiteKing;
    private King blackKing;

    @BeforeEach //Given: whiteKing과 blackKing 최초 좌표 셋팅
    void setUp() {
        whiteKing = new King(Color.WHITE);
        blackKing = new King(Color.BLACK);

        whiteKing.setCurrentPosition(new Position(4, 0)); // e1
        blackKing.setCurrentPosition(new Position(4, 7)); // e8
    }

    @Test
    @DisplayName("킹의 기물 표현 테스트")
    void testKingSymbol() {
        //Then 색깔에 맞는 심볼 확인
        assertThat(whiteKing.getSymbol()).isEqualTo('k');
        assertThat(blackKing.getSymbol()).isEqualTo('K');
    }

    @Test
    @DisplayName("킹의 정상적인 이동 테스트 - 한 칸 이동 가능")
    void testKingCanMove() {
        // Given: 현재 위치 e1 (4,0)

        // When & Then: 킹은 한 칸 이동 가능해야 함
        assertThat(whiteKing.canMove(new Position(4, 1))).isTrue(); // 아래로 이동 (e2)
        assertThat(whiteKing.canMove(new Position(3, 1))).isTrue(); // 왼쪽 아래 대각선 이동 (d2)
        assertThat(whiteKing.canMove(new Position(5, 0))).isTrue(); // 오른쪽 이동 (f1)
    }

    @Test
    @DisplayName("킹의 잘못된 이동 테스트 - 2칸 이상 이동 불가")
    void testInvalidMove() {
        // Given: 현재 위치 e1 (4,0)

        // When & Then: 2칸 이상 이동 불가
        assertThat(whiteKing.canMove(new Position(4, 2))).isFalse(); // 2칸 아래 (e3)
        assertThat(whiteKing.canMove(new Position(2, 2))).isFalse(); // 2칸 대각선 (c3)
        assertThat(whiteKing.canMove(new Position(6, 0))).isFalse(); // 2칸 오른쪽 (g1)
    }

    @Test
    @DisplayName("킹의 보드 밖 이동 테스트")
    void testKingCannotMoveOutsideBoard() {
        // Given: 현재 위치 h8 (7,7)로 이동 후 테스트
        blackKing.setCurrentPosition(new Position(7, 7)); // h8 위치

        // When & Then: 체스판 밖으로 이동하는 경우 false 반환
        assertThat(blackKing.canMove(new Position(8, 7))).isFalse(); // 오른쪽 벗어남
        assertThat(blackKing.canMove(new Position(7, 8))).isFalse(); // 위쪽 벗어남
    }
}
