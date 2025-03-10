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
}