package chess.springchess;

public class ChessDto {
    public static class initGameDto{
        private String board;

        public initGameDto(String board) {
            this.board = board;
        }

        public String getBoard() {
            return board;
        }
    }
}
