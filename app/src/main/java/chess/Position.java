package chess;

public class Position {
    private final int x;
    private final int y;

    public Position(String position) {
        int[] positionArr = convertStringToIntArr(position);
        validatePositionRange(positionArr);
        this.x = positionArr[0];
        this.y = positionArr[1];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int[] convertStringToIntArr(String position) {
        int xPos = position.charAt(0) - 'a';
        int yPos = Character.getNumericValue(position.charAt(1)-1) ;

        return new int[]{xPos, yPos};
    }

    private void validatePositionRange(int[] positionArr) {
        if (1 > positionArr[0] || positionArr[0] > 8) {
            throw new IllegalStateException("x 좌표값이 유효하지 않습니다. 1~8 사이의 좌표를 입력해주세요. 현재 입력 좌표값: " + positionArr[0]);
        }
        if (0 > positionArr[1] || positionArr[1] > 7) {
            throw new IllegalStateException("y 좌표값이 유효하지 않습니다. 1~8 사이의 좌표를 입력해주세요. 현재 입력 좌표값: " + positionArr[1]+1);
        }
    }
}
