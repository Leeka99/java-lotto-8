package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputBonusNumber {

    private static int bonus;

    public InputBonusNumber() {
        String input = inputBonus();
        validate(input);
        parseToInt(input);
    }

    private void validate(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백입력 불가합니다. 1000원 이상 입력해주세요.");
        }
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    private String inputBonus() {
        return Console.readLine();
    }

    private void parseToInt(String input) {
        bonus = Integer.parseInt(input);
    }

    public static int getBonusNumber() {
        return bonus;
    }

}
