package racinggame.domain;

import racinggame.exception.GameException;

import java.util.ArrayList;
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

    public Car get(int i) {
        return cars.get(i);
    }

    public int size() {
        return cars.size();
    }

}
