package lotto.controller.input;

import lotto.domain.Lotto;
import lotto.view.input.Input;
import lotto.view.input.InputWinningNumber;
import lotto.view.output.InputMessage;

public class InputWinningNumberController {

    public InputWinningNumberController() {
        inputWinningNumber();
    }

    private void inputWinningNumber() {
        while (true) {
            try {
                InputMessage.winningNumber();
                new InputWinningNumber(Input.read());
                new Lotto(InputWinningNumber.getWinningNumber());
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
