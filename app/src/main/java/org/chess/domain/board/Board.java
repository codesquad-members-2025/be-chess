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

    private final char[][] board;
    private final List<Piece> whitePieces;
    private final List<Piece> blackPieces;

    public Board() {
        this.board = new char[BOARD_SIZE][BOARD_SIZE];
        this.whitePieces = new ArrayList<>();
        this.blackPieces = new ArrayList<>();
    }

    public void initialize() {
        setupPieces();
        initializeBoard();
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

    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private void placePiecesOnBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[BLACK_MAIN_ROW][i] = blackPieces.get(i).getType().getBlackType();
            board[BLACK_PAWN_ROW][i] = blackPieces.get(i + BOARD_SIZE).getType().getBlackType();
            board[WHITE_PAWN_ROW][i] = whitePieces.get(i).getType().getWhiteType();
            board[WHITE_MAIN_ROW][i] = whitePieces.get(i + BOARD_SIZE).getType().getWhiteType();
        }
    }

    public void print() {
        System.out.println(showBoard());
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : board) {
            sb.append(row).append(StringUtils.NEWLINE);
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
        return new String(board[row]);
    }

}