package racinggame.domain;

import racinggame.exception.GameException;
import racinggame.exception.GameExceptionChecker;

public class Car {
    String car;

    public Car(String car) throws GameException {
        new GameExceptionChecker().checkCar(car);
        this.car = car;
    }
}
