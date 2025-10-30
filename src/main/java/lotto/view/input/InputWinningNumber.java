package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.exception.LottoValidationException;
import lotto.util.exception.message.LottoExceptionMessage;

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
            throw new LottoValidationException(LottoExceptionMessage.NOT_BLANK);
        }

        List<String> winningNumber = seperate(input);
        for (String number : winningNumber) {
            if (!number.chars().allMatch(Character::isDigit)) {
                throw new LottoValidationException(LottoExceptionMessage.NOT_REST);
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
