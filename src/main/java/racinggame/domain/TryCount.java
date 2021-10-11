package racinggame.domain;

import racinggame.exception.GameErrorCode;
import racinggame.exception.GameException;
import racinggame.exception.GameExceptionChecker;

public class TryCount {
    int tryCount;

    public TryCount(String tryCount) throws GameException {
        new GameExceptionChecker().checkTryCountEmpty(tryCount);
        try {
            this.tryCount = Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new GameException(GameErrorCode.TRY_COUNT_FORMAT_ERROR);
        }
    }
}
