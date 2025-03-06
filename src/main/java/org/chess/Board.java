package org.chess;

import org.pieces.Piece;

import java.util.*;

import static org.utils.StringUtils.appendNewLine;

public class Board {
    private List<Piece> whitePieceList = new ArrayList<>();
    private List<Piece> blackPieceList = new ArrayList<>();
    private List<Piece> whitePawnList = new ArrayList<>();
    private List<Piece> blackPawnList = new ArrayList<>();

    public Board() {
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            Piece piece = Piece.createWhitePawn();
            whitePawnList.add(piece);
        }
        for (int i = 0; i < 8; i++) {
            Piece piece = Piece.createBlackPawn();
            blackPawnList.add(piece);
        }
        whitePieceList.add(Piece.createWhiteRook());
        whitePieceList.add(Piece.createWhiteKnight());
        whitePieceList.add(Piece.createWhiteBishop());
        whitePieceList.add(Piece.createWhiteQueen());
        whitePieceList.add(Piece.createWhiteKing());
        whitePieceList.add(Piece.createWhiteBishop());
        whitePieceList.add(Piece.createWhiteKnight());
        whitePieceList.add(Piece.createWhiteRook());

        blackPieceList.add(Piece.createBlackRook());
        blackPieceList.add(Piece.createBlackKnight());
        blackPieceList.add(Piece.createBlackBishop());
        blackPieceList.add(Piece.createBlackQueen());
        blackPieceList.add(Piece.createBlackKing());
        blackPieceList.add(Piece.createBlackBishop());
        blackPieceList.add(Piece.createBlackKnight());
        blackPieceList.add(Piece.createBlackRook());
    }

    public int pieceCount() {
        return blackPieceList.size() + blackPawnList.size() + whitePieceList.size() + whitePawnList.size();
    }

    public String getPawnsResult(List<Piece> pawnList) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : pawnList) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }

    public String getBlankLine() {
        return "........";
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        String blank = appendNewLine(getBlankLine());
        for (Piece piece : blackPieceList) {
            sb.append(piece.getRepresentation());
        }
        sb.append(appendNewLine(""));
        for (Piece piece : blackPawnList) {
            sb.append(piece.getRepresentation());
        }
        sb.append(appendNewLine(""));

        for (int i = 0; i < 4; i++) {
            sb.append(blank);
        }

        for (Piece piece : whitePawnList) {
            sb.append(piece.getRepresentation());
        }
        sb.append(appendNewLine(""));
        for (Piece piece : whitePieceList) {
            sb.append(piece.getRepresentation());
        }
        sb.append(appendNewLine(""));
        return sb.toString();
    }
}
