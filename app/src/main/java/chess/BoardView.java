package chess;

import static utils.StringUtils.appendNewLine;

public class BoardView {
    private final Board board;

    public BoardView(Board board) {
        this.board = board;
    }

    //showGame 클래스로 분리
    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            sb.append(appendNewLine(board.getRank(i).print()));
        }
        return sb.toString();
    }



}
