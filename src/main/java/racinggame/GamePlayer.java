package racinggame;

import nextstep.utils.Console;
import racinggame.domain.Cars;
import racinggame.domain.TryCount;

public class GamePlayer {
    Cars cars;
    TryCount tryCount;

    public void play(Cars cars, TryCount tryCount) {
        for(int i = 0; i < tryCount.getTryCount(); i++) {
            cars.forward();
            /*테스트 용도로 추후 삭제 해야함*/
            Console.printLine("result: " + cars.toString());
        }
    }

}
