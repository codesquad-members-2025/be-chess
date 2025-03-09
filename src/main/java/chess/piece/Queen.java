package chess.piece;

import chess.enums.Color;
import chess.enums.Direction;
import chess.record.Position;

import java.util.List;

public class Queen extends Piece {


    public Queen(Color color) {
        super(color);
    }


    private List<Direction> getMovableDirections() {
        return Direction.everyDirection();  // 8방향 다 가능
    }

    @Override
    public char getSymbol() {
        return isWhite() ? 'q' : 'Q';
    }

    @Override
    public double getPoint() {
        return 9.0;
    }

    public boolean canMove(Position target) {
        for (Direction direction : getMovableDirections()) {
            if (isLinearMove(currentPosition, target, direction)) {
                return true;
            }
        }
        return false;
    }

    private boolean isLinearMove(Position source, Position target, Direction direction) {
        int stepX = direction.getXDegree();
        int stepY = direction.getYDegree();

        int x = source.xPos() + stepX;
        int y = source.yPos() + stepY;

        while (isWithinBoard(new Position(x,y))) {
            if (x == target.xPos() && y == target.yPos()) {
                return true;
            }
            x += stepX;
            y += stepY;
        }
        return false;
    }

    private boolean isWithinBoard(Position position) {
        int x = position.xPos();
        int y = position.yPos();
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}
