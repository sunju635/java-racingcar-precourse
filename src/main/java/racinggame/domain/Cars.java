package racinggame.domain;

import java.util.List;

public class Cars {
    private List<String> cars;

    public Cars(String cars) {
    }

    public String get(int i) {
        return cars.get(i);
    }

    public int size() {
        return cars.size();
    }

}
