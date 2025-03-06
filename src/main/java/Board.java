import pieces.Pawn;
import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final char[][] board = new char[8][8];

//    public void startGame() {
//        List<Pawn> whitePawnList = makeWhitePawnList();
//        List<Pawn> blackPawnList = makeBlackPawnList();
//        initialize(whitePawnList, blackPawnList);
//    }

    // 처음에 시작하면, 흰색 폰을 8개 생성해서 List 에 넣고, 검은색 폰을 8개 생성해서 List 에 넣고
    private void initialize() {
        StringBuilder builder = new StringBuilder();
        List<Pawn> whitePawnList = makeWhitePawnList();
        List<Pawn> blackPawnList = makeBlackPawnList();


        print(board);
    }

    private void print(StringBuilder builder) {

    }

    public String getWhitePawnResult() {
        StringBuilder builder = new StringBuilder();
        int whitePawnIndex = 6;


    }

    public String getBlackPawnResult() {
        StringBuilder builder = new StringBuilder();
        int blackPawnIndex = 1;
        for (int i = 0; i < 8; i++) {

        }

    }

    private List<Pawn> makeWhitePawnList() {
        List<Pawn> whitePawnList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            whitePawnList.add(new Pawn());
        }
        return whitePawnList;
    }

    private List<Pawn> makeBlackPawnList() {
        List<Pawn> blackPawnList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            blackPawnList.add(new Pawn(Pawn.COLOR_BLACK, Pawn.REPRESENTATION_BLACK));
        }
        return blackPawnList;
    }

//    public void add(Piece piece) {
//        board.add(piece);
//    }

//    public int size() {
//        return board.size();
//    }
//
//    // count 번째로 들어가 있는 Pawn 의 색 반환
//    public String findPawn(int index) {
//        String answer = "";
//        int count = 0;
//        while (count <= index) {
//            for (Piece piece : board) {
//                if (piece instanceof Pawn) {
//                    answer = piece.getColor();
//                    count++;
//                }
//            }
//        }
//        return answer;
//    }
}
