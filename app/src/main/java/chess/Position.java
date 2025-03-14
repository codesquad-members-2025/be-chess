package chess;

public class Position {
    private final int row;
    private final int col;

    //문자열 이용
    public Position(String position) { //a8
        this.col = position.charAt(0) - 'a'; //a->0, b -> 1, ...
        this.row = Character.getNumericValue(position.charAt(1)) - 1; //출력에서 뒤집어주기
    }

    //int값 이용 - isPathClear에 필요
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        char colChar = (char) ('a' + col); // 0 → 'a', 1 → 'b', ...
        int rowNum = row + 1; // 0-based index → 1-based
        return String.valueOf(colChar) + rowNum;
    }
}
