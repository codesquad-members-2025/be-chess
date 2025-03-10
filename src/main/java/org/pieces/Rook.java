package org.pieces;

import org.chess.Board;
import org.chess.Coordinate;

public class Rook extends Piece{
    public Rook(Color color){
        super(color,Type.ROOK);
    }

    @Override
    public boolean verifyMovePosition(Board board, Coordinate sourcePosition, Coordinate targetPosition){
        return getSlidingMoves(board,Direction.linearDirection(),sourcePosition,targetPosition).contains(targetPosition);
    }
}
