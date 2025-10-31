package lotto.view.input;

import lotto.util.exception.MoneyValidationException;
import lotto.util.exception.message.MoneyExceptionMessage;

public class InputMoney {

    private static int money;

    public InputMoney(String input) {
        validate(input);
        parseToInt(input);
    }

    private void validate(String input) {
        if (input.isBlank()) {
            throw new MoneyValidationException(MoneyExceptionMessage.NOT_BLANK);
        }
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new MoneyValidationException(MoneyExceptionMessage.NOT_DIGIT);
        }
    }

    private void parseToInt(String money) {
        InputMoney.money = Integer.parseInt(money);
    }

    public static int getMoney() {
        return money;
    }

}
