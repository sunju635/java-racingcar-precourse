package racinggame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.exception.GameErrorCode;
import racinggame.exception.GameException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {
    Car car;

    @ParameterizedTest
    @ValueSource(strings = {""})
    void Car_이름_분리_EMPTY_실패(String input) {
        assertThatExceptionOfType(GameException.class).isThrownBy(
                () -> {
                    car = new Car(input);
                }
        ).withMessageContaining(GameErrorCode.CAR_NAME_EMPTY_ERROR.getErrorMessage());

    }

    @ParameterizedTest
    @ValueSource(strings = {"test12"})
    void Car_이름_분리_길이_실패(String input) {
        assertThatExceptionOfType(GameException.class).isThrownBy(
                () -> {
                    car = new Car(input);
                }
        ).withMessageContaining(GameErrorCode.CAR_NAME_LENGTH_ERROR.getErrorMessage());
    }
}
