package lotto.util.exception;

public class BonusValidationException extends IllegalArgumentException {

    public static final String NOT_BLANK = "[ERROR] 공백입력 불가합니다. 1 ~ 45 사이의 숫자 1개를 입력해주세요.";
    public static final String NOT_DIGIT = "[ERROR] 숫자 1개만 입력해주세요.";
    public static final String NOT_ZERO = "[ERROR] 0 입력 불가. 1 ~ 45 사이의 숫자 1개만 입력해주세요.";
    public static final String OVER_LOTTO_NUMBER = "[ERROR] 45 초과 입력 불가. 1 ~ 45 사이의 숫자 1개만 입력해주세요.";
    public static final String NOT_DUPLICATE_NUMBER = "[ERROR] 1 ~ 45 사이의 로또 번호와 중복되지 않는 값 1개를 입력해주세요.";

    public BonusValidationException(String message) {
        super(message);
    }
}
