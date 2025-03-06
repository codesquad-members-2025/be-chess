package org.chess.domain.board;

import org.chess.domain.pieces.Piece;

import java.util.List;

public class Rank {

    private final List<Piece> pieces;

    private Rank(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public static Rank of(List<Piece> pieces) {
        return new Rank(pieces);
    }

    public List<Piece> getPieces() {
        return pieces;
    }

}
