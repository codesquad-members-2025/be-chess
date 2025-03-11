package chess.springchess;

import chess.springchess.ChessDto.initGameDto;
import chess.springchess.ChessDto.movePieceDto;

public class ChessConverter {
    public static ChessDto.initGameDto createInitGameDto(String board) {
        return new initGameDto(board);
    }

    public static movePieceDto createmovePieceDto(String startPos, String endPos) {
        return new movePieceDto(startPos, endPos);
    }
}
