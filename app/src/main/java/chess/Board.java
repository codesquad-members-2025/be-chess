package chess;

import pieces.Piece;

import java.util.*;

import static utils.StringUtils.appendNewLine;

public class Board {
    private List<Piece> pieces = new ArrayList<>();
    public final static int MAX_ROW = 8;
    public final static int MAX_CAL = 8;
    private Object[][] board = new Object[MAX_ROW][MAX_CAL];
    private int pieceNum = 0;

//    public void initialize(){
//        addBlackPieces();
//        addBlackPawns();
//        addBlankLanks();
//        addWhitePawns();
//        addWhitePieces();
//    }

//    public void addBlackPieces(){
//        Object[] indexZero = board[0];
//        indexZero[0] = Piece.createBlackRook();
//        indexZero[1] = Piece.createBlackKnight();
//        indexZero[2] = Piece.createBlackBishop();
//        indexZero[3] = Piece.createBlackQueen();
//        indexZero[4] = Piece.createBlackKing();
//        indexZero[5] = Piece.createBlackBishop();
//        indexZero[6] = Piece.createBlackKnight();
//        indexZero[7] = Piece.createBlackRook();
//        pieceNum+=8;
//    }
//
//    public void addBlackPawns(){
//        Object[] indexZero = board[1];
//        for(int i = 0; i < MAX_CAL; i++){
//            indexZero[i] = Piece.createBlackPawn();
//            pieceNum++;
//        }
//    }
//
//    public void addBlankLanks(){
//        for (int i = 2; i < 6; i++){
//            for (int j = 0; j < MAX_CAL; j++){
//                board[i][j] = '.';
//            }
//        }
//    }
//
//    public void addWhitePawns(){
//        Object[] indexZero = board[6];
//        for(int i = 0; i < MAX_CAL; i++){
//            indexZero[i] = Piece.createWhitePawn();
//            pieceNum++;
//        }
//    }
//
//    public void addWhitePieces(){
//        Object[] indexZero = board[7];
//        indexZero[0] = Piece.createWhiteRook();
//        indexZero[1] = Piece.createWhiteKnight();
//        indexZero[2] = Piece.createWhiteBishop();
//        indexZero[3] = Piece.createWhiteQueen();
//        indexZero[4] = Piece.createWhiteKing();
//        indexZero[5] = Piece.createWhiteBishop();
//        indexZero[6] = Piece.createWhiteKnight();
//        indexZero[7] = Piece.createWhiteRook();
//        pieceNum+=8;
//    }
//
//    public int pieceCount(){
//        return pieceNum;
//    }
//
//    public String showBoard(){
//        StringBuilder answer = new StringBuilder();
//
//        for (Object[] row : board) {
//            String result = "";
//            for (Object obj : row) {
//                if (obj instanceof Piece) {
//                    result += ((Piece)obj).getRepresentation();
//                } else {
//                    result += obj;
//                }
//            }
//            answer.append(appendNewLine(result));
//        }
//        return answer.toString();
//    }


}