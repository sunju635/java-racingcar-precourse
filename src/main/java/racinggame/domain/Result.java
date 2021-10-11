package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 정선주
 * @version 1.0
 * @since 1.0
 */
public class Result {
    List<Cars> results;

    public Result() {
        this.results = new ArrayList<>();
    }

    public void add(Cars cars) {
        this.results.add(cars.makeNewCars());
    }

    public List<Cars> toList() {
        return results;
    }

    public List<Car> getWinners() {
        Cars resultCars = this.results.get(results.size()-1);
        return resultCars.getWinners();
    }
}
