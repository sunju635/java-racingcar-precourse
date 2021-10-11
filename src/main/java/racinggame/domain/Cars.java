package racinggame.domain;

import common.utils.StringUtils;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private List<String> cars;

    public Cars(String cars) {
        this.cars = Arrays.asList(StringUtils.removeEmptyText(cars).split(","));
    }

    public String get(int i) {
        return cars.get(i);
    }

    public int size() {
        return cars.size();
    }

}
