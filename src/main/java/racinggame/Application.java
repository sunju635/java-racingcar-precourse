package racinggame;

import racinggame.domain.Cars;
import racinggame.domain.TryCount;
import racinggame.message.MessageHandler;

/**
 * @author 정선주
 * @version 1.0
 * @since 1.0
 */
public class Application {
    public static void main(String[] args) {
        MessageHandler messageHandler = new MessageHandler();
        Cars cars = messageHandler.askingCars(); // 자동차 이름 묻기
        TryCount tryCount = messageHandler.askingTryCount(); // 시도 회수 묻기
        messageHandler.printGameResult(new GamePlayer().play(cars, tryCount)); // 게임 플레이
    }
}
