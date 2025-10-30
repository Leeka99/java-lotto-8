package lotto.util.exception;

public class LottoValidationException extends IllegalArgumentException {

    public static final String NOT_BLANK = "[ERROR] 공백입력 불가합니다. 1 ~ 45 사이의 숫자를 입력해주세요.";
    public static final String NOT_REST = "[ERROR] (,) 쉼표 외 문자는 입력 불가합니다.";
    public static final String NOT_SIX = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String DUPLICATE_NUMBERS = "[ERROR] 중복된 숫자는 입력할 수 없습니다.";
    public static final String NOT_ZERO = "[ERROR] 0 입력 불가. 1 ~ 45 사이의 숫자를 입력해주세요.";
    public static final String OVER_LOTTO_NUMBER = "[ERROR] 45 초과 불가. 1 ~ 45 사이의 숫자를 입력해주세요.";

    public LottoValidationException(String message) {
        super(message);
    }
}
