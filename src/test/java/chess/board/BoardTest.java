package chess.board;

import chess.enums.Color;
import chess.piece.Pawn;
import chess.piece.Piece;
import chess.record.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        // Given: 보드 초기화
        board = new Board();
    }

    @Test
    @DisplayName("체스판 초기화 테스트 - 기물 개수 확인")
    void testInitializeBoard() {
        // When: 체스판이 초기화되었을 때
        int pieceCount = board.pieceCount();

        // Then: 모든 기물이 정상적으로 배치되었는지 확인 (총 32개)
        assertThat(pieceCount).isEqualTo(32);
    }

    @Test
    @DisplayName("특정 기물 개수 확인 - 흰색 폰")
    void testGetSpecificPieceWhitePawn() {
        // When: 체스판에서 흰색 폰 개수를 조회
        int whitePawnCount = board.getSpecificPiece(Pawn.class, Color.WHITE);

        // Then: 흰색 폰이 8개 있어야 함
        assertThat(whitePawnCount).isEqualTo(8);
    }

    @Test
    @DisplayName("특정 기물 개수 확인 - 검은색 폰")
    void testGetSpecificPieceBlackPawn() {
        // When: 체스판에서 검은색 폰 개수를 조회
        int blackPawnCount = board.getSpecificPiece(Pawn.class, Color.BLACK);

        // Then: 검은색 폰이 8개 있어야 함
        assertThat(blackPawnCount).isEqualTo(8);
    }

    @Test
    @DisplayName("특정 위치의 기물 찾기")
    void testFindPiece() {
        // When: 특정 위치의 기물을 조회
        Piece piece = board.findPiece("e2");

        // Then: 해당 위치에 흰색 폰이 있어야 함
        assertThat(piece).isInstanceOf(Pawn.class);
        assertThat(piece.getColor()).isEqualTo(Color.WHITE);
    }

    @Test
    @DisplayName("체스판 비우기 테스트")
    void testInitializeEmptyBoard() {
        // Given: 체스판 초기화 후
        board.initializeEmpty();

        // When: 모든 기물이 제거되었을 때
        int pieceCount = board.pieceCount();

        // Then: 체스판이 빈 상태여야 함
        assertThat(pieceCount).isEqualTo(0);
    }

    @Test
    @DisplayName("체스판에서 특정 위치 변환 테스트")
    void testPositionConversion() {
        // When: 문자열 위치를 Position 객체로 변환
        Position position = Board.getPosition("d4");

        // Then: 변환된 좌표가 맞는지 확인 (체스판은 8x8이며 d4는 (3,4)에 해당)
        assertThat(position.xPos()).isEqualTo(3);
        assertThat(position.yPos()).isEqualTo(4);
    }
}
