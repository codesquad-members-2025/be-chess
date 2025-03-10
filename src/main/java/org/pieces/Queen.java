package org.pieces;

import org.chess.Board;
import org.chess.Coordinate;

public class Queen extends Piece{
    public Queen(Color color){
        super(color,Type.QUEEN);
    }

    @Override
    public boolean verifyMovePosition(Board board, Coordinate sourcePosition, Coordinate targetPosition){
        return getSlidingMoves(board,Direction.everyDirection(),sourcePosition,targetPosition).contains(targetPosition);
    }
}
