package racinggame.message;

import nextstep.utils.Console;
import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.Result;
import racinggame.domain.TryCount;
import racinggame.exception.GameException;

import java.util.List;

/**
 * @author 정선주
 * @version 1.0
 * @since 1.0
 */
public class MessageHandler {

    /**
     * 자동차 이름을 묻는다.
     * <p>
     * 자동차 이름을 묻고, Cars를 리턴한다.
     * </p>
     */
    public Cars askingCars() {
        try {
            Console.printLine(NoticeMessage.INPUT_CARS_ASK_MESSAGE.getMessage());
            return new Cars(Console.readLine());
        } catch (GameException e) {
            Console.printLine(e.getMessage());
            return askingCars();
        }
    }

    /**
     * 시도 회수를 묻는다.
     * <p>
     * 시도 회수를 묻고, TryCount를 리턴한다.
     * </p>
     */
    public TryCount askingTryCount() {
        try {
            Console.printLine(NoticeMessage.INPUT_GAME_TRY_COUNT.getMessage());
            return new TryCount(Console.readLine());
        } catch (GameException e) {
            Console.printLine(e.getMessage());
            return askingTryCount();
        }
    }

    /**
     * 게임 단계 별 결과를 프린트한다.
     *
     * @param result 게임 결과
     */
    private void printGameUnitResult(Result result) {
        Console.printLine("\n" + NoticeMessage.OUTPUT_GAME_UNIT_RESULT_TITLE.getMessage());
        for(Cars cars : result.toList()) {
            Console.printLine(cars.getGameResultText());
        }
    }

    /**
     * 게임 결과를 프린트한다.
     *
     * @param result 게임 결과
     */
    public void printGameResult(Result result) {
        printGameUnitResult(result);
        Console.printLine(String.format(NoticeMessage.OUTPUT_GAME_RESULT.getMessage(), makeWinnerText(result.getWinners())));
    }

    /**
     * 게임 최종 우승자 리스트를 문자열로 생성한다.
     *
     * @param resultCar 우승자 리스트
     */
    private String makeWinnerText(List<Car> resultCar) {
        String[] carNames = new String[resultCar.size()];
        for(int i = 0; i < resultCar.size(); i++) {
            carNames[i] = resultCar.get(i).getCar();
        }

        return String.join(",", carNames);
    }
}
