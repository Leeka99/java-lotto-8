package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.exception.MoneyValidationException;

public class InputMoney {

    private static int money;

    public InputMoney() {
        String input = inputMoney();
        validate(input);
        parseToInt(input);
    }

    private String inputMoney() {
        return Console.readLine();
    }

    private void validate(String input) {
        if (input.isBlank()) {
            throw new MoneyValidationException(MoneyValidationException.NOT_BLANK);
        }
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new MoneyValidationException(MoneyValidationException.NOT_DIGIT);
        }
    }

    private void parseToInt(String money) {
        InputMoney.money = Integer.parseInt(money);
    }

    public static int getMoney() {
        return money;
    }

}
