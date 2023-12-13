package bridge.domain;

public enum ErrorMessage {
    OUT_OF_RANGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_VALUE("[ERROR] 올바른 값이 아닙니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
