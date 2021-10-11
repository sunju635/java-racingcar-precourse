package racinggame;

import racinggame.domain.Cars;
import racinggame.domain.Result;
import racinggame.domain.TryCount;

public class GamePlayer {
    public Result play(Cars cars, TryCount tryCount) {
        Result result = new Result();
        for(int i = 0; i < tryCount.getTryCount(); i++) {
            cars.forward();
            result.add(cars);
        }

        return result;
    }
}
