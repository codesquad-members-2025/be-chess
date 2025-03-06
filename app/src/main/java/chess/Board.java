package chess;

import chess.pieces.Piece;
import chess.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static chess.pieces.Piece.*;

public class Board {
    private static final int WHITE_PAWN_RANK = 6;
    private static final int BLACK_PAWN_RANK = 1;
    private static final int MIN_PAWN_INDEX = 0;
    private static final int MAX_PAWN_INDEX = 15;
    private static final int MAX_PAWN_SIZE = 16;
    private static final int FILE_SIZE = 8;
    private static final int RANK_SIZE = 8;
    private final List<Piece> pieces = new ArrayList<>();
    private final char[][] board = new char[RANK_SIZE][FILE_SIZE];
    /*public void initialize() {
        addPawns();
        initializeEmptyBoard();
        initializeBoard();
    }*/

    private void initializeBoard() {
        for (int file = 0; file < FILE_SIZE; file++) {
            board[BLACK_PAWN_RANK][file] = pieces.get(file*2+1).getRepresentation();
            board[WHITE_PAWN_RANK][file] = pieces.get(file*2).getRepresentation();
        }
    }

    private void initializeEmptyBoard() {
        for (int rank = 0; rank < RANK_SIZE; rank++) {
            board[rank] = "........".toCharArray();
        }
    }

/*    private void addPawns() {
        for (int i = 0; i < 8; i++) {
            pieces.add(new Piece()); // 백
            pieces.add(new Piece(BLACK_COLOR)); // 흑
        }
    }*/

    public void add(Piece piece) {
        validatePawnSize();
        pieces.add(piece);
    }
    public int size() {
        return pieces.size();
    }

    public Piece findPawn(int index) {
        validateIndex(index);
        return pieces.get(index);
    }

    public String getWhitePawnsResult() {
        return getResult(WHITE_PAWN_RANK);
    }
    public String getBlackPawnsResult() {
        return getResult(BLACK_PAWN_RANK);
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int rank = 0; rank < RANK_SIZE; rank++) {
            for (int file = 0; file < FILE_SIZE; file++) {
                sb.append(board[rank][file]);
            }
            sb = new StringBuilder(StringUtils.appendNewLine(sb.toString()));
        }
        return sb.toString();
    }

    private String getResult(int rank) {
        StringBuilder sb = new StringBuilder();
        for (int file = 0; file < FILE_SIZE; file++) {
            sb.append(board[rank][file]);
        }
        return sb.toString();
    }

    private void validatePawnSize() {
        if (pieces.size() > MAX_PAWN_SIZE) {
            throw new IllegalStateException("폰은 " + MAX_PAWN_SIZE + "개를 초과할 수 없습니다.");
        }
    }

    private void validateIndex(int index) {
        if(MIN_PAWN_INDEX> index || index > MAX_PAWN_INDEX){
            throw new IllegalStateException(index + "번의 폰은 없습니다. " + MIN_PAWN_INDEX + "부터 " + MAX_PAWN_INDEX + " 중 골라주세요.");
        }
    }
}

