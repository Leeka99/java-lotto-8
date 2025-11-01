package lotto.controller;

import lotto.domain.CalculateWinning;
import lotto.domain.Lotto;
import lotto.domain.LottoPapers;
import lotto.view.input.InputBonusNumber;
import lotto.view.input.InputMoney;
import lotto.view.input.InputWinningNumber;

public class LogicController {

    public LogicController() {
        new Lotto(InputWinningNumber.getWinningNumber());
        new CalculateWinning(LottoPapers.getLottos(), InputWinningNumber.getWinningNumber(),
            InputBonusNumber.getBonusNumber(), InputMoney.getMoney());
    }
}
