package lotto.util.exception;

public class MoneyValidationException extends IllegalArgumentException {

    public static final String NOT_BLANK = "[ERROR] 공백입력 불가합니다. 1000원 이상 입력해주세요.";
    public static final String NOT_DIGIT = "[ERROR] 숫자만 입력해주세요.";
    public static final String NOT_ENOUGT_MONEY = "[ERROR] 1000원 이하는 입력할 수 없습니다. 1000원 단위로 입력해주세요.";
    public static final String NOT_REMAINDER_ZERO = "[ERROR] 1000원 단위로 입력해주세요.";

    public MoneyValidationException(String message) {
        super(message);
    }
}
