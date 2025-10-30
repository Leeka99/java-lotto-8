package lotto.domain;

import java.util.ArrayList;
import java.util.List;

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
        if (money == 0) {
            throw new IllegalArgumentException("[ERROR] 0은 입력할 수 없습니다. 1000원 단위로 입력해주세요.");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }

    private int calculateLottoPaperNumber(int money) {
        return money / 1000;
    }

    private List<Integer> lotto() {
        return lotto.generate();
    }

    private void generateLotto(int lottoPaperNumber) {
        for (int i = 0; i < lottoPaperNumber; i++) {
            lottos.add(lotto());
        }
    }

    public static int getPaperNumber() {
        return paperNumber;
    }

    public static List<List<Integer>> getLottos() {
        return lottos;
    }
}
