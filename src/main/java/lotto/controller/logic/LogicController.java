package lotto.controller.logic;

import java.util.List;
import lotto.domain.caculate.CalculateLottoResult;
import lotto.domain.caculate.CalculateRate;
import lotto.domain.caculate.CalculateTotalPrize;
import lotto.domain.fomatting.PrizeFormatter;
import lotto.domain.fomatting.RateFormatter;

public class LogicController {

    public LogicController(int money, List<Integer> winningNumbers, List<List<Integer>> lottos,
        int bonus) {
        new CalculateLottoResult(lottos, winningNumbers, bonus);
        new CalculateTotalPrize(CalculateLottoResult.getLottoResult());
        new CalculateRate(money, CalculateTotalPrize.getTotalPrize());
        new PrizeFormatter();
        new RateFormatter(CalculateRate.getRate());
    }
}
