package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator implements LottoGeneration {

    private static final int startNumber = 1;
    private static final int endNumber = 45;
    private static final int count = 6;

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(startNumber, endNumber, count);
    }
}