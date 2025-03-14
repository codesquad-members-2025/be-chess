package utils;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {
    @Test
    @DisplayName("반복되는 줄바꿈 문자를 줄인다.")
    public void appendNewLine() {
        String line = StringUtils.appendNewLine("hello");
        assertThat("hello" + StringUtils.NEWLINE).isEqualTo(line);
    }
}
