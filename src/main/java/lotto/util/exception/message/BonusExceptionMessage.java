package lotto.util.exception.message;

public enum BonusExceptionMessage {
    NOT_BLANK("[ERROR] 공백입력 불가합니다. 1 ~ 45 사이의 숫자 1개를 입력해주세요."),
    NOT_DIGIT("[ERROR] 숫자 1개만 입력해주세요."),
    NOT_ZERO("[ERROR] 0 입력 불가. 1 ~ 45 사이의 숫자 1개만 입력해주세요."),
    OVER_LOTTO_NUMBER("[ERROR] 45 초과 입력 불가. 1 ~ 45 사이의 숫자 1개만 입력해주세요."),
    NOT_DUPLICATE_NUMBER("[ERROR] 1 ~ 45 사이의 당첨 번호와 중복되지 않는 값 1개를 입력해주세요.");

    private final String message;

    BonusExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
