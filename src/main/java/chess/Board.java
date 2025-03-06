package chess;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import chess.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Piece>> chessBoard;

    public Board() {
        chessBoard = new ArrayList<>();
    }

    public int pieceCount() {
        return (int) chessBoard.stream()
                .flatMap(List::stream)
                .filter(piece -> !piece.getName().equals(Type.NO_PIECE))
                .count();

    }

    public void initialize() {
        initializeEmptyBoard();
        addBlackPiecesToBoard();
        addBlackPawnToBoard();
        addWhitePawnToBoard();
        addWhitePiecesToBoard();

    }

    public String getPawnResult(Color color){
        StringBuilder sb = new StringBuilder();
        for (List<Piece> pieces : chessBoard) {
            for (Piece piece : pieces) {
                if (sb.length() == 8) break;
                if (piece.getColor().equals(color) && piece.getName().equals(Type.PAWN))
                    sb.append(piece.getName().getRepresentation(color));
            }
        }
        return sb.toString();
    }

    public void print() {
        System.out.println(showBoard());
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chessBoard.size(); i++) {
            for (int j = 0; j < chessBoard.get(i).size(); j++) {
                sb.append(chessBoard.get(i).get(j).getName().getRepresentation(chessBoard.get(i).get(j).getColor()));
            }
            sb.append(StringUtils.appendNewLine(""));
        }
        return sb.toString();
    }

    private void addWhitePiecesToBoard() {
        List<Piece> whitePieces = new ArrayList<>();
        whitePieces.add(Piece.createWhite(Type.ROOK));
        whitePieces.add(Piece.createWhite(Type.KNIGHT));
        whitePieces.add(Piece.createWhite(Type.BISHOP));
        whitePieces.add(Piece.createWhite(Type.QUEEN));
        whitePieces.add(Piece.createWhite(Type.KING));
        whitePieces.add(Piece.createWhite(Type.BISHOP));
        whitePieces.add(Piece.createWhite(Type.KNIGHT));
        whitePieces.add(Piece.createWhite(Type.ROOK));

        chessBoard.getLast().clear();
        chessBoard.getLast().addAll(whitePieces);
    }

    private void addBlackPiecesToBoard() {
        List<Piece> blackPieces = new ArrayList<>();
        blackPieces.add(Piece.createBlack(Type.ROOK));
        blackPieces.add(Piece.createBlack(Type.KNIGHT));
        blackPieces.add(Piece.createBlack(Type.BISHOP));
        blackPieces.add(Piece.createBlack(Type.QUEEN));
        blackPieces.add(Piece.createBlack(Type.KING));
        blackPieces.add(Piece.createBlack(Type.BISHOP));
        blackPieces.add(Piece.createBlack(Type.KNIGHT));
        blackPieces.add(Piece.createBlack(Type.ROOK));

        chessBoard.getFirst().clear();
        chessBoard.getFirst().addAll(blackPieces);
    }

    private void addBlackPawnToBoard() {
        List<Piece> blackPawns = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            blackPawns.add(Piece.createBlack(Type.PAWN));
        }
        chessBoard.get(1).clear();
        chessBoard.get(1).addAll(blackPawns);
    }
    private void addWhitePawnToBoard() {
        List<Piece> whitePawns = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            whitePawns.add(Piece.createWhite(Type.PAWN));
        }
        chessBoard.get(6).clear();
        chessBoard.get(6).addAll(whitePawns);
    }

    private void initializeEmptyBoard() {
        for (int i = 0; i < 8; i++) {
            List<Piece> emptyRank = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                emptyRank.add(Piece.createBlank());
            }
            chessBoard.add(emptyRank);
        }
    }
}
