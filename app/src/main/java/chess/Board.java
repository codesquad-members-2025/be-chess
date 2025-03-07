package chess;

import chess.pieces.Piece;
import chess.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static chess.pieces.Piece.Type.*;

public class Board {
    private static final int WHITE_PAWN_RANK = 6;
    private static final int BLACK_PAWN_RANK = 1;
    private static final int MAX_PAWN_SIZE = 16;
    private static final int MIN_PIECE_INDEX = 0;
    private static final int MAX_PIECE_INDEX = 31;
    private static final int MAX_PIECE_SIZE = 32;
    private static final int FILE_SIZE = 8;
    private static final int RANK_SIZE = 8;
    private final List<Piece> pieces = new ArrayList<>();
    private final char[][] board = new char[RANK_SIZE][FILE_SIZE];
    public void initialize() {
        addPieces();
        initializeEmptyBoard();
        initializeBoard();
    }

    private void initializeBoard() {
        for (int file = 0; file < FILE_SIZE; file++) {
            board[BLACK_PAWN_RANK][file] = pieces.get(file*2+1).getRepresentation();
            board[WHITE_PAWN_RANK][file] = pieces.get(file*2).getRepresentation();
        }
        int temp = 7;
        int cnt = MAX_PAWN_SIZE;
        for (int file = 0; file < 3; file++) {
            board[0][file] = pieces.get(cnt++).getRepresentation();
            board[0][temp - file] = pieces.get(cnt++).getRepresentation();
            board[7][file] = pieces.get(cnt++).getRepresentation();
            board[7][temp - file] = pieces.get(cnt++).getRepresentation();
        }

            board[0][3] = pieces.get(cnt++).getRepresentation();
            board[0][4] = pieces.get(cnt++).getRepresentation();
            board[7][3] = pieces.get(cnt++).getRepresentation();
            board[7][4] = pieces.get(cnt).getRepresentation();
    }

    private void initializeEmptyBoard() {
        for (int rank = 0; rank < RANK_SIZE; rank++) {
            board[rank] = "........".toCharArray();
        }
    }

    private void addPieces() {
        for (int i = 0; i < 8; i++) { // 폰
            add(Piece.createWhite(PAWN));
            add(Piece.createBlack(PAWN));
        }

        add(Piece.createBlack(ROOK));
        add(Piece.createBlack(ROOK));
        add(Piece.createWhite(ROOK));
        add(Piece.createWhite(ROOK));

        add(Piece.createBlack(KNIGHT));
        add(Piece.createBlack(KNIGHT));
        add(Piece.createWhite(KNIGHT));
        add(Piece.createWhite(KNIGHT));

        add(Piece.createBlack(BISHOP));
        add(Piece.createBlack(BISHOP));
        add(Piece.createWhite(BISHOP));
        add(Piece.createWhite(BISHOP));

        add(Piece.createBlack(QUEEN));
        add(Piece.createBlack(KING));
        add(Piece.createWhite(QUEEN));
        add(Piece.createWhite(KING));

    }

    public void add(Piece piece) {
        validatePieceSize();
        pieces.add(piece);
    }
    public int pieceCount() {
        return pieces.size();
    }

    public Piece findPiece(int index) {
        validateIndex(index);
        return pieces.get(index);
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int rank = 0; rank < RANK_SIZE; rank++) {
            for (int file = 0; file < FILE_SIZE; file++) {
                sb.append(board[rank][file]);
            }
            sb = new StringBuilder(StringUtils.appendNewLine(sb.toString()));
        }
        return sb.toString();
    }

    private void validatePieceSize() {
        if (pieces.size() > MAX_PIECE_SIZE) {
            throw new IllegalStateException("폰은 " + MAX_PIECE_SIZE + "개를 초과할 수 없습니다.");
        }
    }

    private void validateIndex(int index) {
        if(MIN_PIECE_INDEX> index || index > MAX_PIECE_INDEX){
            throw new IllegalStateException(index + "번의 폰은 없습니다. " + MIN_PIECE_INDEX + "부터 " + MAX_PIECE_INDEX + " 중 골라주세요.");
        }
    }
}

