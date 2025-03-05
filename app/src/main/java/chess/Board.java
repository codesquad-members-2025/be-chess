package chess;

import pieces.Piece;
import utils.StringUtils;
import java.util.*;

public class Board {
    private List<Piece> pieces = new ArrayList<>();
    public final static int MAX_ROW = 8;
    public final static int MAX_CAL = 8;
    private Object[][] board = new Object[MAX_ROW][MAX_CAL];

    public void add(Piece piece) {
        pieces.add(piece);
    }

    public int size(){
        return pieces.size();
    }

    public void initialize(){
        for (int i = 0; i < MAX_ROW; i++) {
            for (int j = 0; j < MAX_CAL; j++) {
//                board[i][j] = SetUpBoard(i);
            }
        }
    }

    public void pieceCount(){

    }

//    private Object SetUpBoard(int i){
//        if ( i == 1 ) return new Piece(Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION);
//        if ( i == 6 ) return new Piece(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION);
//        return ".";
//    }

    public String getWhitePawnsResult(){
        return getPawnsResult(6);
    }

    public String getBlackPawnsResult(){
        return getPawnsResult(1);
    }

    private String getPawnsResult(int index){
        StringBuilder result = new StringBuilder();
        for (Object obj : board[index]) {
            result.append(((Piece)obj).getRepresentation());
        }
        return result.toString();
    }

    Piece findPawn(int num){
        return pieces.get(num);
    }

    public void print(){
        StringBuilder result = new StringBuilder();

        for (Object[] row : board) {
            for (Object obj : row) {
                if (obj instanceof Piece) {
                    result.append(((Piece)obj).getRepresentation());
                } else {
                    result.append(obj);
                }
            }
            result.append(StringUtils.NEWLINE);
        }
        System.out.println(result);
    }


}