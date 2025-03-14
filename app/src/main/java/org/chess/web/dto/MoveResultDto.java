package org.chess.web.dto;

import lombok.Getter;
import org.chess.domain.board.Position;

@Getter
public class MoveResultDto {
    private final String currentTurn;  // white 또는 black
    private final String lastMoveFrom;  // 마지막 이동 시작 위치
    private final String lastMoveTo;    // 마지막 이동 도착 위치
    private final boolean isValidMove;  // 유효한 이동인지 여부
    private final String FEN; // FEN 문자열

    private MoveResultDto(String currentTurn,
                         String lastMoveFrom, String lastMoveTo, boolean isValidMove, String FEN) {
        this.currentTurn = currentTurn;
        this.lastMoveFrom = lastMoveFrom;
        this.lastMoveTo = lastMoveTo;
        this.isValidMove = isValidMove;
        this.FEN = FEN;
    }

    public static MoveResultDto of(Position from, Position to, String currentTurn, boolean isValidMove, String FEN) {
        return new MoveResultDto(
            currentTurn,
            from.toString(),
            to.toString(),
            isValidMove,
            FEN
        );
    }
}
