package chess;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import java.util.List;

public class Rank {
    private final List<Piece> rank;

    public Rank(List<Piece> rank) {
        this.rank = rank;
    }

    public int getSize() {
        return rank.size();
    }

    public Color getColor(int index) {
        return rank.get(index).getColor();
    }
    public Type getName(int index) {
        return rank.get(index).getName();
    }

    public int pieceCountPerRank() {
        return (int) rank.stream()
                .filter(piece -> !piece.getName().equals(Type.NO_PIECE))
                .count();
    }
    public String getPawnString(Color color) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : rank) {
            if (sb.length() == 8) break;
            if (piece.getColor().equals(color) && piece.getName().equals(Type.PAWN))
                sb.append(piece.getName().getRepresentation(color));
        }
        return sb.toString();
    }
}
