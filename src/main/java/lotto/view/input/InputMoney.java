package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

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

    private void validate (String input) {
        if (input.isBlank()) throw new IllegalArgumentException("[ERROR] 공백입력 불가합니다. 1000원 이상 입력해주세요.");
        if (!input.chars().allMatch(Character::isDigit)) throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
    }

    private void parseToInt(String money){
        InputMoney.money = Integer.parseInt(money);
    }

    public static int getMoney() {
        return money;
    }

}
