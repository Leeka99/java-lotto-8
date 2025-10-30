package lotto.util.exception;

import lotto.util.exception.message.BonusExceptionMessage;

public class BonusValidationException extends IllegalArgumentException {

    public BonusValidationException(BonusExceptionMessage bonusException) {
        super(bonusException.getMessage());
    }
}
