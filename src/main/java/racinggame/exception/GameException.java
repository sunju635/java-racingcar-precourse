package racinggame.exception;

public class GameException extends Exception{

    private static final long serialVersionUID = -3019519842035966146L;

    private GameErrorCode gameErrorCode;

    public GameException(GameErrorCode gameErrorCode) {
        super("[ERROR] " + gameErrorCode.getErrorMessage());
        this.gameErrorCode = gameErrorCode;
    }
}
