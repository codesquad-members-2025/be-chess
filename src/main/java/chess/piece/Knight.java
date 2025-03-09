package chess.piece;

import chess.enums.Color;
import chess.enums.Direction;
import chess.record.Position;

import java.util.List;

public class Knight extends Piece {

    public Knight(Color color) {
        super(color);
    }

    private List<Direction> getMovableDirections() {
        return Direction.knightDirection(); // L자 이동 가능
    }

    @Override
    public char getSymbol() {
        return isWhite() ? 'n' : 'N';
    }

    @Override
    public double getPoint() {
        return 2.5;
    }

    @Override
    public boolean canMove(Position target) {
        int dx = target.xPos() - currentPosition.xPos();
        int dy = target.yPos() - currentPosition.yPos();

        for (Direction direction : getMovableDirections()) {
            if (direction.getXDegree() == dx && direction.getYDegree() == dy) {
                return true;
            }
        }
        return false;
    }
}
