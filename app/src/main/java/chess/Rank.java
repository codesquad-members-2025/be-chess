package chess;


import chess.pieces.Piece;

import java.util.List;
import java.util.stream.Collectors;

import static chess.Board.RANK_SIZE;

public class Rank {
    private final List<Piece> rank;

    public Rank(List<Piece> rank) {
        this.rank = rank;
        validateRankSize(rank.size());
    }

    public Piece getPiece(int file) {
        return rank.get(file);
    }

    private void validateRankSize(int size) {
        if (size > RANK_SIZE) {
            throw new IllegalStateException(RANK_SIZE + "를 초과할 수 없습니다. 현재 사이즈: " + size);
        }
    }

    @Override
    public String toString() {
        return rank.stream()
                .map(i -> String.valueOf(i.getRepresentation()))
                .collect(Collectors.joining());
    }
}
