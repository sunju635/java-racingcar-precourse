package racinggame.domain;

import racinggame.exception.GameException;
import racinggame.exception.GameExceptionChecker;

import java.util.Objects;

/**
 * @author 정선주
 * @version 1.0
 * @since 1.0
 */
public class Car {

    private String car;
    private Step step;

    public Car(String car) throws GameException {
        new GameExceptionChecker().checkCar(car);
        this.car = car;
        step = new Step(0);
    }

    public Car(Car car) {
        this.car = car.getCar();
        this.step = new Step(car.getStep().getStep());
    }

    /**
     * 앞으로 전진
     * <p>
     * 랜덤한 숫자만큼 앞으로 전진한다.
     * </p>
     */
    public void forward() {
        step.forward();
    }

    /**
     * 우승자인지 확인
     * <p>
     * 우승자인지 확인한다.
     * </p>
     *
     * @param winner 우승자
     */
    public boolean isWinner(Car winner) {
        return winner.getStep().getStep() <= step.getStep() ? true : false;
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

    @Override
    public String toString() {
        return "Car{" +
                "car='" + car + '\'' +
                ", step=" + step +
                '}';
    }

    public String getCar() {
        return car;
    }

    public Step getStep() {
        return step;
    }
}
