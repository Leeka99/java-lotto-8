package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.LottoGenerator;
import lotto.util.config.MoneyConfig;
import lotto.util.config.NumberConfig;
import lotto.util.exception.MoneyValidationException;
import lotto.util.exception.message.MoneyExceptionMessage;
import org.assertj.core.util.VisibleForTesting;

public class LottoPapers {

    private static int paperNumber;
    private static List<List<Integer>> lottos = new ArrayList<>();

    LottoGenerator lottoGenerator;

    public LottoPapers(int money, LottoGenerator lottoGenerator) {
        validate(money);
        LottoPapers.paperNumber = calculateLottoPaperNumber(money);
        this.lottoGenerator = lottoGenerator;
        generateLotto(paperNumber);
    }

    @VisibleForTesting
    LottoPapers(int money) {
        validate(money);
        LottoPapers.paperNumber = calculateLottoPaperNumber(money);
    }

    @VisibleForTesting
    static void reset() {
        paperNumber = NumberConfig.START_NUMBER.getNumber();
        lottos = new ArrayList<>();
    }

    private void validate(int money) {
        if (money < MoneyConfig.MONEY_START.getNumber()) {
            throw new MoneyValidationException(MoneyExceptionMessage.NOT_ENOUGT_MONEY);
        }
        if (money % MoneyConfig.MONEY_START.getNumber()
            != MoneyConfig.CHECK_MONEY_VALUE.getNumber()) {
            throw new MoneyValidationException(MoneyExceptionMessage.NOT_REMAINDER_ZERO);
        }
    }

    private int calculateLottoPaperNumber(int money) {
        return money / MoneyConfig.MONEY_START.getNumber();
    }

    private List<Integer> lotto() {
        return lottoGenerator.generate();
    }

    private List<Integer> sortLotto() {
        List<Integer> lottoNumbers = new ArrayList<>(lotto());
        Collections.sort(lottoNumbers, Integer::compareTo);
        return lottoNumbers;
    }

    private void generateLotto(int lottoPaperNumber) {
        for (int index = NumberConfig.START_NUMBER.getNumber(); index < lottoPaperNumber; index++) {
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
