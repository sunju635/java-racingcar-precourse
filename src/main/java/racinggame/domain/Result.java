package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    List<Cars> results;

    public Result() {
        this.results = new ArrayList<>();
    }

    public void add(Cars cars) {
        List<Car> newCars = new ArrayList<>();
        for(Car car : cars.toList()) {
            newCars.add(new Car(car));
        }
        this.results.add(new Cars(newCars));
    }

    public List<Cars> toList() {
        return results;
    }
}
