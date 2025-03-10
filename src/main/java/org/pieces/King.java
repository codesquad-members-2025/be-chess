package org.pieces;

import org.chess.Board;
import org.chess.Coordinate;

public class King extends Piece{
    public King(Color color){
        super(color,Type.KING);
    }

    @Override
    public boolean verifyMovePosition(Board board, Coordinate sourcePosition, Coordinate targetPosition) {
        return getOffsetMoves(board, Direction.everyDirection(), sourcePosition, targetPosition).contains(targetPosition);
    }
}
