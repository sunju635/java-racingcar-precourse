package racinggame;

import racinggame.domain.Cars;
import racinggame.domain.Result;
import racinggame.domain.TryCount;

/**
 * @author 정선주
 * @version 1.0
 * @since 1.0
 */
public class GamePlayer {
    public Result play(Cars cars, TryCount tryCount) {
        Result result = new Result();
        for(int i = 0; i < tryCount.getTryCount(); i++) {
            cars.forward(); //자동차 전진
            result.add(cars); //게임 결과 저장
        }

        return result;
    }
}
