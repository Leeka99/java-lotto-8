package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.util.config.LottoConfig;

public class LottoGenerator implements LottoGeneration {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LottoConfig.LOTTO_START_NUMBER.getNumber(),
            LottoConfig.LOTTO_END_NUMBER.getNumber(), LottoConfig.LOTTO_LENGTH.getNumber());
    }
}