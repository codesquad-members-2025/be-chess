package chess;


import chess.pieces.Piece;

import java.util.ArrayList;
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

    public Rank updatePiece(int file, Piece piece) {
        ArrayList<Piece> tmpRank = new ArrayList<>(this.rank);
        tmpRank.set(file, piece);
        return new Rank(tmpRank);

        // 아래와 같이 하면 file에 해당하는 모든 기물 변경됨
        // 위처럼 복사를 한 뒤 변경하고 반환해야함
//        rank.set(file, piece);
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
