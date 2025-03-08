package chess.piece;

import chess.enums.Color;
import chess.enums.Direction;
import chess.record.Position;

import java.util.List;

public class Pawn extends Piece{


    public Pawn(Color color){
        super(color);
    }

    public List<Direction> getMovableDirections() {
        if (isWhite()) {
            return Direction.whitePawnDirection();
        }
        return Direction.blackPawnDirection();
    }



    @Override
    public char getSymbol() {
        if(color==Color.WHITE){
            return 'p';
        }
        else{
            return 'P';
        }
    }

    @Override
    public double getPoint() {
        return 1.0;
    }

    @Override
    public boolean canMove(Position target) {
        isWithinBoard(target);
        int dx = target.xPos() - currentPosition.xPos();
        int dy = target.yPos() - currentPosition.yPos();

        for (Direction direction : getMovableDirections()) {
            if (direction.getXDegree() == dx && direction.getYDegree() == dy) {
                return true;
            }
        }
        return false;
    }

    private boolean isWithinBoard(Position position) {
        int x = position.xPos();
        int y = position.yPos();
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}
