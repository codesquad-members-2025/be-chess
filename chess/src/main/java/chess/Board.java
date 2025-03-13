package chess;

import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.NEWLINE;

public class Board {
    private final ArrayList<Piece> boardList = new ArrayList<>();
    private final  ArrayList<Piece> whitePawns = new ArrayList<>();
    private final ArrayList<Piece> blackPawns = new ArrayList<>();

    private final ArrayList<Piece> whitePieces = new ArrayList<>();
    private final ArrayList<Piece> blackPieces = new ArrayList<>();

    private final ArrayList<Piece> blankPieces = new ArrayList<>();
    private static final int BOARD_SIZE = 8; // 캡슐화 및 OOP 준수를 위해 private 적용
    //char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
    //보드 자료구선 개선
    private ArrayList<Rank> board = new ArrayList<>();

    public void add(Piece pawn) {
        boardList.add(pawn);
    }

    public int size() {
        return boardList.size();
    }

    // 인덱스를 사용하여 Pawn 객체 찾기
    public Piece findPawn(int idx) {
        if (isValidIndex(idx)) {
            return boardList.get(idx);
        }
        return null;
    }

    //유효성 검사
    private boolean isValidIndex(int idx) {
        return idx >= 0 && idx < boardList.size();
    }

    public void initializePawns() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            whitePawns.add(new Piece(Piece.Color.WHITE, Piece.Type.PAWN));
            blackPawns.add(new Piece(Piece.Color.BLACK, Piece.Type.PAWN));
            blankPieces.add(new Piece(Piece.Color.NOCOLOR, Piece.Type.NO_PIECE));
        }

        whitePieces.add(new Piece(Piece.Color.WHITE, Piece.Type.ROOK));
        whitePieces.add(new Piece(Piece.Color.WHITE, Piece.Type.KNIGHT));
        whitePieces.add(new Piece(Piece.Color.WHITE, Piece.Type.BISHOP));
        whitePieces.add(new Piece(Piece.Color.WHITE, Piece.Type.QUEEN));
        whitePieces.add(new Piece(Piece.Color.WHITE, Piece.Type.KING));
        whitePieces.add(new Piece(Piece.Color.WHITE, Piece.Type.BISHOP));
        whitePieces.add(new Piece(Piece.Color.WHITE, Piece.Type.KNIGHT));
        whitePieces.add(new Piece(Piece.Color.WHITE, Piece.Type.ROOK));


        blackPieces.add(new Piece(Piece.Color.BLACK, Piece.Type.ROOK));
        blackPieces.add(new Piece(Piece.Color.BLACK, Piece.Type.KNIGHT));
        blackPieces.add(new Piece(Piece.Color.BLACK, Piece.Type.BISHOP));
        blackPieces.add(new Piece(Piece.Color.BLACK, Piece.Type.QUEEN));
        blackPieces.add(new Piece(Piece.Color.BLACK, Piece.Type.KING));
        blackPieces.add(new Piece(Piece.Color.BLACK, Piece.Type.BISHOP));
        blackPieces.add(new Piece(Piece.Color.BLACK, Piece.Type.KNIGHT));
        blackPieces.add(new Piece(Piece.Color.BLACK, Piece.Type.ROOK));
    }

    public void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if(i == 0) board.add(new Rank(blackPieces));
            else if(i == 1) board.add(new Rank(blackPawns));
            else if(i == 6) board.add(new Rank(whitePawns));
            else if(i == 7) board.add(new Rank(whitePieces));
            else board.add(new Rank(blankPieces));
        }
    }
    //initializeBoard()의 중복 리펙토링
    /*
    public char getPawnRepresentation(int row, int col) {
        if (row == 1) return blackPawns.get(col).getRepresentation();
        if (row == 6) return whitePawns.get(col).getRepresentation();
        if (row == 0) return blackPieces.get(col).getRepresentation();
        if (row == 7) return whitePieces.get(col).getRepresentation();

        return '.';
    }
     */

    //폰의 리스트의 값들을 StringBuilder로 변환해줌
    public String getPawnsResult(List<Piece> pawns) {
        StringBuilder sb = new StringBuilder();
        for (Piece pawn : pawns) {
            sb.append(pawn.getRepresentation());
        }
        return sb.toString();
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(blackPawns);
    }

    //체스판의 결과를 출력
    public String print() {
        StringBuilder board_sb = new StringBuilder();
        for (int i = 0; i < BOARD_SIZE; i++) {
            board_sb.append(board.get(i)).append("\n");
        }

        return board_sb.toString();
    }

    public int pieceCount() {
        int cnt = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if(board.get(i).getPiece(j).getRepresentation() == '.') cnt++;
            }
        }
        return cnt;
    }

    public String showBoard() {
        StringBuilder boardSb = new StringBuilder();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                boardSb.append(board.get(i).getPiece(j).getRepresentation());
            }
            boardSb.append(NEWLINE);
        }
        return boardSb.toString();
    }

    public int getPiecesCnt(Piece.Color color, Piece.Type type){
        int cnt = 0;
        for(int i = 0; i<BOARD_SIZE; i++){
            for(int j = 0; j<BOARD_SIZE; j++){
                Piece piece = board.get(i).getPiece(j);
                if (piece.getType().equals(type) && piece.getColor().equals(color)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }


    public Piece findPiece(String position) {
        char x = position.charAt(0);
        int xPos = x - 'a';

        char y = position.charAt(1);
        int yPos = Character.getNumericValue(y)-1;

        return board.get(7-yPos).getPiece(xPos);
    }

    public void initializeEmpty() {
        board = new ArrayList<>();
        for(int i = 0; i<BOARD_SIZE; i++){
            board.add(new Rank(blankPieces));
        }
    }

    public void move(String position, Piece piece) {
        Position pos = new Position(position);
        board.get(pos.getY()).setPiece(pos.getX(), piece);

    }
}