package lotto.controller;

import lotto.controller.input.InputController;
import lotto.controller.logic.LogicController;
import lotto.controller.output.OutputController;

public class LottoController {

    public LottoController() {
        new InputController();
        new LogicController();
        new OutputController();
    }
}
