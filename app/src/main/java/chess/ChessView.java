package chess;

import static utils.StringUtils.appendNewLine;

public class ChessView {
    private final Board board;
    public ChessView(Board board) {
        this.board = board;
    }

    public void showBoard(){
        StringBuilder answer = new StringBuilder();

        for (Rank rank : board.getPieces()){
            answer.append(appendNewLine(rank.toString()));
        }

        System.out.println(answer);
    }
}
