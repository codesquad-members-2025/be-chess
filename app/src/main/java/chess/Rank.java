package chess;

import pieces.Piece;

import java.util.ArrayList;

public class Rank {
    private static final int MAX_RANK = 8;

    private ArrayList<Piece> rank;

    public Rank() {
        this.rank = new ArrayList<>();
        for (int i = 0; i < MAX_RANK; ++i) {
            rank.add(new Piece(Piece.Color.NO_COLOR, Piece.Type.NO_PIECE));
        }
    }

    public void addPiece(Piece piece) {
        rank.add(piece);
    }
}
