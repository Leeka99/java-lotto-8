package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputWinningNumber {

    private static List<Integer> winningNumber;

    public InputWinningNumber() {
        String input = inputWinningNumber();
        parseToInt(validate(input));
    }

    private String inputWinningNumber() {
        return Console.readLine();
    }

    private List<String> seperate(String input) {
        return Arrays.stream(input.split(",")).toList();
    }

    private List<String> validate(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백입력 불가합니다. 1000원 이상 입력해주세요.");
        }

        List<String> winningNumber = seperate(input);
        for (String number : winningNumber) {
            if (!number.chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException("[ERROR] (,) 쉼표 외 문자는 입력 불가합니다.");
            }
        }
        return winningNumber;
    }

    private void parseToInt(List<String> input) {
        winningNumber = input.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    public static List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
