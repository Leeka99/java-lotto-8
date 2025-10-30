package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoPapers {

    private static int paperNumber;
    private static List<List<Integer>> lottos = new ArrayList<>();
    private static final int MONEY_START = 1000;
    private static final int CHECK_MONEY_VALUE = 0;
    private static final int START_INDEX = 0;

    LottoGeneration lotto;

    public LottoPapers(int money) {
        validate(money);
        LottoPapers.paperNumber = calculateLottoPaperNumber(money);
        this.lotto = new LottoGenerator();
        generateLotto(paperNumber);
    }

    private void validate(int money) {
        if (money < MONEY_START) {
            throw new IllegalArgumentException("[ERROR] 1000원 이하는 입력할 수 없습니다. 1000원 단위로 입력해주세요.");
        }
        if (money % MONEY_START != CHECK_MONEY_VALUE) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }

    private int calculateLottoPaperNumber(int money) {
        return money / MONEY_START;
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
        for (int index = START_INDEX; index < lottoPaperNumber; index++) {
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
