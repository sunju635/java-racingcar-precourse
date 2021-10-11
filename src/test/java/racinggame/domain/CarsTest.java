package racinggame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.exception.GameException;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    Cars cars;

    @ParameterizedTest
    @ValueSource(strings = {"test1,test2", "test1", " test1, test2 "})
    void Car_이름_분리(String input) throws GameException {
        cars = new Cars(input);
        String[] array = input.split(",");

        assertThat(cars.size()).isEqualTo(array.length); //길이 확인

        for(int i = 0; i < cars.size(); i++) {
            assertThat(cars.get(i)).doesNotContain(" "); //공백 제거 확인
            assertThat(cars.get(i)).isEqualTo(array[i].replaceAll(" ", "")); //item 확인
        }
    }
}
