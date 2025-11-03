package lotto.controller;

import lotto.controller.input.InputController;
import lotto.controller.logic.LogicController;
import lotto.controller.output.OutputController;
import lotto.domain.LottoPapers;
import lotto.view.input.InputBonusNumber;
import lotto.view.input.InputMoney;
import lotto.view.input.InputWinningNumber;

public class LottoController {

    public LottoController() {
        new InputController();
        new LogicController(InputMoney.getMoney(), InputWinningNumber.getWinningNumber(), LottoPapers.getLottos(), InputBonusNumber.getBonusNumber());
        new OutputController();
    }
}
