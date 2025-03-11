package chess;

import pieces.Piece;
import java.util.ArrayList;

public class Rank {
    private final ArrayList<Piece> row = new ArrayList<>();

    public Rank() {
        for (int i=0; i < 8; i++) {
            row.add(Piece.createBlank());
        }
    }

    //특정 index에 기물 배치
    public void setPiece(int index, Piece piece) {
        row.set(index, piece);
    }

    public ArrayList<Piece> getRow() {
        return row;
    }

    public Piece getPiece(int index) {
        return row.get(index);
    }

    //row의 기물들을 문자열로 변환하여 반환
    public String print() {
        StringBuilder sb = new StringBuilder();
        for (Piece piece :  row) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }

}