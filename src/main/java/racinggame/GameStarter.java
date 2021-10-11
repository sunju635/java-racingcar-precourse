package racinggame;

import nextstep.utils.Console;
import racinggame.domain.Cars;
import racinggame.domain.TryCount;
import racinggame.exception.GameException;
import racinggame.message.NoticeMessage;

public class GameStarter {
    Cars cars;
    TryCount tryCount;

    public void start() {
        askCars();
        askTryCount();
        new GamePlayer().play(cars, tryCount);
    }

    public void askCars() {
        try {
            Console.printLine(NoticeMessage.INPUT_CARS_ASK_MESSAGE.getMessage());
            cars = new Cars(Console.readLine());
        } catch (GameException e) {
            Console.printLine(e.getMessage());
            askCars();
        }
    }

    public void askTryCount() {
        try {
            Console.printLine(NoticeMessage.INPUT_GAME_TRY_COUNT.getMessage());
            tryCount = new TryCount(Console.readLine());
        } catch (GameException e) {
            Console.printLine(e.getMessage());
            askTryCount();
        }
    }
}
