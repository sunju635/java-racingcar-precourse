package racinggame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.exception.GameErrorCode;
import racinggame.exception.GameException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarsTest {
    Cars cars;

    @ParameterizedTest
    @ValueSource(strings = {"test1,test2", "test1", " test1, test2 "})
    void Car_이름_분리_성공(String input) {
        cars = new Cars(input);
        String[] array = input.split(",");

        assertThat(cars.size()).isEqualTo(array.length); //길이 확인

        for(int i = 0; i < cars.size(); i++) {
            assertThat(cars.get(i)).doesNotContain(" "); //공백 제거 확인
            assertThat(cars.get(i)).isEqualTo(array[i].replaceAll(" ", "")); //item 확인
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", ",", " , "})
    void Car_이름_분리_EMPTY_실패(String input) {
        assertThatExceptionOfType(GameException.class).isThrownBy(
                () -> {
                    cars = new Cars(input);
                }
        ).withMessageContaining(GameErrorCode.CAR_NAME_EMPTY_ERROR.getErrorMessage());

    }

    @ParameterizedTest
    @ValueSource(strings = {"test123"})
    void Car_이름_분리_길이_실패(String input) {
        assertThatExceptionOfType(GameException.class).isThrownBy(
                () -> {
                    cars = new Cars(input);
                }
        ).withMessageContaining(GameErrorCode.CAR_NAME_LENGTH_ERROR.getErrorMessage());
    }
}
