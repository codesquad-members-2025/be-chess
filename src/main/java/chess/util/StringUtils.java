package chess.util;

public class StringUtils {

    public static final String NEWLINE = System.lineSeparator();

    private StringUtils() {
        // 유틸 클래스는 생성자 호출 방지
    }

    public static String appendNewLine(String input) {
        return input + NEWLINE;
    }
}