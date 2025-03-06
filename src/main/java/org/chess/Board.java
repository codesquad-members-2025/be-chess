package org.chess;

import org.pieces.Piece;

import java.util.*;

import static org.utils.StringUtils.appendNewLine;

public class Board {
    private final List<Rank> rankList = new ArrayList<>();

    public Board() {
    }

    public void initialize() {
        List<Piece> rank1 = new ArrayList<>();
        rank1.add(Piece.createBlackRook());
        rank1.add(Piece.createBlackKnight());
        rank1.add(Piece.createBlackBishop());
        rank1.add(Piece.createBlackQueen());
        rank1.add(Piece.createBlackKing());
        rank1.add(Piece.createBlackBishop());
        rank1.add(Piece.createBlackKnight());
        rank1.add(Piece.createBlackRook());

        List<Piece> rank2 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Piece piece = Piece.createBlackPawn();
            rank2.add(piece);
        }

        List<Piece> rank7 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Piece piece = Piece.createWhitePawn();
            rank7.add(piece);
        }

        List<Piece> rank8 = new ArrayList<>();
        rank8.add(Piece.createWhiteRook());
        rank8.add(Piece.createWhiteKnight());
        rank8.add(Piece.createWhiteBishop());
        rank8.add(Piece.createWhiteQueen());
        rank8.add(Piece.createWhiteKing());
        rank8.add(Piece.createWhiteBishop());
        rank8.add(Piece.createWhiteKnight());
        rank8.add(Piece.createWhiteRook());

        rankList.add(new Rank(rank1));
        rankList.add(new Rank(rank2));
        for (int i = 0; i < 4; i++) {
            rankList.add(new Rank());
        }
        rankList.add(new Rank(rank7));
        rankList.add(new Rank(rank8));
    }

    public int pieceCount() {
        int count = 0;
        for (Rank rank : rankList) {
            count += rank.getTotalPieceCount();
        }
        return count;
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : rankList) {
            sb.append(appendNewLine(rank.print()));
        }
        return sb.toString();
    }

    public int getPieceCount(Piece.Color color, Piece.Type type) {
        int count = 0;
        for (Rank rank : rankList) {
            count += rank.getPieceCount(color, type);
        }
        return count;
    }
}
