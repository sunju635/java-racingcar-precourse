package racinggame.exception;

import java.util.List;

public class GameExceptionChecker {
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private void checkCarEmpty(String car) throws GameException {
        if(car.length() < 1) {
            throw new GameException(GameErrorCode.CAR_NAME_EMPTY_ERROR);
        }
    }

    private void checkCarLength(String car) throws GameException {
        if(car.length() > CAR_NAME_MAX_LENGTH) {
            throw new GameException(GameErrorCode.CAR_NAME_LENGTH_ERROR);
        }
    }

    public void checkCar(String car) throws GameException {
        checkCarEmpty(car);
        checkCarLength(car);
    }

    public void checkTryCountEmpty(String tryCount) throws GameException {
        if(tryCount.replaceAll(" ", "").length() < 1) {
            throw  new GameException(GameErrorCode.TRY_COUNT_EMPTY_ERROR);
        }
    }
}
