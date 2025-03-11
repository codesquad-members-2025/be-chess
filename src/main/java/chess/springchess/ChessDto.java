package chess.springchess;

import chess.pieces.Piece;

public class ChessDto {
    public static class initGameDto {
        private String board;

        public initGameDto(String board) {
            this.board = board;
        }

        public String getBoard() {
            return board;
        }
    }

    public static class movePieceDto {
        private String startPos;
        private String endPos;

        public movePieceDto(String startPos, String endPos) {
            this.startPos = startPos;
            this.endPos = endPos;
        }

        public String getStartPos() {
            return startPos;
        }

        public String getEndPos() {
            return endPos;
        }
    }
}