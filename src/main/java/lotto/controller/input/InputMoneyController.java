package lotto.controller.input;

import lotto.domain.LottoPapers;
import lotto.util.LottoGenerator;
import lotto.util.RandomLottoGenerator;
import lotto.view.input.Input;
import lotto.view.input.InputMoney;
import lotto.view.output.InputMessage;
import lotto.view.output.OutputLottoPapers;

public class InputMoneyController {

    LottoGenerator lottoGenerator = new RandomLottoGenerator();

    public InputMoneyController() {
        inputMoney();
    }

    private void inputMoney() {
        while (true) {
            try {
                InputMessage.money();
                new InputMoney(Input.read());
                new LottoPapers(InputMoney.getMoney(), lottoGenerator);
                OutputLottoPapers.printPaperNumber(LottoPapers.getPaperNumber());
                OutputLottoPapers.printLottoPapers(LottoPapers.getLottos());
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
