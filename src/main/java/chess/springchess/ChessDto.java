package chess.springchess;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import java.util.List;

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
        private Piece movePiece;

        public movePieceDto(String startPos, String endPos, Piece movePiece) {
            this.startPos = startPos;
            this.endPos = endPos;
            this.movePiece = movePiece;
        }

        public String getStartPos() {
            return startPos;
        }

        public String getEndPos() {
            return endPos;
        }

        public Piece getMovePiece() {
            return movePiece;
        }
    }
    public static class movePieceRequestDto {
        private String startPos;
        private String endPos;
        public movePieceRequestDto(String startPos, String endPos) {
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