package chess;

import static utils.StringUtils.appendNewLine;

public class BoardView {
    private final Board board;

    public BoardView(Board board) {
        this.board = board;
    }

    //showGame 클래스로 분리
    //for 문 없이 rank8~1 출력하도록 수정해보기
    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            sb.append(appendNewLine(board.getRank(i).print()));
        }
        return sb.toString();
    }



}
