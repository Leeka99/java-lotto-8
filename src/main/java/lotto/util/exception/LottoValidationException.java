package lotto.util.exception;

import lotto.util.exception.messege.LottoExceptionMessage;

public class LottoValidationException extends IllegalArgumentException {

    public LottoValidationException(LottoExceptionMessage lottoException) {
        super(lottoException.getMessage());
    }
}
