package org.chess;

import org.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    private List<Piece> pieceList = new ArrayList<>();

    Rank() {
        for (int i = 0; i < 8; i++) {
            pieceList.add(Piece.createBlank());
        }
    }

    Rank(List<Piece> pieces) {
        pieceList = pieces;
    }

    int getTotalPieceCount() {
        int count = 0;
        for (Piece piece : pieceList) {
            if (piece.getType() != Piece.Type.NO_PIECE) count++;
        }
        return count;
    }

    String print() {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : pieceList) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }

    int getPieceCount(Piece.Color color, Piece.Type type) {
        int count = 0;
        for (Piece piece : pieceList) {
            if (piece.getColor() == color && piece.getType() == type) count++;
        }
        return count;
    }

    Piece getPieceByFileIndex(int index){
        return pieceList.get(index);
    }

    void putPieceByFileIndex(int index,Piece piece){
        pieceList.set(index,piece);
    }
}
