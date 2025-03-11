package chess;

import java.util.ArrayList;

public class Rank {

    private final ArrayList<Piece> pieces;

    public Rank(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    public Piece getPiece(int col) {
        return pieces.get(col);
    }

    public char getPieceRepresentation(Piece piece){
        return piece.getRepresentation();
    }

    public void addPiece(Piece piece){
        pieces.add(piece);
    }



}
