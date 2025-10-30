package lotto.controller;

import lotto.domain.CalculateWinning;
import lotto.view.output.OutputWinningCount;
import lotto.view.output.OutputWinningRate;

public class OutputController {

    public OutputController() {
        OutputWinningCount.printWinningIntro();
        OutputWinningCount.printWinningCount(CalculateWinning.getLottoResult());
        OutputWinningRate.printRate(CalculateWinning.getRate());
    }

}
