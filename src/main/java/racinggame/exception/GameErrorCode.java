package racinggame.exception;

public enum GameErrorCode {
    CAR_NAME_LENGTH_ERROR("0001", "자동차 이름은 5자 이하만 가능합니다."),
    CAR_NAME_EMPTY_ERROR("0002", "자동차 이름에 빈 값을 넣을 수 없습니다.");

    private String errorCode;
    private String errorMessage;

    GameErrorCode(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
