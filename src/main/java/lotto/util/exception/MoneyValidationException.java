package lotto.util.exception;

import lotto.util.exception.message.MoneyExceptionMessage;

public class MoneyValidationException extends IllegalArgumentException {

    public MoneyValidationException(MoneyExceptionMessage MoneyException) {
        super(MoneyException.getMessage());
    }
}
