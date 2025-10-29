package lotto.controller;

import lotto.domain.LottoPapers;
import lotto.view.input.InputBonusNumber;
import lotto.view.input.InputMoney;
import lotto.view.input.InputWinningNumber;
import lotto.view.output.InputMessage;
import lotto.view.output.OutputLottoPapers;

public class InputController {

    public InputController() {
        while (true) {
            try {
                InputMessage.money();
                new InputMoney();
                new LottoPapers(InputMoney.getMoney());
                OutputLottoPapers.printPaperNumber(LottoPapers.getPaperNumber());
                OutputLottoPapers.printLottoPapers(LottoPapers.getLottos());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                InputMessage.winningNumber();
                new InputWinningNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                InputMessage.bonus();
                new InputBonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
