package org.pieces;

import org.chess.Board;
import org.chess.Coordinate;

public class Bishop extends Piece{
    public Bishop(Color color){
        super(color,Type.BISHOP);
    }

    @Override
    public boolean verifyMovePosition(Board board, Coordinate sourcePosition, Coordinate targetPosition){
        return getSlidingMoves(board,Direction.diagonalDirection(),sourcePosition,targetPosition).contains(targetPosition);
    }
}
