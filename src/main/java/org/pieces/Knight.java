package org.pieces;

import org.chess.Board;
import org.chess.Coordinate;

public class Knight extends Piece{
    public Knight(Color color){
        super(color,Type.KNIGHT);
    }

    @Override
    public boolean verifyMovePosition(Board board, Coordinate sourcePosition, Coordinate targetPosition){
        return getOffsetMoves(board,Direction.knightDirection(),sourcePosition,targetPosition).contains(targetPosition);
    }
}
