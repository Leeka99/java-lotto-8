package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Collections;
import java.util.List;

public class InputBonusNumber {

    private static int bonus;
    private static final int startNumber = 1;
    private static final int endNumber = 45;
    private static final int EQUAL_VALUE = 1;

    public InputBonusNumber(List<Integer> winningNumbers) {
        String input = inputBonus();
        validate(input, winningNumbers);
        parseToInt(input);
    }

    private void validate(String input, List<Integer> winningNumbers) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백입력 불가합니다. 1000원 이상 입력해주세요.");
        }
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
        if (Integer.parseInt(input) < startNumber) {
            throw new IllegalArgumentException("[ERROR] 0 입력 불가. 1 ~ 45 사이의 숫자를 입력해주세요.");
        }
        if (endNumber < Integer.parseInt(input)) {
            throw new IllegalArgumentException("[ERROR] 45 초과 입력 불가. 1 ~ 45 사이의 숫자를 입력해주세요.");
        }
        if (Collections.frequency(winningNumbers, Integer.parseInt(input)) == EQUAL_VALUE) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 로또 번호와 중복되지 않는 값을 입력해주세요.");
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
