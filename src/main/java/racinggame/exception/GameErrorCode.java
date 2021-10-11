package racinggame.exception;

/**
 * @author 정선주
 * @version 1.0
 * @since 1.0
 */
public enum GameErrorCode {
    CAR_NAME_LENGTH_ERROR("0001", "자동차 이름은 5자 이하만 가능합니다."),
    CAR_NAME_EMPTY_ERROR("0002", "자동차 이름에 빈 값을 넣을 수 없습니다."),
    TRY_COUNT_FORMAT_ERROR("0003", "시도할 회수는 숫자만 가능합니다."),
    TRY_COUNT_EMPTY_ERROR("0004", "시도할 회수로 빈 값을 입력 할 수 없습니다."),
    TRY_COUNT_MIN_ERROR("0005", "시도할 회수로 0이하를 입력 할 수 없습니다.");

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
