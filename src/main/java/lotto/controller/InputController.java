package lotto.controller;

import lotto.view.input.InputMoney;
import lotto.view.input.InputWinningNumber;
import lotto.view.output.InputMessage;

public class InputController {

    public InputController() {
        InputMessage.money();
        new InputMoney();

        InputMessage.winningNumber();
        new InputWinningNumber();
    }
}
