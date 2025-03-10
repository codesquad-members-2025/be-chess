package org.pieces;

import org.chess.Board;
import org.chess.Coordinate;
import java.util.HashSet;
import java.util.Set;

public class Blank extends Piece{
    public Blank(Color color){
        super(color,Type.NO_PIECE);
    }

    @Override
    public boolean verifyMovePosition(Board board, Coordinate sourcePosition, Coordinate targetPosition){
        // Blank는 이동할 수 없음
        return false;
    }
}
