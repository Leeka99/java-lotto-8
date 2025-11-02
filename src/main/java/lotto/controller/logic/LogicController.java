package lotto.controller.logic;

import lotto.domain.Lotto;
import lotto.domain.LottoPapers;
import lotto.domain.caculate.CalculateRate;
import lotto.domain.caculate.CalculateLottoResult;
import lotto.domain.caculate.CalculateTotalPrize;
import lotto.domain.fomatting.PrizeFormatter;
import lotto.domain.fomatting.RateFormatter;
import lotto.view.input.InputBonusNumber;
import lotto.view.input.InputMoney;
import lotto.view.input.InputWinningNumber;

public class LogicController {

    public LogicController() {
        new Lotto(InputWinningNumber.getWinningNumber());
        new CalculateLottoResult(LottoPapers.getLottos(), InputWinningNumber.getWinningNumber(),
            InputBonusNumber.getBonusNumber());
        new CalculateTotalPrize(CalculateLottoResult.getLottoResult());
        new CalculateRate(InputMoney.getMoney(), CalculateTotalPrize.getTotalPrize());
        new PrizeFormatter();
        new RateFormatter(CalculateRate.getRate());
    }
}
