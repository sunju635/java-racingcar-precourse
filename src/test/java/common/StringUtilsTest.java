package common;

import common.utils.StringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"test ", " test ", "t est", " t e s t "})
    void 문자열_공백_제거(String input) {
        assertThat(StringUtils.removeEmptyText(input)).doesNotContain(" "); //공백 제거 확인
    }
}
