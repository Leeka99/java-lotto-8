package lotto.controller.output;

import lotto.domain.caculate.CalculateLottoResult;
import lotto.domain.fomatting.PrizeFormatter;
import lotto.domain.fomatting.RateFormatter;
import lotto.view.output.OutputWinningCount;
import lotto.view.output.OutputWinningRate;

public class OutputController {

    public OutputController() {
        OutputWinningCount.printWinningIntro();
        OutputWinningCount.printWinningCount(PrizeFormatter.getPrize(),
            CalculateLottoResult.getLottoResult());
        OutputWinningRate.printRate(RateFormatter.getRate());
    }
}
