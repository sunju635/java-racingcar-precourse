package racinggame.message;

import nextstep.utils.Console;
import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.Result;
import racinggame.domain.TryCount;
import racinggame.exception.GameException;

import java.util.List;

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

    private void printGameUnitResult(Result result) {
        Console.printLine("\n" + NoticeMessage.OUTPUT_GAME_UNIT_RESULT_TITLE.getMessage());
        for(Cars cars : result.toList()) {
            Console.printLine(cars.getGameResultText());
        }
    }

    public void printGameResult(Result result) {
        printGameUnitResult(result);
        Console.printLine(String.format(NoticeMessage.OUTPUT_GAME_RESULT.getMessage(), makeWinnerText(result.getWinners())));
    }

    private String makeWinnerText(List<Car> resultCar) {
        String[] carNames = new String[resultCar.size()];
        for(int i = 0; i < resultCar.size(); i++) {
            carNames[i] = resultCar.get(i).getCar();
        }

        return String.join(",", carNames);
    }
}
