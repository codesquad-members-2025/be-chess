package chess;

import pieces.Piece;

import java.util.List;

public class Rank {

    private final List<Piece> pieces;

    public Rank(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public String getRankStatus(){
        StringBuilder rankStatus = new StringBuilder();
        for (Piece piece : pieces) {
            if(piece.getColor().equals(Piece.Color.WHITE) || piece.getColor().equals(Piece.Color.NOCOLOR)){
                rankStatus.append(piece.getType().getWhiteRepresentation());
            }
            else if(piece.getColor().equals(Piece.Color.BLACK)){
                rankStatus.append(piece.getType().getBlackRepresentation());
            }
        }
        return rankStatus.toString();
    }



}
