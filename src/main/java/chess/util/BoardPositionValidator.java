package chess.util;

import chess.record.Position;

public class BoardPositionValidator {

    public static boolean isWithinBoard(Position position) {
        int x = position.xPos();
        int y = position.yPos();
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}
