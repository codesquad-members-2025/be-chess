package org.chess.domain.board;

import org.chess.domain.pieces.Piece;
import org.chess.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final int BOARD_SIZE = 8;
    private static final char EMPTY = '.';
    private static final int WHITE_MAIN_ROW = 7;
    private static final int WHITE_PAWN_ROW = 6;
    private static final int BLACK_MAIN_ROW = 0;
    private static final int BLACK_PAWN_ROW = 1;

    private final List<Rank> board;
    private final List<Piece> whitePieces;
    private final List<Piece> blackPieces;

    public Board() {
        this.board = new ArrayList<>();
        this.whitePieces = new ArrayList<>();
        this.blackPieces = new ArrayList<>();
    }

    public void initialize() {
        setupPieces();
        initializeEmptyBoard();
        placePiecesOnBoard();
    }

    private void setupPieces() {
        blackPieces.addAll(List.of(
                Piece.createBlack(Piece.Type.ROOK), Piece.createBlack(Piece.Type.KNIGHT), Piece.createBlack(Piece.Type.BISHOP),
                Piece.createBlack(Piece.Type.QUEEN), Piece.createBlack(Piece.Type.KING), Piece.createBlack(Piece.Type.BISHOP),
                Piece.createBlack(Piece.Type.KNIGHT), Piece.createBlack(Piece.Type.ROOK)
        ));

        for (int i = 0; i < BOARD_SIZE; i++) {
            whitePieces.add(Piece.createWhite(Piece.Type.PAWN));
            blackPieces.add(Piece.createBlack(Piece.Type.PAWN));
        }

        whitePieces.addAll(List.of(
                Piece.createWhite(Piece.Type.ROOK), Piece.createWhite(Piece.Type.KNIGHT), Piece.createWhite(Piece.Type.BISHOP),
                Piece.createWhite(Piece.Type.QUEEN), Piece.createWhite(Piece.Type.KING), Piece.createWhite(Piece.Type.BISHOP),
                Piece.createWhite(Piece.Type.KNIGHT), Piece.createWhite(Piece.Type.ROOK)
        ));

    }

    public void initializeEmptyBoard() {
        List<Piece> emptyPieces = new ArrayList<>();
        for (int i = 0; i < BOARD_SIZE; i++) {
            emptyPieces.add(Piece.createBlankPiece());
        }

        for (int i = 0; i < BOARD_SIZE; i++) {
            board.add(Rank.of(emptyPieces));
        }
    }

    private void placePiecesOnBoard() {
        board.set(WHITE_PAWN_ROW, Rank.of(whitePieces.subList(0, 8)));
        board.set(WHITE_MAIN_ROW, Rank.of(whitePieces.subList(8, 16)));
        board.set(BLACK_MAIN_ROW, Rank.of(blackPieces.subList(0, 8)));
        board.set(BLACK_PAWN_ROW, Rank.of(blackPieces.subList(8, 16)));
    }

    public void print() {
        System.out.println(showBoard());
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : board) {
            sb.append(rank).append(StringUtils.NEWLINE);
        }
        return sb.toString();
    }

    public void add(Piece piece) {
        whitePieces.add(piece);
    }

    public int pieceCount() {
        return whitePieces.size() + blackPieces.size();
    }

    public Piece findPawn(int index) {
        return whitePieces.get(index);
    }

    public String getPawnsResultWith(int row) {
        return board.get(row).toString();
    }

}