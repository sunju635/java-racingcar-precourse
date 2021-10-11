package racinggame.domain;

import racinggame.exception.GameException;
import racinggame.exception.GameExceptionChecker;

import java.util.Objects;

public class Car {
    String car;

    public Car(String car) throws GameException {
        new GameExceptionChecker().checkCar(car);
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car1 = (Car) o;
        return Objects.equals(car, car1.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car);
    }
}
