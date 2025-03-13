package chess;

import java.util.ArrayList;

public class Rank {

    private final ArrayList<Piece> pieces;

    public Rank(ArrayList<Piece> pieces) {
        this.pieces = new ArrayList<>(pieces);
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


    //기존의 Piece를 제거하고 새로운 Piece로 변경하는 경우
    public void setPiece(int x, Piece piece) {
        pieces.set(x, piece);
    }

    public int size(){
        return pieces.size();
    }
}
