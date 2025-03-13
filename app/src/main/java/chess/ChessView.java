package chess;

import static utils.StringUtils.appendNewLine;

public class ChessView {
    private final Board board;
    private final int RANK_SIZE = 8;

    public ChessView(Board board) {
        this.board = board;
    }

    public String showBoard(){
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < RANK_SIZE; i++) {

            answer.append(board.getPieces().get(i).toString()).append("    ").append(appendNewLine(""+ (RANK_SIZE-i)));
        }

        answer.append(appendNewLine(""));

        for (int i = 97; i < 105; i++){
            String position = "" + (char) (i);
            answer.append(position + " ");
        }

        return answer.toString();
    }
}
