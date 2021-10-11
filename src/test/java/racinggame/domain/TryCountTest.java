package racinggame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.exception.GameErrorCode;
import racinggame.exception.GameException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class TryCountTest {
    TryCount tryCount;

    @ParameterizedTest
    @ValueSource(strings = {"1", "5"})
    void 성공(String input) throws GameException{
        tryCount = new TryCount(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 빈_문자열_실패(String input) {
        assertThatExceptionOfType(GameException.class).isThrownBy(
                () -> {
                    tryCount = new TryCount(input);
                }
        ).withMessageContaining(GameErrorCode.TRY_COUNT_EMPTY_ERROR.getErrorMessage());

    }

    @ParameterizedTest
    @ValueSource(strings = {"one", "한번"})
    void 숫자_포멧_실패(String input) {
        assertThatExceptionOfType(GameException.class).isThrownBy(
                () -> {
                    tryCount = new TryCount(input);
                }
        ).withMessageContaining(GameErrorCode.TRY_COUNT_FORMAT_ERROR.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    void 최소값_만족_실패(String input) {
        assertThatExceptionOfType(GameException.class).isThrownBy(
                () -> {
                    tryCount = new TryCount(input);
                }
        ).withMessageContaining(GameErrorCode.TRY_COUNT_MIN_ERROR.getErrorMessage());
    }
}
