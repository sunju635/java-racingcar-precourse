package racinggame.message;

import nextstep.utils.Console;
import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.TryCount;
import racinggame.exception.GameException;

public class MessageHandler {

    public Cars askingCars() {
        try {
            Console.printLine(NoticeMessage.INPUT_CARS_ASK_MESSAGE.getMessage());
            return new Cars(Console.readLine());
        } catch (GameException e) {
            Console.printLine(e.getMessage());
            return askingCars();
        }
    }

    public TryCount askingTryCount() {
        try {
            Console.printLine(NoticeMessage.INPUT_GAME_TRY_COUNT.getMessage());
            return new TryCount(Console.readLine());
        } catch (GameException e) {
            Console.printLine(e.getMessage());
            return askingTryCount();
        }
    }

    public void printGameUnitResult(Cars cars) {
        Console.printLine("");
        for(Car car : cars.getCars()) {
            Console.printLine(car.getCar() + " : " + car.getStep().getResultStep());
        }
    }

    public void printGameResult() {

    }
}
