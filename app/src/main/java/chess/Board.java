package chess;

import chess.pieces.Piece;
import chess.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static chess.pieces.Piece.*;

public class Board {
    private static final int MIN_PIECE_INDEX = 0;
    private static final int MAX_PIECE_INDEX = 31;
    private static final int MAX_PIECE_SIZE = 32;
    private static final int FILE_SIZE = 8;
    public static final int RANK_SIZE = 8;
    private final List<Piece> pieces = new ArrayList<>();
    private final List<Rank> board = new ArrayList<>();


    public void initialize() {
        addPieces();
        initializeBoard();
    }

    public int pieceCount() {
        return pieces.size();
    }

    public int getSpecificPieceCount(Type type, Color color) {
        int count = 0;
        for (Rank rank : board) {
            for (int file = 0; file < FILE_SIZE; file++) {
                Piece piece = rank.getPiece(file);
                if (piece.getColor().equals(color) && piece.getType().equals(type)) {
                    count++;
                }
            }
        }
        return count;
    }
    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int rank = 0; rank < RANK_SIZE; rank++) {
            sb.append(StringUtils.appendNewLine(board.get(rank).toString()));
        }
        return sb.toString();
    }

    private void initializeBoard() {

        board.add(new Rank(createInitialEightRank()));
        board.add(new Rank(createInitialSevenRank()));
        for (int rank = 6; rank > 2; rank--) { // 6~3 랭크
            board.add(new Rank(createEmptyRank()));
        }
        board.add(new Rank(createInitialTwoRank()));
        board.add(new Rank(createInitialOneRank()));

    }


    private List<Piece> createInitialSevenRank() {
        List<Piece> initialSevenRank = new ArrayList<>();
        for (int file = 0; file < FILE_SIZE; file++) {
            initialSevenRank.add(pieces.get(file));
        }
        return initialSevenRank;
    }

    private List<Piece> createInitialEightRank() {
        List<Piece> initialEightRank = new ArrayList<>();
        for (int file = 0; file < FILE_SIZE; file++) {
            initialEightRank.add(pieces.get(8+file));
        }
        return initialEightRank;
    }
    private List<Piece> createInitialTwoRank() {
        List<Piece> initialTwoRank = new ArrayList<>();
        for (int file = 0; file < FILE_SIZE; file++) {
            initialTwoRank.add(pieces.get(24 + file));
        }
        return initialTwoRank;
    }

    private List<Piece> createInitialOneRank() {
        List<Piece> initialOneRank = new ArrayList<>();
        for (int file = 0; file < FILE_SIZE; file++) {
            initialOneRank.add(pieces.get(16 + file));
        }
        return initialOneRank;
    }
    private List<Piece> createEmptyRank() {
        Piece blank = createBlank();
        List<Piece> emptyRank = new ArrayList<>();
        for (int file = 0; file < FILE_SIZE; file++) {
            emptyRank.add(blank);
        }
        return emptyRank;
    }

    private void addPieces() {
        for (int i = 0; i < 8; i++) { // 폰
            add(createBlackPawn());
        }

        add(createBlackRook());
        add(createBlackKnight());
        add(createBlackBishop());
        add(createBlackQueen());
        add(createBlackKing());
        add(createBlackBishop());
        add(createBlackKnight());
        add(createBlackRook());

        add(createWhiteRook());
        add(createWhiteKnight());
        add(createWhiteBishop());
        add(createWhiteQueen());
        add(createWhiteKing());
        add(createWhiteBishop());
        add(createWhiteKnight());
        add(createWhiteRook());

        for (int i = 0; i < 8; i++) { // 폰
            add(createWhitePawn());
        }
    }

    private void add(Piece piece) {
        validatePieceSize();
        pieces.add(piece);
    }


    public Piece findPiece(int index) {
        validateIndex(index);
        return pieces.get(index);
    }

    private void validateFileSize(int size) {
        if (size > FILE_SIZE) {
            throw new IllegalStateException("사이즈는 "+FILE_SIZE +"를 넘을 수 없습니다. 현재 사이즈: " + size);
        }
    }
    private void validateRankSize(int size) {
        if (size > RANK_SIZE) {
            throw new IllegalStateException("사이즈는 "+FILE_SIZE +"를 넘을 수 없습니다. 현재 사이즈: " + size);
        }
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
