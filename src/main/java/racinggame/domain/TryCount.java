package racinggame.domain;

import racinggame.exception.GameErrorCode;
import racinggame.exception.GameException;
import racinggame.exception.GameExceptionChecker;

public class TryCount {

    private int tryCount;

    public TryCount(String tryCount) throws GameException {
        GameExceptionChecker gameExceptionChecker = new GameExceptionChecker();
        gameExceptionChecker.checkTryCountEmpty(tryCount);
        try {
            this.tryCount = Integer.parseInt(tryCount);
            gameExceptionChecker.checkTryCountNumber(this.tryCount);
        } catch (NumberFormatException e) {
            throw new GameException(GameErrorCode.TRY_COUNT_FORMAT_ERROR);
        }
    }

    public int getTryCount() {
        return tryCount;
    }

    @Override
    public String toString() {
        return "TryCount{" +
                "tryCount=" + tryCount +
                '}';
    }
}
