package utils;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {
    @Test
    public void appendNewLine() {
        String line = StringUtils.appendNewLine("hello");
        assertEquals("hello" + StringUtils.NEWLINE, line);
    }
}
