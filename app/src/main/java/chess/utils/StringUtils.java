package chess.utils;

public class StringUtils {
    public static final String NEWLINE = System.getProperty("line.separator");

    public static String appendNewLine(String s) {
        return s + NEWLINE;
    }

    private StringUtils() {}
}

