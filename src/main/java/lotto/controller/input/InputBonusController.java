package lotto.controller.input;

import lotto.view.input.Input;
import lotto.view.input.InputBonusNumber;
import lotto.view.input.InputWinningNumber;
import lotto.view.output.InputMessage;

public class InputBonusController {

    public InputBonusController() {
        inputBonus();
    }

    private void inputBonus() {
        while (true) {
            try {
                InputMessage.bonus();
                new InputBonusNumber(Input.read(), InputWinningNumber.getWinningNumber());
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
