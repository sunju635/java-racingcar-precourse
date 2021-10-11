package racinggame.domain;

import racinggame.exception.GameException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(String cars) throws GameException {
        String[] carArray = cars.split(",");
        this.cars = new ArrayList<>();
        for(String car : carArray) {
            this.cars.add(new Car(car.trim()));
        }
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }


    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public Car get(int i) {
        return cars.get(i);
    }

    public int size() {
        return cars.size();
    }

    public void forward() {
        for(Car car : this.cars) {
            car.forward();
        }
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}
