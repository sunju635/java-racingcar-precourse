package racinggame.message;

public enum NoticeMessage {
    INPUT_CARS_ASK_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_GAME_TRY_COUNT("시도할 회수는 몇회인가요?");

    private String message;

    NoticeMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
