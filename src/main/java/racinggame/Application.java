package racinggame;

import racinggame.domain.Cars;
import racinggame.domain.TryCount;
import racinggame.message.MessageHandler;

public class Application {
    public static void main(String[] args) {
        MessageHandler messageHandler = new MessageHandler();
        Cars cars = messageHandler.askingCars();
        TryCount tryCount = messageHandler.askingTryCount();
        messageHandler.printGameResult(new GamePlayer().play(cars, tryCount));
    }
}
