package org.chess;

import static org.utils.StringUtils.appendNewLine;

public class ChessView {
    private final Board board;

    public ChessView(Board board){
        this.board = board;
    }

    public String showBoard() {
        // 중요!
        // rankList는 rank에 따라 관리
        // 즉 rankList.get(0)을 하면 rank1번이 나오도록 관리함
        // 따라서 출력할 때 rank8부터 출력하도록 변경하면 됨
        StringBuilder sb = new StringBuilder();
        for (int i = board.getRankList().size() - 1; i >= 0; i--) {
            sb.append(appendNewLine(board.getRankList().get(i).print()));
        }
        return sb.toString();
    }
}
