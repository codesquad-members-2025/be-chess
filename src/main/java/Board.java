import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<String> BOARD = new ArrayList<>();
    private final int WHITE_PAWN_INDEX = 6;
    private final int BLACK_PAWN_INDEX = 1;
    private final int BOARD_ROW_SIZE = 8;

    // BOARD 빈칸으로 초기화
    public Board() {
        String empty = "........";
        for (int i = 0; i < 8; i++) {
            BOARD.add(empty);
        }
    }

    // 처음에 시작하면, 흰색 폰을 8개 생성해서 List 에 넣고, 검은색 폰을 8개 생성해서 List 에 넣고
    public void initialize() {
        List<Pawn> whitePawnList = makeWhitePawnList();
        List<Pawn> blackPawnList = makeBlackPawnList();
        String whitePawnString = createPawnString(whitePawnList);
        String blackPawnString = createPawnString(blackPawnList);
        BOARD.set(WHITE_PAWN_INDEX, whitePawnString);
        BOARD.set(BLACK_PAWN_INDEX, blackPawnString);
        print();
    }

    private void print() {
        for (String line : BOARD) {
            System.out.println(line);
        }
    }

    // BOARD 에서 흰색 Pawn 줄 반환
    public String getWhitePawnResult() {
        return BOARD.get(WHITE_PAWN_INDEX);
    }

    // BOARD 에서 검은색 Pawn 줄 반환
    public String getBlackPawnResult() {
        return BOARD.get(BLACK_PAWN_INDEX);
    }

    // 흰색 Pawn 의 List 반환
    private List<Pawn> makeWhitePawnList() {
        List<Pawn> whitePawnList = new ArrayList<>();
        for (int i = 0; i < BOARD_ROW_SIZE; i++) {
            whitePawnList.add(new Pawn());
        }
        return whitePawnList;
    }

    // 검은색 Pawn 의 List 반환
    private List<Pawn> makeBlackPawnList() {
        List<Pawn> blackPawnList = new ArrayList<>();
        for (int i = 0; i < BOARD_ROW_SIZE; i++) {
            blackPawnList.add(new Pawn(Pawn.COLOR_BLACK, Pawn.REPRESENTATION_BLACK));
        }
        return blackPawnList;
    }

    // Pawn 의 List 의 내용을 StringBuilder 에 담고, String 으로 반환
    private String createPawnString(List<Pawn> pawnList) {
        StringBuilder builder = new StringBuilder();
        for (Pawn pawn : pawnList) {
            builder.append(pawn.getRepresentation());
        }
        return builder.toString();
    }
}
