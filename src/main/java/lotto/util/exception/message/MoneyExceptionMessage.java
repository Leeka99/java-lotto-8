package lotto.util.exception.message;

public enum MoneyExceptionMessage {
    NOT_BLANK("[ERROR] 공백입력 불가합니다. 1000원 이상 입력해주세요."),
    NOT_DIGIT("[ERROR] 숫자만 입력해주세요."),
    NOT_ENOUGT_MONEY("[ERROR] 1000원 이하는 입력할 수 없습니다. 1000원 단위로 입력해주세요."),
    NOT_REMAINDER_ZERO("[ERROR] 1000원 단위로 입력해주세요.");

    private final String message;

    MoneyExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
