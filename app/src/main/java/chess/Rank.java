package chess;

import pieces.Piece;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Rank {
    private ArrayList<Piece> pieces;

    Rank(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    public Piece getPiece(int index) {
        return pieces.get(index);
    }

    public void setPiece(int index, Piece piece) {
        pieces.set(index, piece);
    }

    @Override
    public String toString() {
        return pieces.stream()
                .map(Piece::toString)
                .collect(Collectors.joining(" "));
    }
}
