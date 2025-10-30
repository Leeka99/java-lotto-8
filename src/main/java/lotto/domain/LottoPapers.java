package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.config.NumberConfig;
import lotto.util.config.MoneyConfig;
import lotto.util.exception.MoneyValidationException;

public class LottoPapers {

    private static int paperNumber;
    private static List<List<Integer>> lottos = new ArrayList<>();


    LottoGeneration lotto;

    public LottoPapers(int money) {
        validate(money);
        LottoPapers.paperNumber = calculateLottoPaperNumber(money);
        this.lotto = new LottoGenerator();
        generateLotto(paperNumber);
    }

    private void validate(int money) {
        if (money < MoneyConfig.MONEY_START) {
            throw new MoneyValidationException(MoneyValidationException.NOT_ENOUGT_MONEY);
        }
        if (money % MoneyConfig.MONEY_START != MoneyConfig.CHECK_MONEY_VALUE) {
            throw new MoneyValidationException(MoneyValidationException.NOT_REMAINDER_ZERO);
        }
    }

    private int calculateLottoPaperNumber(int money) {
        return money / MoneyConfig.MONEY_START;
    }

    private List<Integer> lotto() {
        return lotto.generate();
    }

    private List<Integer> sortLotto() {
        List<Integer> lottoNumbers = new ArrayList<>(lotto());
        Collections.sort(lottoNumbers, Integer::compareTo);
        return lottoNumbers;
    }

    private void generateLotto(int lottoPaperNumber) {
        for (int index = NumberConfig.START_NUMBER; index < lottoPaperNumber; index++) {
            lottos.add(sortLotto());
        }
    }

    public static int getPaperNumber() {
        return paperNumber;
    }

    public static List<List<Integer>> getLottos() {
        return lottos;
    }
}
