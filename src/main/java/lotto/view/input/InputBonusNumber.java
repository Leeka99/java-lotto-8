package lotto.view.input;

import java.util.Collections;
import java.util.List;
import lotto.util.config.LottoConfig;
import lotto.util.config.NumberConfig;
import lotto.util.exception.BonusValidationException;
import lotto.util.exception.message.BonusExceptionMessage;

public class InputBonusNumber {

    private static int bonus;

    public InputBonusNumber(String input, List<Integer> winningNumbers) {
        validate(input, winningNumbers);
        parseToInt(input);
    }

    private void validate(String input, List<Integer> winningNumbers) {
        if (input.isBlank()) {
            throw new BonusValidationException(BonusExceptionMessage.NOT_BLANK);
        }
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new BonusValidationException(BonusExceptionMessage.NOT_DIGIT);
        }
        if (Integer.parseInt(input) < LottoConfig.LOTTO_START_NUMBER.getNumber()) {
            throw new BonusValidationException(BonusExceptionMessage.NOT_ZERO);
        }
        if (LottoConfig.LOTTO_END_NUMBER.getNumber() < Integer.parseInt(input)) {
            throw new BonusValidationException(BonusExceptionMessage.OVER_LOTTO_NUMBER);
        }
        if (Collections.frequency(winningNumbers, Integer.parseInt(input))
            == NumberConfig.EQUAL_VALUE.getNumber()) {
            throw new BonusValidationException(BonusExceptionMessage.NOT_DUPLICATE_NUMBER);
        }

    }

    private void parseToInt(String input) {
        bonus = Integer.parseInt(input);
    }

    public static int getBonusNumber() {
        return bonus;
    }

}
